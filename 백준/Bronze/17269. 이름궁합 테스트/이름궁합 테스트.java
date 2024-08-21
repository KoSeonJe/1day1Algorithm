import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  private static final Map<Character, Integer> ALPHA_NUMBER = new HashMap<>() {{
    put('A', 3);
    put('B', 2);
    put('C', 1);
    put('D', 2);
    put('E', 4);
    put('F', 3);
    put('G', 1);
    put('H', 3);
    put('I', 1);
    put('J', 1);
    put('K', 3);
    put('L', 1);
    put('M', 3);
    put('N', 2);
    put('O', 1);
    put('P', 2);
    put('Q', 2);
    put('R', 2);
    put('S', 1);
    put('T', 2);
    put('U', 1);
    put('V', 1);
    put('W', 1);
    put('X', 2);
    put('Y', 2);
    put('Z', 1);
  }};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer n = new StringTokenizer(br.readLine());
    int n1 = Integer.parseInt(n.nextToken());
    int n2 = Integer.parseInt(n.nextToken());

    StringTokenizer name = new StringTokenizer(br.readLine(), " ");

    String name1 = name.nextToken();
    String name2 = name.nextToken();
    List<Integer> result = solve(name1, name2);
    if (result.get(0) == 0) {
      String resultValue = String.valueOf(result.get(1)) + "%";
      bw.write(resultValue);
    } else {
      String resultValue = String.valueOf(result.get(0)) + String.valueOf(result.get(1)) + "%";
      bw.write(resultValue);
    }
    br.close();
    bw.close();
  }

  private static List<Integer> solve(String name1, String name2) {
    List<Integer> data = new ArrayList<>();
    int maxLength = Math.max(name1.length(), name2.length());

    for (int i = 0; i < maxLength; i++) {
      if (i < name1.length()) {
        data.add(ALPHA_NUMBER.get(name1.charAt(i)));
      }
      if (i < name2.length()) {
        data.add(ALPHA_NUMBER.get(name2.charAt(i)));
      }
    }

    return calculate(data);
  }

  private static List<Integer> calculate(List<Integer> data) {
    if (data.size() <= 2) {
      return data;
    }

    List<Integer> temp = new ArrayList<>();
    for (int i = 0; i < data.size() - 1; i++) {
      int value = data.get(i) + data.get(i + 1);
      if (value >= 10) {
        temp.add(value % 10);
        continue;
      }
      temp.add(value);
    }
    return calculate(temp);
  }
}
