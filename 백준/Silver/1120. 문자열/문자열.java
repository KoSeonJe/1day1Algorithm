import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] parts = br.readLine().split(" ");
        String a = parts[0];
        String b = parts[1];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= b.length() - a.length(); i++) {
            String cutB = b.substring(i, a.length() + i);
            int diffTotal = calculateDiff(a, cutB);
            if (diffTotal < min) {
                min = diffTotal;
            }
        }
        System.out.println(min);
        br.close();
    }

    private static int calculateDiff(final String a, final String cutB) {
        int count = 0;

        for (int i = 0; i < a.length(); i++) {
            if (!Objects.equals(a.charAt(i), cutB.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
