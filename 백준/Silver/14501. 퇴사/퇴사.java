import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] time = new int[n + 1];
    int[] pay = new int[n + 1];
    int[] dp = new int[n + 2];
    for (int i = 1; i <= n; i++) {
      String[] temp = br.readLine().split(" ");
      time[i] = Integer.parseInt(temp[0]);
      pay[i] = Integer.parseInt(temp[1]);
    }

    int max = calculate(n, time, pay, dp);
    bw.write(String.valueOf(max));
    br.close();
    bw.close();
  }

  private static int calculate(int n, int[] time, int[] pay, int[] dp) {
    int max = 0;
    for(int j = 1; j <= n + 1; j++) {
      dp[j] = Math.max(max, dp[j]);

      if(j <= n && j+time[j] <= n + 1) {
        dp[j + time[j]] = Math.max(dp[j] + pay[j], dp[j + time[j]]);
      }

      max = Math.max(max, dp[j]);
    }
    return max;
  }
}
