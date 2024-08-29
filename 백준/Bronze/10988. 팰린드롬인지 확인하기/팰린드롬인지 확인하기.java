import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String text = br.readLine();
    int judgement = judge(text);
    bw.write(String.valueOf(judgement));
    br.close();
    bw.close();
  }

  private static int judge(String text) {
    String[] word = text.split("");
    Deque<String> que = new ArrayDeque<>(List.of(word));

    while (que.size() > 1) {
      String first = que.pollFirst();
      String last = que.pollLast();
      if (!first.equals(last)) {
        return 0;
      }
    }
    return 1;
  }
}
