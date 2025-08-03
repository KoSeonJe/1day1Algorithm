import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int result = calculateContinuousMax(arr);

        System.out.println(result);
        br.close();
    }

    private static int calculateContinuousMax(final int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }

        int maxSum = dp[0];
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}
