import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int num = Integer.parseInt(br.readLine());
    char[] commands = inputCommands(br);
    char[][] xylograph = inputData(num);
    play(commands, xylograph);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < xylograph.length; i++) {
      for (int j = 0; j < xylograph[i].length; j++) {
        sb.append(xylograph[i][j]);
      }
      sb.append("\n");
    }
    bw.write(sb.toString());
    br.close();
    bw.flush();
    bw.close();
  }

  private static void play(char[] commands, char[][] xylograph) {
    int iIndex = 0;
    int jIndex = 0;
    for (char command : commands) {
      if (!checkPossible(iIndex, jIndex, command, xylograph.length)) {
        continue;
      }
      if (command == 'U') {
        upOrDown(xylograph, iIndex, jIndex, true);
        iIndex--;
      } else if (command == 'D') {
        upOrDown(xylograph, iIndex, jIndex, false);
        iIndex++;
      } else if (command == 'L') {
        leftOrRight(xylograph, iIndex, jIndex, true);
        jIndex--;
      } else if (command == 'R') {
        leftOrRight(xylograph, iIndex, jIndex, false);
        jIndex++;
      }
    }
  }

  private static boolean checkPossible(int iIndex, int jIndex, char command, int length) {
    switch (command) {
      case 'U':
        return iIndex > 0;
      case 'D':
        return iIndex < length - 1;
      case 'L':
        return jIndex > 0;
      case 'R':
        return jIndex < length - 1;
      default:
        return false;
    }
  }

  private static void leftOrRight(char[][] xylograph, int iIndex, int jIndex, boolean isLeft) {
    markPosition(xylograph, iIndex, jIndex, '-');
    int newJ = isLeft ? jIndex - 1 : jIndex + 1;
    markPosition(xylograph, iIndex, newJ, '-');
  }

  private static void upOrDown(char[][] xylograph, int iIndex, int jIndex, boolean isUp) {
    markPosition(xylograph, iIndex, jIndex, '|');
    int newI = isUp ? iIndex - 1 : iIndex + 1;
    markPosition(xylograph, newI, jIndex, '|');
  }

  private static void markPosition(char[][] xylograph, int i, int j, char mark) {
    if (xylograph[i][j] == '.') {
      xylograph[i][j] = mark;
    } else if (xylograph[i][j] != mark) {
      xylograph[i][j] = '+';
    }
  }

  private static char[][] inputData(int number) {
    char[][] temp = new char[number][number];
    for (int i = 0; i < number; i++) {
      for (int j = 0; j < number; j++) {
        temp[i][j] = '.';
      }
    }
    return temp;
  }

  private static char[] inputCommands(BufferedReader br) throws IOException {
    return br.readLine().toCharArray();
  }
}