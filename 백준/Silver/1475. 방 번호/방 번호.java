import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] inputs = br.readLine().toCharArray();
        int[] count = new int[11];

        for (char input : inputs) {
            int inputNumber = Integer.parseInt(String.valueOf(input));
            if (inputNumber == 9) {
                count[6]++;
                continue;
            }
            count[inputNumber]++;
        }

        int max = Integer.MIN_VALUE;
        if (count[6] % 2 == 0) {
            count[6] = count[6] / 2;
        } else {
            count[6] = count[6] / 2 + 1;
        }
        for (int part : count) {

            if (part > max) {
                max = part;
            }
        }
        System.out.println(max);
        br.close();
    }
}
