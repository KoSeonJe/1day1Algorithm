import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    List<Integer> datas = inputData(n, br);
    Set<Integer> temp = new HashSet<>(datas);
    List<Integer> result = new ArrayList<>(temp);
    Collections.sort(result);

    for (int data : result) {
      bw.write(String.valueOf(data) + "\n");
    }

    br.close();
    bw.close();
  }

  private static List<Integer> inputData(int n, BufferedReader br) throws IOException {
    List<Integer> data = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      data.add(Integer.parseInt(br.readLine()));
    }
    return data;
  }
}
