import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    ArrayList<Integer> datas = inputData(n, br);
    Collections.sort(datas);

    for (int data : datas) {
      System.out.println(data);
    }
    br.close();
  }

  private static ArrayList<Integer> inputData(int n, BufferedReader br) throws IOException {
    ArrayList<Integer> temp = new ArrayList<>();

    for (int i = 0; i < n ; i++) {
      temp.add(Integer.parseInt(br.readLine()));
    }
    return temp;
  }
}
