import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int map[][];
    static int priceMap[][];
    static int cost = Integer.MAX_VALUE;
    static boolean visited[][];
    static int dir[][] = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        priceMap = new int[N][N];
        for (int i = 1; i < N -1; i++) {
            for (int j = 1; j < N - 1; j++) {
                priceMap[i][j] = getPrice(i,j);
            }
        }
        visited = new boolean[N][N];
        dfs(0, 0);

        bw.write(String.valueOf(cost));
        br.close();
        bw.close();
    }

    private static void dfs(int count, int sum) {
        if (cost <= sum) return;

        if (count == 3) {
            cost = sum;
        } else {
            for (int i = 1; i < N-1; i++) {
                Loop1 :
                for (int j = 1; j < N-1; j++) {
                    if(visited[i][j]) continue;

                    for (int k = 0; k < 5; k++) {
                        if (visited[i + dir[k][0]][j + dir[k][1]]) {
                            continue Loop1;
                        }
                    }

                    for (int k = 0; k < 5; k++) {
                        visited[i + dir[k][0]][j + dir[k][1]] = true;
                    }

                    dfs(count + 1, sum + priceMap[i][j]);

                    for (int k = 0; k < 5; k++) {
                        visited[i + dir[k][0]][j + dir[k][1]] = false;
                    }
                }
            }
        }
    }

    private static int getPrice(int i, int j) {
        int sum = 0;
        for (int k = 0; k < 5; k++) {
            sum += map[i + dir[k][0]][j + dir[k][1]];
        }
        return sum;
    }
}
