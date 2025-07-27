import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static List<int[][]> pure = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] allPaper = new int[n][n];

        for (int i = 0; i < allPaper.length; i++) {
            String[] lineParts = br.readLine().split(" ");
            for (int j = 0; j < lineParts.length; j++) {
                allPaper[i][j] = Integer.parseInt(lineParts[j]);
            }
        }

        calculatePaper(allPaper);
        int white = 0;
        int blue = 1;

        int whiteCount = 0;
        int blueCount = 0;
        for (int[][] result : pure) {

            if (result[0][0] == white) {
                whiteCount++;
            } else {
                blueCount++;
            }
        }
        System.out.println(whiteCount);
        System.out.println(blueCount);

        br.close();
    }

    private static void calculatePaper(final int[][] allPaper) {
        int color = allPaper[0][0];
        for (int i = 0; i < allPaper.length; i++) {
            for (int j = 0; j < allPaper[0].length; j++) {
                if (allPaper[i][j] != color) {
                    List<int[][]> papers = divideFour(allPaper);
                    for (int[][] paper : papers) {
                        calculatePaper(paper);
                    }
                    return;
                }
            }
        }

        pure.add(allPaper);
    }


    public static List<int[][]> divideFour(int[][] target) {
        List<int[][]> divided = new ArrayList<>();

        // 2사분면
        int[][] temp = new int[target.length / 2][target.length / 2];
        for (int i = 0; i < target.length / 2; i++) {
            for (int j = 0; j < target[0].length / 2; j++) {
                temp[i][j] = target[i][j];
            }
        }
        divided.add(temp);

        //4사분면
        int[][] temp2 = new int[target.length / 2][target.length / 2];
        for (int i = target.length / 2; i < target.length; i++) {
            for (int j = target.length / 2; j < target.length; j++) {
                temp2[i - target.length / 2][j - target.length / 2] = target[i][j];
            }
        }
        divided.add(temp2);

        //3사분면
        int[][] temp3 = new int[target.length / 2][target.length / 2];
        for (int i = target.length / 2; i < target.length; i++) {
            for (int j = 0; j < target[0].length / 2; j++) {
                temp3[i - target.length / 2][j] = target[i][j];
            }
        }
        divided.add(temp3);

        //1사분면
        int[][] temp4 = new int[target.length / 2][target.length / 2];
        for (int i = 0; i < target.length / 2; i++) {
            for (int j = target.length / 2; j < target[0].length; j++) {
                temp4[i][j - target.length / 2] = target[i][j];
            }
        }
        divided.add(temp4);

        return divided;
    }
}
