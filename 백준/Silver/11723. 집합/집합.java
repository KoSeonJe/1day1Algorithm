import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    List<Integer> results = getResults(n, br);
    StringBuilder sb = new StringBuilder();
    for(int result : results) {
      sb.append(result).append("\n");
    }
    bw.write(sb.toString());
    br.close();
    bw.close();
  }

  private static List<Integer> getResults(int number, BufferedReader br) throws IOException {
    boolean[] set = new boolean[21];
    List<Integer> results = new ArrayList<>();
    for (int i = 0; i < number; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      int result = -1;
      if (command.equals("all") || command.equals("empty")) {
        result = process(set, command, -1);
      } else {
        int num = Integer.parseInt(st.nextToken());
        result = process(set, command, num);
      }
      if (result != -1) {
        results.add(result);
      }
    }
    return results;
  }

  private static int process(boolean[] set, String command, int number) {
    switch (command) {
      case "add":
        set[number] = true;
        return -1;
      case "remove":
        set[number] = false;
        return -1;
      case "check":
        return set[number] ? 1 : 0;
      case "toggle":
        set[number] = !set[number];
        return -1;
      case "all":
        for (int i = 1; i <= 20; i++) {
          set[i] = true;
        }
        return -1;
      case "empty":
        for (int i = 1; i <= 20; i++) {
          set[i] = false;
        }
        return -1;
    }
    return -1;
  }
}
