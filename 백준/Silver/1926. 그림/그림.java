import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited;
    static int[][] paper;
    static int height;
    static int width;
    static int drawCount;
    static int max = Integer.MIN_VALUE;
    static int temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] hw = br.readLine().split(" ");
        height = Integer.parseInt(hw[0]);
        width = Integer.parseInt(hw[1]);

        paper = new int[height][width];
        visited = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (paper[i][j] == 1 && !visited[i][j]) {
                    drawCount++;
                    dfs(i, j);
                    if (max < temp) {
                        max = temp;
                    }
                    temp = 0;
                }
                if (paper[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }
        if (max == Integer.MIN_VALUE) {
            max = 0;
        }
        System.out.println(drawCount);
        System.out.println(max);
        br.close();
    }

    private static void dfs(final int h, final int w) {
        if (h >= height || w >= width || h < 0 || w < 0) {
            return;
        }
        if (paper[h][w] == 0) {
            return;
        }
        if (visited[h][w]) {
            return;
        }
        if (paper[h][w] == 1) {
            temp++;
        }
        visited[h][w] = true;
        dfs(h, w + 1);
        dfs(h, w - 1);
        dfs(h + 1, w);
        dfs(h - 1, w);
    }
}

