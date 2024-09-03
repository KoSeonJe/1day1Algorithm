import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    List<String> datas = inputTexts(n, br);
    List<BigInteger> results = extractNumbers(datas);
    StringBuilder sb = new StringBuilder();
    Collections.sort(results);
    for (BigInteger result : results) {
      sb.append(result).append("\n");
    }
    bw.write(sb.toString());
    br.close();
    bw.close();
  }

  private static List<BigInteger> extractNumbers(List<String> datas) {
    List<BigInteger> results = new ArrayList<>();
    for (String text : datas) {
      char[] chars = text.toCharArray();
      String temp = "";
      for (int i = 0; i < chars.length; i++) {
        if (Character.isDigit(chars[i])) {
          if (i != chars.length - 1 && Character.isDigit(chars[i + 1])) {
            temp += chars[i];
            continue;
          }
          if (i != 0 && Character.isDigit(chars[i - 1])) {
            temp += chars[i];
            if(!temp.isEmpty()){
              results.add(new BigInteger(String.valueOf(temp)));
            }
            temp = "";
            continue;
          }
          results.add(new BigInteger(String.valueOf(chars[i])));
        }
      }
    }
    return results;
  }

  private static List<String> inputTexts(int n, BufferedReader br) throws IOException {
    List<String> datas = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String text = br.readLine();
      datas.add(text);
    }
    return datas;
  }
}
