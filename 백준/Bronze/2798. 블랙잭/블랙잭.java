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
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] data = inputData(n, br);
    int result = calculate(data, m);
    bw.write(String.valueOf(result));
    br.close();
    bw.close();
  }

  private static int calculate(int[] data, int m) {
    int min = Integer.MAX_VALUE;
    int result = 0;
    for (int i = 0; i < data.length; i++) {
      for (int j = 1 + i; j < data.length; j++) {
        for (int k = 2 + j - 1; k < data.length; k++) {
          int temp = m - (data[i] + data[j] + data[k]);
          if(min > temp && temp >= 0) {
            min = temp;
            result = data[i] + data[j] + data[k];
          }
        }
      }
    }
    return result;
  }

  private static int[] inputData(int n, BufferedReader br) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] temp = new int[n];
    for (int i = 0; i < n; i++) {
      temp[i] = Integer.parseInt(st.nextToken());
    }
    return temp;
  }
}
