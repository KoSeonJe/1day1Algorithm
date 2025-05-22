import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = 0;

        int fiveMax = n / 5;

        for (int i = fiveMax; i >= 0; i--) {
            result += i;
            int rest = n - (5 * i);

            if (rest % 3 != 0) {
                result = 0;
                if (i == 0) {
                    result = -1;
                    break;
                }
                continue;
            }
            result += rest / 3;
            break;
        }

        System.out.println(result);

        br.close();
    }
}
