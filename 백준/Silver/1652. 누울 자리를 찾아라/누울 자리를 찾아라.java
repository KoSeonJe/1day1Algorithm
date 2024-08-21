import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    String[][] room = input(br, n);

    int width = calculateWidth(room);
    int height = calculateHeight(room);
    bw.write(width + " " + height);
    bw.flush();
    br.close();
    bw.close();
  }

  private static int calculateHeight(String[][] room) {
    int count = 0;
    for (int j = 0; j < room[0].length; j++) {
      int consecutive = 0;
      for (int i = 0; i < room.length; i++) {
        if (room[i][j].equals(".")) {
          consecutive++;
        } else {
          if (consecutive >= 2) {
            count++;
          }
          consecutive = 0;
        }
      }
      if (consecutive >= 2) {
        count++;
      }
    }
    return count;
  }

  private static int calculateWidth(String[][] room) {
    int count = 0;
    for (int i = 0; i < room.length; i++) {
      int consecutive = 0;
      for (int j = 0; j < room[i].length; j++) {
        if (room[i][j].equals(".")) {
          consecutive++;
        } else {
          if (consecutive >= 2) {
            count++;
          }
          consecutive = 0;
        }
      }
      if (consecutive >= 2) {
        count++;
      }
    }
    return count;
  }

  private static String[][] input(BufferedReader br, int n) throws IOException {
    String[][] room = new String[n][n];

    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < n; j++) {
        room[i][j] = String.valueOf(line.charAt(j));
      }
    }
    return room;
  }
}