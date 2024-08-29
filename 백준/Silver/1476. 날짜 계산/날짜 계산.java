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
    int e = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int result = calculateYear(e, s, m);
    bw.write(String.valueOf(result));
    br.close();
    bw.close();
  }

  private static int calculateYear(int e, int s, int m) {
    // x % 15 = e
    // x % 28 = s
    // x % 19 = m
    int year = 1;
    boolean flag = true;
    while (flag) {
      if ((year - e) % 15 == 0 && (year - s) % 28 == 0 && (year - m) % 19 == 0) {
        flag = false;
        continue;
      }
      year++;
    }
    return year;
  }
}
