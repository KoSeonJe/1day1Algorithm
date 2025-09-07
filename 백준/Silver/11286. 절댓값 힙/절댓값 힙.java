import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Main ahs = new Main();
    StringBuilder sb = new StringBuilder();
    ahs.input(n, br, sb);
    System.out.println(sb);
    br.close();
  }

  private void input(int n, BufferedReader br, StringBuilder sb) throws IOException {
    PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        int num1 = Math.abs(o1);
        int num2 = Math.abs(o2);
        if (num1 == num2) {
          return o1 > o2 ? 1 : -1;
        }
        return num1 > num2 ? 1 : -1;
      }
    });
    for (int i = 1; i < n + 1; i++) {
      int x = Integer.parseInt(br.readLine());

      if (x == 0) {
        if (pq.isEmpty()) {
          sb.append(0).append("\n");
        }else{
          int num = pq.poll();
          sb.append(num).append("\n");
        }
        continue;
      }
      pq.offer(x);
    }
  }
}
