import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = inputMap(N, br);
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            travel(i, 0, i);
        }
        bw.write(String.valueOf(min));
        br.close();
        bw.close();
    }

    private static void travel(int start, int minTemp, int nowLocation) {

        if (allVisited()) {
            if (map[nowLocation][start] != 0) {
                min = Math.min(min, minTemp + map[nowLocation][0]);
            }
            return;
        }

        for (int i = 1; i < N; i++) {
            if (!visited[i] && map[nowLocation][i] != 0) {
                visited[i] = true;
                travel(start, minTemp + map[nowLocation][i], i);
                visited[i] = false;
            }
        }
    }

    private static boolean allVisited() {
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[][] inputMap(int n, BufferedReader br) throws IOException {
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return map;
    }
}
