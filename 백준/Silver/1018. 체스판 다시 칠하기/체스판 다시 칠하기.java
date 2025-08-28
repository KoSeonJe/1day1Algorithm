import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

  public static int COUNT = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    Main problems = new Main();

    String[][] chess = problems.inputChess(n, m, bf);
    problems.rePaint(chess);
    bf.close();
  }

  private void rePaint(String[][] chess) {
    int min = Integer.MAX_VALUE;
    String[][] temp;
    String[][] temp2;
    for (int i = 0; chess.length - i >= 8 ; i++) {
      for (int j = 0; chess[i].length - j >= 8; j++) {
        temp = copyChess(chess,i,j);
        temp2 = copyChess(chess,i,j);
        COUNT = 0;
        countRepaintMinValue(temp, "W");
        if (min > COUNT) {
          min = COUNT;
        }
        COUNT = 0;
        countRepaintMinValue(temp2, "B");
        if (min > COUNT) {
          min = COUNT;
        }
      }
    }
    System.out.println(min);
  }

  private void countRepaintMinValue(String[][] temp, String start) {
    if (!Objects.equals(temp[0][0], start)) {
      temp[0][0] = start;
      COUNT++;
    }
    for (int i = 0; i < temp.length; i++) {
      temp[i][0] = getColor(temp, i);

      for (int j = 0; j < temp[i].length; j++) {
        validateAndChangeColor(i, j, temp);
      }
    }
  }

  private void validateAndChangeColor(int i, int j, String[][] temp) {
    if (j == temp[i].length-1) {
      return;
    }
    if (!Objects.equals(temp[i][j], temp[i][j + 1])) {
      return;
    }
    if (Objects.equals(temp[i][j], "W")) {
      COUNT++;
      temp[i][j + 1] = "B";
    } else {
      COUNT++;
      temp[i][j + 1] = "W";
    }
  }

  private String getColor(String[][] temp, int i) {
    if (i == 0) {
      return temp[0][0];
    }

    String nowColor = temp[i][0];
    String pastColor = temp[i - 1][0];
    if (!Objects.equals(nowColor, pastColor)) {
      return nowColor;
    }
    if (Objects.equals(pastColor, "W")) {
      COUNT++;
      return "B";
    } else {
      COUNT++;
      return "W";
    }
  }

  private String[][] copyChess(String[][] chess, int i, int j) {
    String[][] temp = new String[8][8];
    for (int x = 0; x <8 ; x++) {
      for (int k = 0; k <8 ; k++) {
        temp[x][k] = chess[i+x][j+k];
      }
    }
    return temp;
  }

  private String[][] inputChess(int n, int m, BufferedReader bf) throws IOException {
    String[][] temp = new String[n][m];
    for (int i = 0; i < n ; i++) {
      String[] row = bf.readLine().split("");
      for (int j = 0; j < m; j++) {
        temp[i][j] = row[j];
      }
    }
    return temp;
  }
}
