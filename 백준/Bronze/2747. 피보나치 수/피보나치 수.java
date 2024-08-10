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
    int result = calculate(n);
    bw.write(String.valueOf(result));
    br.close();
    bw.close();
  }

  private static int calculate(int n) {
    int sum = 0;
    int[] temp = new int[n + 1];
    temp[0] = 0;
    temp[1] = 1;
    for (int i = 2; i <=n ; i++) {
      sum = temp[i-2] + temp[i-1];
      temp[i] = sum;
    }
    return temp[n];
  }
}
