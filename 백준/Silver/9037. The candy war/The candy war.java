import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    List<Integer> results = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int children = Integer.parseInt(br.readLine());
      int[] candies = inputCandies(children, br);
      int cycleCount = calculate(candies);
      results.add(cycleCount);
    }
    StringBuilder sb = new StringBuilder();
    for (int result : results) {
      sb.append(result).append("\n");
    }
    bw.write(sb.toString());
    br.close();
    bw.close();
  }

  private static int calculate(int[] candies) {
    int count = 0;
    makeEven(candies);

    while (!allEquals(candies)) {
      count++;
      int[] give = new int[candies.length];
      for (int i = 0; i < give.length; i++) {
        if (i == 0) {
          give[i] = candies[candies.length - 1]/2;
          continue;
        }
        give[i] = candies[i - 1] / 2;
      }
      for (int i = 0; i < candies.length; i++) {
        candies[i] = candies[i] / 2;
      }
      for (int i = 0; i < candies.length; i++) {
        candies[i] += give[i];
      }
      makeEven(candies);
    }
    return count;
  }

  private static void makeEven(int[] candies) {
    for (int i = 0; i < candies.length; i++) {
      if (candies[i] % 2 != 0) {
        candies[i] += 1;
      }
    }
  }

  private static boolean allEquals(int[] candies) {
    for (int i = 1; i < candies.length; i++) {
      if (candies[0] != candies[i]) {
        return false;
      }
    }
    return true;
  }

  private static int[] inputCandies(int children, BufferedReader br) throws IOException {
    int[] candies = new int[children];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < children; i++) {
      candies[i] = Integer.parseInt(st.nextToken());
    }
    return candies;
  }
}
