import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] datas = inputData(n, br);
    Arrays.sort(datas);
    StringBuilder sb = new StringBuilder();
    for (int data : datas) {
      sb.append(data).append("\n");
    }
    bw.write(sb.toString());
    br.close();
    bw.close();
  }

  private static int[] inputData(int n, BufferedReader br) throws IOException {
    int[] data = new int[n];
    for (int i = 0; i < n; i++) {
      data[i] = Integer.parseInt(br.readLine());
    }
    return data;
  }
}
