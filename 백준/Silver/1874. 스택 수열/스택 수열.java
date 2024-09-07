import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    Queue<Integer> datas = inputData(n, br);
    List<String> results = calculate(datas);
    StringBuilder sb = new StringBuilder();
    for (String result : results) {
      sb.append(result).append("\n");
    }
    bw.write(sb.toString());
    br.close();
    bw.close();
  }

  private static List<String> calculate(Queue<Integer> datas) {
    List<String> results = new ArrayList<>();
    Stack<Integer> temps = new Stack<>();
    int count = 1;
    while(!datas.isEmpty()) {
      int n = datas.poll();

      while (count <= n) {
        temps.push(count++);
        results.add("+");
      }

      if (temps.peek() == n) {
        temps.pop();
        results.add("-");
      } else {
        return new ArrayList<>(List.of("NO"));
      }
      
    }
    
    return results;
  }

  private static Queue<Integer> inputData(int n, BufferedReader br) throws IOException {
    Queue<Integer> datas = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      datas.add(Integer.parseInt(br.readLine()));
    }
    return datas;
  }
}
