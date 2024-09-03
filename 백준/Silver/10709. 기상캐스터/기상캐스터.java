import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int h = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    String[][] sky = inputCloud(h, w, br);
    int[][] result = calculate(sky);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[i].length; j++) {
        sb.append(result[i][j]).append(" ");
      }
      sb.append("\n");
    }
    bw.write(sb.toString());
    br.close();
    bw.close();
  }

  private static int[][] calculate(String[][] sky) {
    int[][] result = new int[sky.length][sky[0].length];
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[i].length; j++) {
        result[i][j] = -1;
      }
    }
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[i].length; j++) {
        if (sky[i][j].equals("c")) {
          result[i][j] = 0;
        }
        if (result[i][j] != -1 && j != result[i].length - 1) {
          result[i][j + 1] = result[i][j] + 1;
        }
      }
    }
    return result;
  }

  private static String[][] inputCloud(int h, int w, BufferedReader br) throws IOException {
    String[][] sky = new String[h][w];
    for (int i = 0; i < h; i++) {
      String text = br.readLine();
      char[] chars = text.toCharArray();
      for (int j = 0; j < w; j++) {
        sky[i][j] = String.valueOf(chars[j]);
      }
    }
    return sky;
  }
}
