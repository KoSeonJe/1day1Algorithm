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

    long result = allSum(n);
    bw.write(String.valueOf(result));
    br.close();
    bw.close();
  }

  private static long allSum(int n) {
    long sum = 0;

    for (int i = 1; i <= n; i++) {
      sum += (long)((n / i) * i);
    }
    return sum;
  }
}
