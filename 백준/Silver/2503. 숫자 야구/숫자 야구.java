import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static class info {
        int strike;
        int ball;
        String num;

        public info(int strike, int ball, String num) {
            this.strike = strike;
            this.ball = ball;
            this.num = num;
        }
    }

    static List<info> infos = new ArrayList<>();
    static List<String> answer = new ArrayList<>();
    static boolean[] numUsing = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] esb = br.readLine().split(" ");
            String expect = esb[0];
            int strike = Integer.parseInt(esb[1]);
            int ball = Integer.parseInt(esb[2]);
            infos.add(new info(strike, ball, expect));
        }

        searchN("", 0);
        System.out.println(answer.size());
        br.close();
    }

    private static void searchN(String num, int size) {
        if (size == 3) {
            numCheck(num);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!numUsing[i]) {
                numUsing[i] = true;
                searchN(num + i, size + 1);
                numUsing[i] = false;
            }
        }
    }

    private static void numCheck(String num) {
        for (info info : infos) {
            int s = 0;
            int b = 0;

            for (int i = 0; i < 3; i++) {
                if (info.num.charAt(i) == num.charAt(i)) {
                    s++;
                }
            }

            if (info.strike != s) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                int temp = (i + 1) % 3;
                if(num.charAt(i) == info.num.charAt(temp))
                    b++;
                temp = (i + 2) % 3;
                if(num.charAt(i) == info.num.charAt(temp))
                    b++;
            }

            if (info.ball != b) {
                return;
            }
        }
        answer.add(num);
    }
}
