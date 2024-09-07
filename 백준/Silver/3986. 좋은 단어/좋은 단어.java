import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int count = 0;
    for (int i = 0; i < n; i++) {
      String word = br.readLine();
      if (isGoodWord(word)) {
        count++;
      }
    }
    bw.write(String.valueOf(count));
    br.close();
    bw.close();
  }

  private static boolean isGoodWord(String word) {
    Stack<Character> stack = new Stack<>();
    char[] chars = word.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (!stack.isEmpty() && stack.peek() == chars[i]) {
        stack.pop();
      } else {
        stack.push(chars[i]);
      }
    }
    return stack.isEmpty();
  }
}
