import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    List<Integer> datas = inputDatas(br);
    List<Integer> result = calculate(datas);
    print(result, bw);
    br.close();
    bw.close();
  }

  private static void print(List<Integer> result, BufferedWriter bw) throws IOException {
    Collections.sort(result);
    for (int i = 0; i < result.size(); i++) {
      if (i == result.size() - 1) {
        bw.write(String.valueOf(result.get(i)));
        break;
      }
      bw.write(String.valueOf(result.get(i)) + "\n");
    }
  }

  private static List<Integer> calculate(List<Integer> datas) {
    int sum = 0;
    for (int i = 0; i < datas.size(); i++) {
      for (int j = i + 1; j < datas.size(); j++) {
        List<Integer> temp = new ArrayList<>(datas);
        temp.remove(i);
        temp.remove(j-1);
        sum = temp.stream().mapToInt(Integer::intValue).sum();
        if (sum == 100) {
          return temp;
        }
      }
    }
    return null;
  }

  private static List<Integer> inputDatas(BufferedReader br) throws IOException {
    List<Integer> datas = new ArrayList<>();
    for (int i = 0; i < 9; i++) {
      datas.add(Integer.parseInt(br.readLine()));
    }
    return datas;
  }
}
