import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static int[][] map;
    static boolean[][] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            getMap(W, H, K, br);
            visited = new boolean[W][H];
            count = 0;
            for (int j = 0; j < W; j++) {
                for (int k = 0; k < H; k++) {
                    if(!visited[j][k] && map[j][k] == 1) {
                        count++;
                        dfs(j,k);
                    }
                }
            }
            sb.append(count).append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void dfs(int x, int y) {
        if (map[x][y] != 1 || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        if (x == 0 && y == 0) {
            dfs(x + 1, y);
            dfs(x, y + 1);
            return;
        } else if (x == 0) {
            dfs(x + 1, y);
            dfs(x, y - 1);

            if(y != map[0].length - 1){
                dfs(x, y + 1);
            }
            return;
        } else if (y == 0) {
            dfs(x - 1, y);
            dfs(x, y + 1);

            if(x != map.length - 1){
                dfs(x + 1, y);
            }
            return;
        }

        if(x == map.length - 1 && y == map[0].length - 1) {
            dfs(x - 1, y);
            dfs(x, y - 1);
            return;
        } else if (x == map.length - 1) {
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            return;
        } else if (y == map[0].length - 1) {
            dfs(x + 1, y);
            dfs(x - 1, y);
            dfs(x, y - 1);
            return;
        }
        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y + 1);
        dfs(x, y - 1);
    }

    private static void getMap(int w, int h, int k, BufferedReader br) throws IOException {
        map = new int[w][h];
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }
    }
}
