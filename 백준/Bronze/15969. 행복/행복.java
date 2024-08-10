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
    List<Integer> temp = inputData(n, br);
    int min = temp.stream().min(Integer::compareTo).get();
    int max = temp.stream().max(Integer::compareTo).get();
    int result = max - min;
    bw.write(String.valueOf(result));
    br.close();
    bw.close();
  }

  private static List<Integer> inputData(int n, BufferedReader br) throws IOException {
    List<Integer> temp = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      temp.add(Integer.parseInt(st.nextToken()));
    }
    return temp;
  }
}
