import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 6개 12, 1개 3
    // 6개 15, 1개 4
    // 4개
    // 10개

    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        int minP = Integer.MAX_VALUE;
        int minO = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            String[] po = br.readLine().split(" ");
            int p = Integer.parseInt(po[0]);
            int o = Integer.parseInt(po[1]);

            minP = Math.min(minP, p);
            minO = Math.min(minO, o);
        }

        int min = extractMin(minP, minO);
        System.out.println(min);
    }

    private static int extractMin(final int p, final int o) {
        int min = Integer.MAX_VALUE;
        int iter = n / 6;

        if (iter < 1) {
            return Math.min(p, n * o);
        }
        for (int i = 0; i <= iter; i++) {
            int rest = n - i * 6;
            int min1 = rest * o + i * p;
            if (min > rest * o + i * p) {
                min = min1;
            }
        }
        min = Math.min((iter + 1) * p, min);
        return min;
    }
}
