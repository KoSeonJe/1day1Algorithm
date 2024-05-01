import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < t; i++) {
      int k = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      list.add(calculate(k, n));
    }

    for (int value : list) {
      System.out.println(value);
    }
    br.close();
  }

  private static Integer calculate(int k, int n) {
    int[] temp = new int[n];

    for (int i = 0; i < n; i++) {
      temp[i] = i+1;
    }

    for (int i = 1; i <= k; i++) {
      for (int j = 1; j < n; j++) {
        temp[j] = temp[j] + temp[j - 1];
      }
    }
    return temp[n-1];
  }
}
