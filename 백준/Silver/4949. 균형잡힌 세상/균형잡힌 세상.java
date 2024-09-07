import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    List<String> datas = inputData(br);
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
        if(chars[i] != '(' && chars[i] != ')' && chars[i] != '[' && chars[i] != ']'){
          continue;
        }
        if (!stack.isEmpty() && stack.peek() == '(' && chars[i] == ')') {
          stack.pop();
          continue;
        }
        if (!stack.isEmpty() && stack.peek() == '[' && chars[i] == ']') {
          stack.pop();
          continue;
        }
        stack.push(chars[i]);
      }
      if(stack.isEmpty()){
        results.add("yes");
      } else {
        results.add("no");
      }
    }
    return results;
  }

  private static List<String> inputData(BufferedReader br) throws IOException {
    List<String> datas = new ArrayList<>();
    while (true) {
      String temp = br.readLine();
      if (Objects.equals(temp, ".")) {
        break;
      }
      datas.add(temp);
    }
    return datas;
  }
}
