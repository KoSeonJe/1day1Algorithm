import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    Integer[] data = inputData(br);
    String result = calculate(data);
    bw.write(result);
    br.close();
    bw.close();
  }

  private static Integer[] inputData(BufferedReader br) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    Integer[] temp = new Integer[8];
    for (int i = 0; i < 8; i++) {
      temp[i] = Integer.parseInt(st.nextToken());
    }
    return temp;
  }

  private static String calculate(Integer[] data) {
    List<Integer> datalist = new ArrayList<>(List.of(data));
    Collections.sort(datalist);
    if (Arrays.equals(datalist.toArray(), data)) {
      return "ascending";
    }
    Collections.reverse(datalist);
    if (Arrays.equals(datalist.toArray(), data)) {
      return "descending";
    }
    return "mixed";
  }
}
