import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> maxLevel = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minLevel = new PriorityQueue<>();
    Map<Integer, List<Integer>> levels = new HashMap<>();
    Map<Integer, Integer> pNumber = new HashMap<>();
    Main r2 = new Main();
    r2.inputData(br, n , maxLevel, minLevel, levels, pNumber);

    int m = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    r2.operate(br, m, maxLevel, minLevel, levels, pNumber, sb);
    System.out.println(sb);
    br.close();
  }

  private void operate(BufferedReader br, int m, PriorityQueue<Integer> maxLevel, PriorityQueue<Integer> minLevel, Map<Integer, List<Integer>> levels, Map<Integer, Integer> pNumber,
      StringBuilder sb)
      throws IOException {
    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String operation = st.nextToken();
      if (operation.equals("add")) {
        addData(st, maxLevel, minLevel, levels, pNumber);
      } else if (operation.equals("recommend")) {
        int num = Integer.parseInt(st.nextToken());
        if (num == 1) {
          int level = maxLevel.peek();
          List<Integer> problem = levels.get(level);
          int max = Collections.max(problem);
          sb.append(max).append("\n");
        } else {
          int level = minLevel.peek();
          List<Integer> problem = levels.get(level);
          int min = Collections.min(problem);
          sb.append(min).append("\n");
        }
      } else if (operation.equals("solved")) {
        int num = Integer.parseInt(st.nextToken());
        int level = pNumber.remove(num);
        maxLevel.remove(level);
        minLevel.remove(level);
        List<Integer> nums = levels.get(level);
        nums.remove((Integer)num);
      }
    }
  }

  private void inputData(BufferedReader br, int n, PriorityQueue<Integer> maxLevel, PriorityQueue<Integer> minLevel, Map<Integer, List<Integer>> levels, Map<Integer, Integer> pNumber)
      throws IOException {
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      addData(st, maxLevel, minLevel, levels, pNumber);
    }
  }

  private void addData(StringTokenizer st, PriorityQueue<Integer> maxLevel,
      PriorityQueue<Integer> minLevel, Map<Integer, List<Integer>> levels,
      Map<Integer, Integer> pNumber) throws IOException {
    int pNum = Integer.parseInt(st.nextToken());
    int level = Integer.parseInt(st.nextToken());
    maxLevel.offer(level);
    minLevel.offer(level);
    pNumber.put(pNum, level);

    if (levels.containsKey(level)) {
      List<Integer> nums = levels.get(level);
      nums.add(pNum);
    } else {
      List<Integer> nums = new ArrayList<>();
      nums.add(pNum);
      levels.put(level, nums);
    }
  }
}


