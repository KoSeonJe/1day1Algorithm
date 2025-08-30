import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine());
    Main nSquareMaxs = new Main();
    nSquareMaxs.printN(bf, n);
  }

  private void printN(BufferedReader bf, int n) throws IOException {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(bf.readLine());
      for (int j = 0; j < n; j++) {
        int num = Integer.parseInt(st.nextToken());
        if (pq.size() >= n) {
          if (num >= pq.peek()) {
            pq.offer(num);
            pq.poll();
          }
        } else {
          pq.offer(num);
        }
      }
    }
    int result = pq.poll();

    System.out.println(result);
  }
}
