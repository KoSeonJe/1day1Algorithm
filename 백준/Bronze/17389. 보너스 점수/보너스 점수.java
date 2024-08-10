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
    String[] datas = br.readLine().split("");
    int result = calculate(datas);
    bw.write(String.valueOf(result));
    br.close();
    bw.close();
  }

  private static int calculate(String[] datas) {
    int bonus = 0;
    int sum = 0;
    for (int i = 1; i <= datas.length; i++) {
      if (datas[i - 1].equals("O")) {
        sum += i + bonus;
        bonus++;
      } else if (datas[i - 1].equals("X")) {
        bonus = 0;
      }
    }
    return sum;
  }
}
