import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    List<String> datas = inputData(n, br);
    String result = solve(datas);
    bw.write(result);
    br.close();
    bw.close();
  }

  private static String solve(List<String> datas) {
    StringBuilder sb = new StringBuilder();
    int kbs1Index = datas.indexOf("KBS1");
    int kbs2Index = datas.indexOf("KBS2");
    if (kbs1Index < kbs2Index) {
      for (int i = 0; i <kbs1Index ; i++) {
        sb.append(1);
      }
      for (int i = 0; i <kbs1Index ; i++) {
        sb.append(4);
      }
      for (int i = 0; i <kbs2Index ; i++) {
        sb.append(1);
      }
      for (int i = 0; i <kbs2Index-1 ; i++) {
        sb.append(4);
      }
    } else {
      for (int i = 0; i <kbs1Index ; i++) {
        sb.append(1);
      }
      for (int i = 0; i <kbs1Index ; i++) {
        sb.append(4);
      }
      for (int i = 0; i <kbs2Index+1 ; i++) {
        sb.append(1);
      }
      for (int i = 0; i <kbs2Index ; i++) {
        sb.append(4);
      }
    }
   
    return sb.toString();
  }

  private static List<String> inputData(int n, BufferedReader br) throws IOException {
    List<String> datas = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      datas.add(br.readLine());
    }
    return datas;
  }
}
