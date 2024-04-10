import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    int f = Integer.parseInt(bf.readLine());

    Main c = new Main();
    int result = c.calculate(n, f);
    System.out.printf("%02d", result);
    bf.close();
  }

  public int calculate(int n, int f) {
    int temp = n / 100;
    int remakeN = temp * 100;

    int remain = remakeN % f;
    if (remain == 0) {
      return 0;
    }
    return f - remain;
  }
}
