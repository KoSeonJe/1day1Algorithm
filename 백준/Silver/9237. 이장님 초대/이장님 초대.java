import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    List<Integer> trees = inputTree(n, br);
    int result = calculate(trees);
    bw.write(String.valueOf(result));
    br.close();
    bw.close();
  }

  private static int calculate(List<Integer> trees) {
    Collections.sort(trees, Collections.reverseOrder());
    int temp = 0;
    int base = 2;
    for (int i = 0; i < trees.size(); i++) {
      temp = Math.max(temp, trees.get(i) + base);
      base++;
    }
    return temp;
  }

  private static List<Integer> inputTree(int n, BufferedReader br) throws IOException {
    List<Integer> trees = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      trees.add(Integer.parseInt(st.nextToken()));
    }
    return trees;
  }
}
