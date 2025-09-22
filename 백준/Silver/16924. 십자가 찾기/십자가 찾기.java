import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static char[][] board;
    static boolean[][] boardStar;
    static int n;
    static int m;

    static class Cross {

        int centerRow;
        int centerColumn;
        int size;

        public Cross(final int centerRow, final int centerColumn, final int size) {
            this.centerRow = centerRow;
            this.centerColumn = centerColumn;
            this.size = size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");

        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        board = new char[n + 1][m + 1];
        boardStar = new boolean[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            char[] array = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                board[i][j] = array[j-1];
                if (array[j-1] == '*') {
                    boardStar[i][j] = true;
                }
            }
        }

        List<Cross> crosses = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                addCross(crosses, i, j);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (boardStar[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        StringBuilder builder = new StringBuilder();

        builder.append(crosses.size()).append("\n");

        for (Cross cross : crosses) {
            builder.append(cross.centerRow).append(" ").append(cross.centerColumn).append(" ").append(cross.size)
                    .append("\n");
        }

        System.out.println(builder);
        br.close();
    }

    private static void addCross(final List<Cross> crosses, final int i, final int j) {
        if (i == 1 || i == n || j == 1 || j == m) {
            return;
        }

        int size = 1;
        boolean noCross = false;
        while (!noCross) {
            if (i + size > n || i - size < 1 || j + size > m || j - size < 1) {
                noCross = true;
            }else if (board[i][j] == '*' && board[i + size][j] == '*' && board[i][j + size] == '*' && board[i - size][j] == '*'
                    && board[i][j - size] == '*') {
                boardStar[i + size][j] = false;
                boardStar[i][j + size] = false;
                boardStar[i - size][j] = false;
                boardStar[i][j - size] = false;
                boardStar[i][j] = false;
                size++;
                continue;
            } else {
                noCross = true;
            }
            if (size > 1) {
                crosses.add(new Cross(i, j, size - 1));
            }
        }

    }
}
