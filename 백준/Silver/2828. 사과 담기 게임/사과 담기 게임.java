import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int j = Integer.parseInt(br.readLine());
    Queue<Integer> appleLocation = inputAppleLocation(j, br);
    int result = calculationMin(n, m, appleLocation);
    bw.write(String.valueOf(result));
    br.close();
    bw.close();
  }

  private static int calculationMin(int n, int m, Queue<Integer> appleLocation) {
    int count = 0;
    int mLocation = m;
    while (!appleLocation.isEmpty()) {
      int location = appleLocation.poll();
      if (location <= mLocation && location >= mLocation - m + 1) {
        continue;
      }
      if (location > mLocation) {
        int repeat = location - mLocation;
        for (int i = 0; i < repeat; i++) {
          count++;
          mLocation++;
        }
        continue;
      }
      if (location < mLocation - m + 1) {
        int repeat = mLocation - m + 1 - location;
        for (int i = 0; i < repeat; i++) {
          count++;
          mLocation--;
        }
      }
    }
    return count;
  }

  private static Queue<Integer> inputAppleLocation(int j, BufferedReader br) throws IOException {
    Queue<Integer> appleLocation = new ArrayDeque<>();
    for (int i = 0; i < j; i++) {
      appleLocation.add(Integer.valueOf(br.readLine()));
    }
    return appleLocation;
  }
}
