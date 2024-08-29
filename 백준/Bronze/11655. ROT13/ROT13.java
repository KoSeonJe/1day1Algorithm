import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String text = br.readLine();
    String result = convert(text);
    bw.write(result);
    br.close();
    bw.close();
  }

  private static String convert(String text) {
    // A~Z : 65~90
    // a~z : 97~122
    char[] chars = text.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] >= 'A' && chars[i] <= 'Z') {
        chars[i] = (char) ((chars[i] + 13 - 'A') % 26 + 'A');
      }
      if (chars[i] >= 'a' && chars[i] <= 'z') {
        chars[i] = (char) ((chars[i] + 13 - 'a') % 26 + 'a');
      }
    }
    return new String(chars);
  }
}
