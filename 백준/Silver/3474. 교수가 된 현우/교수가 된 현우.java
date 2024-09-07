import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    List<Integer> datas = inputData(n, br);
    List<Integer> counts = calculate(datas);
    StringBuilder sb = new StringBuilder();
    for (int count : counts) {
      sb.append(count).append("\n");
    }
    bw.write(sb.toString());
    br.close();
    bw.close();
  }

  private static List<Integer> calculate(List<Integer> datas) {
    List<Integer> counts = new ArrayList<>();
    for (int data : datas){
      int two = 0;
      int five = 0;
      for (int i = 2; i <= data; i *= 2) {
        two += data / i;
      }

      for (int i = 5; i <= data; i *= 5) {
        five += data / i;
      }
      counts.add(Math.min(two, five));
    }
    return counts;
  }

  private static List<Integer> inputData(int n, BufferedReader br) throws IOException {
    List<Integer> datas = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      datas.add(Integer.parseInt(br.readLine()));
    }
    return datas;
  }
}
