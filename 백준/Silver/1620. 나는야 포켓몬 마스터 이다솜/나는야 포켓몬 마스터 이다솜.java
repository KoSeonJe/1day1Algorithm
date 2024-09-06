import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    Map<Integer, String> pocketmonFinder = new HashMap<>();
    Map<String, Integer> indexFinder = new HashMap<>();
    createPocket(br, n, pocketmonFinder, indexFinder);
    StringBuilder sb = new StringBuilder();
    printAnwser(br, m, pocketmonFinder, indexFinder, sb);
    bw.write(sb.toString());
    br.close();
    bw.close();
  }

  private static void printAnwser(BufferedReader br, int m, Map<Integer, String> pocketmonFinder,
      Map<String, Integer> indexFinder, StringBuilder sb) throws IOException {
    for (int i = 0; i < m; i++) {
      String problem = br.readLine();
      if (isInteger(problem)) {
        int temp = Integer.parseInt(problem);
        sb.append(pocketmonFinder.get(temp)).append("\n");
      } else {
        sb.append(indexFinder.get(problem)).append("\n");
      }
    }
  }

  private static boolean isInteger(String next) {
    try {
      Integer.parseInt(next);
      return true;
    } catch (NumberFormatException exception) {
      return false;
    }
  }

  private static void createPocket(BufferedReader br, int n, Map<Integer, String> pocketmonFinder,
      Map<String, Integer> indexFinder) throws IOException {
    for (int i = 0; i < n; i++) {
      String input = br.readLine();
      pocketmonFinder.put(i + 1, input);
      indexFinder.put(input, i + 1);
    }
  }
}
