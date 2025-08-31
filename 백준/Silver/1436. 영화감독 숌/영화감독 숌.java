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
    int results = getTitle(n);
    bw.write(String.valueOf(results));

    br.close();
    bw.close();
  }

  private static int getTitle(int n) {
    int count = 0;
    int temp = 666;
    String sTemp = String.valueOf(temp);
    while (count < n) {
      sTemp = String.valueOf(temp);
      if (sTemp.contains("666")) {
        count++;
      }
      temp++;
    }
    return Integer.parseInt(sTemp);
  }
}
