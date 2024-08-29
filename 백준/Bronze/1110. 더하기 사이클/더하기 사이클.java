import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  private static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int num = Integer.parseInt(br.readLine());
    solveCycle(num, 0);

    bw.write(String.valueOf(count));

    br.close();
    bw.close();
  }

  private static void solveCycle(int num, int temp) {
    count++;
    if (count == 1) {
      temp = num;
    }
    int ten = temp / 10;
    int one = temp % 10;
    int sum = ten + one;
    int sumOne = sum >= 10 ? sum % 10 : sum;
    int newNum = one * 10 + sumOne % 10;
    if (num == newNum) {
      return;
    }
    solveCycle(num, newNum);
  }
}
