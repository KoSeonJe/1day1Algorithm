import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int[] status = new int[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mn = br.readLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        String[][] problem = new String[5 * m + 1][5 * n + 1];
        for (int i = 0; i < 5 * m + 1; i++) {
            String temp = br.readLine();
            for (int j = 0; j < 5 * n + 1; j++) {
                problem[i][j] = String.valueOf(temp.charAt(j));
            }
        }

        for (int i = 0; 5 * i + 1 < problem.length; i++) {
            int jokeI = 5 * i + 1;
            for (int j = 0;  5 * j + 1 < problem[0].length; j++) {
                int jokeJ = 5 * j + 1;
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    if (problem[jokeI + k][jokeJ].equals("*")) {
                        count++;
                        continue;
                    }
                    break;
                }
                status[count]++;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int part : status) {
            builder.append(part).append(" ");
        }
        System.out.println(builder);
        br.close();
    }
}
