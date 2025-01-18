import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        boolean[][] isBoomMap = createBoom(br);

        String[][] selectedMap = createSelect(br);

        String[][] boomStatusMap = createBoomStatus(isBoomMap, selectedMap);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(boomStatusMap[i][j]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static String[][] createBoomStatus(boolean[][] isBoomMap, String[][] selectedMap) {
        String[][] temp = new String[N][N];
        boolean isBoom = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!Objects.equals(selectedMap[i][j], "x")) {
                    temp[i][j] = ".";
                    continue;
                }
                int count = calculateCount(isBoomMap, i, j);
                if (count == -1) {
                    isBoom = true;
                    continue;
                }
                temp[i][j] = String.valueOf(count);
            }
        }

        if (isBoom) {
            showBoom(temp, isBoomMap);
        }
        return temp;
    }

    private static void showBoom(String[][] temp, boolean[][] isBoomMap) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isBoomMap[i][j]) {
                    temp[i][j] = "*";
                }
            }
        }
    }

    private static int calculateCount(boolean[][] isBoomMap, int i, int j) {
        if (isBoomMap[i][j]) {
            return -1;
        }
        int count = 0;
        for (int k = -1; k < 2; k++) {
            if (i == 0 && k == -1) {
                continue;
            }
            if (i == isBoomMap.length - 1 && k == 1) {
                continue;
            }
            for (int l = -1; l < 2; l++) {
                if (j == 0 && l == -1) {
                    continue;
                }
                if (j == isBoomMap.length - 1 && l == 1) {
                    continue;
                }
                if (isBoomMap[i + k][j + l]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static String[][] createSelect(BufferedReader br) throws IOException {
        String[][] selectedMap = new String[N][N];
        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                String token = tokens[j];
                selectedMap[i][j] = token;
            }
        }
        return selectedMap;
    }

    private static boolean[][] createBoom(BufferedReader br) throws IOException {
        boolean[][] temp = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                String token = tokens[j];
                if (token.equals(".")) {
                    temp[i][j] = false;
                    continue;
                }
                if (token.equals("*")) {
                    temp[i][j] = true;
                }
            }
        }
        return temp;
    }
}
