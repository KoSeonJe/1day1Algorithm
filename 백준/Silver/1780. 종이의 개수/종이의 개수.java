import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] paper;
    static int negativeCount;
    static int zeroCount;
    static int positiveCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        paper = new int[n][n];

        for (int i = 0; i < paper.length; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < paper.length; j++) {
                paper[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        calculatePaper(0, 0, n);
        System.out.println(negativeCount);
        System.out.println(zeroCount);
        System.out.println(positiveCount);

        br.close();
    }

    private static void calculatePaper(int startRow, int startCol, int size) {
        // 현재 영역이 모두 같은 숫자인지 확인
        int firstValue = paper[startRow][startCol];
        boolean isPure = true;

        for (int i = startRow; i < startRow + size && isPure; i++) {
            for (int j = startCol; j < startCol + size && isPure; j++) {
                if (paper[i][j] != firstValue) {
                    isPure = false;
                }
            }
        }

        if (isPure) {
            // 순수한 종이라면 카운트 증가
            if (firstValue == -1) {
                negativeCount++;
            } else if (firstValue == 0) {
                zeroCount++;
            } else {
                positiveCount++;
            }
        } else {
            // 순수하지 않다면 9등분하여 재귀 호출
            int newSize = size / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    calculatePaper(
                            startRow + i * newSize,
                            startCol + j * newSize,
                            newSize
                    );
                }
            }
        }
    }
}
