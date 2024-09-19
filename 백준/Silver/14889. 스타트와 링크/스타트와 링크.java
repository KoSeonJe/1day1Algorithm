import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int min = Integer.MAX_VALUE;
  static int[][] arr;
  static boolean[] visit;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    arr = new int[N][N];
    visit = new boolean[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; st.hasMoreTokens() ; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    
    dfs(0,0);

    bw.write(String.valueOf(min));
    br.close();
    bw.close();
  }

  private static void dfs(int depth, int a) {
    if (depth == N / 2) {
      diff();
      return;
    }

    for (int i = a; i < N; i++) {
      visit[i] = true;
      dfs(depth + 1, i + 1);
      visit[i] = false;
    }
  }

  private static void diff() {
    int start = 0;
    int link = 0;
    for (int i = 0; i < N - 1; i++) {
      for (int j = i+1; j < N; j++) {
        if(visit[i] && visit[j]) {
          start += arr[i][j];
          start += arr[j][i];
        } else if (!visit[i] && !visit[j]) {
          link += arr[i][j];
          link += arr[j][i];
        }
      }
    }
    int val = Math.abs(link - start);
    if (val == 0) {
      System.out.println(0);
      System.exit(0);
    }
    min = Math.min(min, val);
  }
}
