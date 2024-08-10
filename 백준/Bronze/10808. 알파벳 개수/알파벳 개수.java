import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //97 122
    String data = br.readLine();
    int[] result = calculate(data);
    String printResult = "";
    for (int i = 0; i < result.length; i++) {
      if (i == result.length - 1) {
        printResult += result[i];
        break;
      }
      printResult += result[i] + " ";
    }
    bw.write(printResult);

    br.close();
    bw.close();
  }

  private static int[] calculate(String data) {
    int[] result = new int[26];
    for (int i = 0; i < data.length(); i++) {
      result[data.charAt(i) - 97]++;
    }
    return result;
  }
}
