import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    List<String> datas = inputDatas(n, br);
    List<String> results = judge(datas);
    StringBuilder sb = new StringBuilder();
    for (String result : results) {
      sb.append(result).append("\n");
    }
    bw.write(sb.toString());
    br.close();
    bw.close();
  }

  private static List<String> judge(List<String> datas) {
    List<String> results = new ArrayList<>();
    for (String data : datas) {
      char[] chars = data.toCharArray();
      Stack<Character> stack = new Stack<>();
      for (int i = 0; i < chars.length; i++) {
        if (!stack.isEmpty() && stack.peek() == '(' && chars[i] == ')') {
          stack.pop();
        } else {
          stack.push(chars[i]);
        }
      }

      if (stack.isEmpty()) {
        results.add("YES");
      } else {
        results.add("NO");
      }
    }
    return results;
  }

  private static List<String> inputDatas(int n, BufferedReader br) throws IOException {
    List<String> datas = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      datas.add(br.readLine());
    }
    return datas;
  }
}
