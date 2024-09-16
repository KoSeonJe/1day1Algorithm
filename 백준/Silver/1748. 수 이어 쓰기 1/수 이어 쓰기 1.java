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
    int count = calculate(n);

    bw.write(String.valueOf(count));
    br.close();
    bw.close();
  }

  private static int calculate(int n) {
    int count = 0;
    int plus = 1;
    int num = 10;
    for (int i = 1; i <= n; i++) {
      if (i % num == 0) {
        plus++;
        num = num * 10;
      }
      count += plus;
    }

    return count;
  }
}
