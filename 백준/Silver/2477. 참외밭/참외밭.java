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
    int n = Integer.parseInt(br.readLine());
    int resultM2 = calculate(br);
    int result = n * resultM2;
    bw.write(String.valueOf(result));
    br.close();
    bw.close();
  }

  private static int calculate(BufferedReader br) throws IOException {
    int[] lengths = new int[6];
    int maxWidth = 0;
    int maxHeight = 0;
    int maxWidthIndex = 0;
    int maxHeightIndex = 0;
    for (int i = 0; i <6; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int direction = Integer.parseInt(st.nextToken());
      lengths[i] = Integer.parseInt(st.nextToken());

      if(direction == 1 || direction == 2) {
        if(maxWidth < lengths[i]) {
          maxWidth = lengths[i];
          maxWidthIndex = i;
        }
      }
      if(direction == 3 || direction == 4) {
        if(maxHeight < lengths[i]) {
          maxHeight = lengths[i];
          maxHeightIndex = i;
        }
      }
    }
    int smallWidth = Math.abs(lengths[(maxHeightIndex + 1) % 6] - lengths[(maxHeightIndex + 5) % 6]);
    int smallHeight = Math.abs(lengths[(maxWidthIndex + 1) % 6] - lengths[(maxWidthIndex + 5) % 6]);

    return (maxWidth * maxHeight) - (smallWidth * smallHeight);
  }
}
