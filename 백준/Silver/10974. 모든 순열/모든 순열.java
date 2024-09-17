import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

  private static int n;
  private static int[] now;
  private static boolean[] visited;
  private static StringBuilder sb = new StringBuilder();


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    now = new int[n];
    visited = new boolean[n];
    printPermutation(0);
    bw.write(sb.toString());
    br.close();
    bw.close();
  }

  private static void printPermutation(int depth) {
    if (depth == n) {
      for (int i : now) {
        sb.append(i).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 0; i < n; i++) {
      if(visited[i]) {
        continue;
      }

      if (!visited[i]) {
        visited[i] = true;
        now[depth] = i+1;
        printPermutation(depth + 1);
        visited[i] = false;
      }
    }
  }
}
