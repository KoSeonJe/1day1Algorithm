import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N = 5;
    static int bingoCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] bingGo = createBingGo(reader);
        Queue<Integer> checker = createChecker(reader);
        int checkCount = startBingo(bingGo, checker);
        writer.write(String.valueOf(checkCount));
        reader.close();
        writer.close();
    }

    private static int startBingo(int[][] bingGo, Queue<Integer> checker) {
        int checkCount = 0;
        while (!checker.isEmpty()) {
            int number = checker.poll();
            checkNumber(bingGo, number);
            checkCount++;
            if (checkCount < 5) {
                continue;
            }

            checkBingo(bingGo);
            if (bingoCount >= 3) {
                break;
            }
        }
        return checkCount;
    }

    private static void checkBingo(int[][] bingGo) {
        for (int i = 0; i < N; i++) {
            checkRight(bingGo, i);
            checkDown(bingGo, i);
        }
        checkRightDown(bingGo);
        checkRightUp(bingGo);
    }

    private static void checkRightUp(int[][] bingGo) {
        for (int i = 0; i < N; i++) {
            if (bingGo[i][4 - i] != -1 && bingGo[i][4 - i] != -999) {
                return;
            }
        }

        int count = 0;
        for (int i = 1; i < N; i++) {
            if (bingGo[i][4 - i] == -999) {
                count++;
            }
        }
        if (count == 4) {
            return;
        }
        for (int i = 1; i < N; i++) {
            bingGo[i][4 - i] = -999;
        }
        bingoCount++;
    }

    private static void checkRightDown(int[][] bingGo) {
        for (int i = 0; i < N; i++) {
            if (bingGo[i][i] != -1 && bingGo[i][i] != -999) {
                return;
            }
        }

        int count = 0;
        for (int i = 1; i < N; i++) {
            if (bingGo[i][i] == -999) {
                count++;
            }
        }
        if (count == 4) {
            return;
        }
        for (int i = 1; i < N; i++) {
            bingGo[i][i] = -999;
        }
        bingoCount++;
    }

    private static void checkDown(int[][] bingGo, int k) {
        for (int i = 0; i < N; i++) {
            if (bingGo[k][i] != -1 && bingGo[k][i] != -999) {
                return;
            }
        }
        int count = 0;
        for (int i = 1; i < N; i++) {
            if (bingGo[k][i] == -999) {
                count++;
            }
        }
        if (count == 4) {
            return;
        }
        for (int i = 1; i < N; i++) {
            bingGo[k][i] = -999;
        }
        bingoCount++;
    }

    private static void checkRight(int[][] bingGo, int k) {
        for (int i = 0; i < N; i++) {
            if (bingGo[i][k] != -1 && bingGo[i][k] != -999) {
                return;
            }
        }
        int count = 0;
        for (int i = 1; i < N; i++) {
            if (bingGo[i][k] == -999) {
                count++;
            }
        }
        if (count == 4) {
            return;
        }

        for (int i = 1; i < N; i++) {
            bingGo[i][k] = -999;
        }

        bingoCount++;
    }

    private static void checkNumber(int[][] bingGo, int number) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (bingGo[i][j] == number) {
                    bingGo[i][j] = -1;
                    return;
                }
            }
        }
    }

    private static Queue<Integer> createChecker(BufferedReader reader) throws IOException {
        Queue<Integer> checker = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            for (int j = 0; j < N; j++) {
                checker.add(Integer.parseInt(tokenizer.nextToken()));
            }
        }
        return checker;
    }

    private static int[][] createBingGo(BufferedReader reader) throws IOException {
        int[][] bingGo = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            for (int j = 0; j < N; j++) {
                bingGo[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        return bingGo;
    }
}
