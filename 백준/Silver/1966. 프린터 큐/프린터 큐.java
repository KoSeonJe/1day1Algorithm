import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int num = Integer.parseInt(br.readLine());
    List<Integer> results = new ArrayList<>();
    for (int i = 0; i < num; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int count = Integer.parseInt(st.nextToken());
      int target = Integer.parseInt(st.nextToken());
      List<Integer> datas = inputData(count, br);
      results.add(calculate(datas, target));
    }
    StringBuilder sb = new StringBuilder();
    for (int result : results) {
      sb.append(result).append("\n");
    }
    bw.write(sb.toString());
    br.close();
    bw.close();
  }

  private static int calculate(List<Integer> datas, int target) {
    int index = target;
    int count = 0;
    Queue<Integer> que = new ArrayDeque<>(datas);
    while (!que.isEmpty()) {
      int num = que.peek();
      int max = Collections.max(que);
      if (num == max) {
        que.poll();
        count++;
        if (index == 0) {
          break;
        }
        index--;
      } else {
        que.poll();
        que.add(num);
        if (index == 0) {
          index = index + que.size() - 1;
        } else {
          index--;
        }
      }
    }
    return count;
  }

  private static List<Integer> inputData(int count, BufferedReader br) throws IOException {
    List<Integer> datas = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < count; i++) {
      datas.add(Integer.valueOf(st.nextToken()));
    }
    return datas;
  }
}
