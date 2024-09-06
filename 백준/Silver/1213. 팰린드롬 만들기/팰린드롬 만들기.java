import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] datas = br.readLine().split("");
    Map<String, Integer> map = inputCount(datas ,br);
    String result = solve(map, datas);
    bw.write(result);
    br.close();
    bw.close();
  }

  private static String solve(Map<String, Integer> map, String[] datas) {
    Set<String> keys = map.keySet();
    int odd = 0;
    String oddKey = null;
    for(String key : keys) {
      int value = map.get(key);
      if (value % 2 != 0) {
        odd++;
        oddKey = key;
      }
      if (odd >= 2) {
        return "I'm Sorry Hansoo";
      }
    }
    List<String> targets = new ArrayList<>(List.of(datas));
    Collections.sort(targets);
    Deque<String> stack = new ArrayDeque<>();
    if (oddKey != null) {
      stack.addFirst(targets.remove(targets.indexOf(oddKey)));
    }
    int size = targets.size();
    for (int i = 0; i < size/2; i++) {
      stack.addFirst(targets.remove(targets.size() - 1));
      stack.addLast(targets.remove(targets.size() - 1));
    }
    List<String> result = new ArrayList<>(stack);
    return String.join("", result);
  }

  private static Map<String, Integer> inputCount(String[] datas, BufferedReader br) {
    Map<String, Integer> counts = new HashMap<>();
    for (String data : datas) {
      counts.merge(data, 1, Integer::sum);
    }
    return counts;
  }
}
