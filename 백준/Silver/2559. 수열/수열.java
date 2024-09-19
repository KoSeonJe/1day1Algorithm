import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] temperatures = inputTemp(N, br);
    int max = solve(temperatures, K);
    bw.write(String.valueOf(max));
    br.close();
    bw.close();
  }

  private static int solve(int[] temperatures, int K) {
    int front = 0;
    int back = K - 1;
    int max = Integer.MIN_VALUE;
    while (front <= temperatures.length - 1 - K + 1) {
      int total = total(temperatures, front, back);
      max = Math.max(max, total);
      front++;
      back++;
    }
    return max;
  }

  private static int total(int[] temperatures, int front, int back) {
    int sum = 0;
    for (int i = front; i <= back; i++) {
      sum += temperatures[i];
    }
    return sum;
  }

  private static int[] inputTemp(int n, BufferedReader br) throws IOException {
    int[] temperatures = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      temperatures[i] = Integer.parseInt(st.nextToken());
    }
    return temperatures;
  }
}
