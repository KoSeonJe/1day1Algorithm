import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    Map<Integer, Integer> datas = inputData(n, br);
    int m = Integer.parseInt(br.readLine());
    int[] targets = inputTarget(m, br);
    List<Integer> results = isEquals(datas, targets);
    StringBuilder sb = new StringBuilder();
    for (int result : results) {
      sb.append(result).append("\n");
    }
    bw.write(sb.toString());
    br.close();
    bw.close();
  }

  private static Map<Integer, Integer> inputData(int n, BufferedReader br) throws IOException {
    Map<Integer, Integer> data = new HashMap<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      data.put(Integer.parseInt(st.nextToken()), -1);
    }
    return data;
  }

  private static List<Integer> isEquals(Map<Integer, Integer> datas, int[] targets) {
    List<Integer> results = new ArrayList<>();
    for (int i = 0; i < targets.length; i++) {
      if (datas.get(targets[i]) != null) {
        results.add(1);
      } else {
        results.add(0);
      }
    }
    return results;
  }

  private static int[] inputTarget(int n, BufferedReader br) throws IOException {
    int[] datas = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < datas.length; i++) {
      datas[i] = Integer.parseInt(st.nextToken());
    }
    return datas;
  }
}
