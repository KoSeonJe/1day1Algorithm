import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Main problem = new Main();
    ArrayList<Integer> numbers = problem.inputData(n, br);

    for (int i = 0; i < 2*n; i = i + 2) {
      int x = numbers.get(i);
      int y = numbers.get(i + 1);
      System.out.println(problem.calculateRequiredValue(x, y));
    }
  }

  private int calculateRequiredValue(int x, int y) {
    int max = 0;
    for (int i = 1; i <= x && i <= y; i++) {
      if (x % i == 0 && y % i == 0) {
        max = i;
      }
    }

    return (x/max * y/max) * max;
  }

  private ArrayList<Integer> inputData(int n, BufferedReader br) throws IOException {
    ArrayList<Integer> temp = new ArrayList<>();
    for (int i = 0; i < n ; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      temp.add(Integer.parseInt(st.nextToken()));
      temp.add(Integer.parseInt(st.nextToken()));
    }
    return temp;
  }
}
