import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    ArrayList<Integer> datas = inputData(n, br);
    int result = calculate(datas, m);
    System.out.println(result);
    br.close();
  }

  private static int calculate(ArrayList<Integer> datas, int m) {
    int min = Integer.MAX_VALUE;
    int temp = 0;
    for (int i = 0; i < datas.size()-2; i++) {
      int a = datas.get(i);
      for (int j = i+1; j < datas.size()-1; j++) {
        int b = datas.get(j);
        for (int k = j+1; k <datas.size(); k++) {
          int c = datas.get(k);
          if (min > m - (a + b + c) && m - (a + b + c)>=0) {
            min = m - (a + b + c);
            temp = a + b + c;
          }
        }
      }
    }
    return temp;
  }

  private static ArrayList<Integer> inputData(int n, BufferedReader br) throws IOException {
    ArrayList<Integer> temp = new ArrayList<>();
    String value = br.readLine();
    StringTokenizer st = new StringTokenizer(value);
    for (int i = 0; i < n ; i++) {
      temp.add(Integer.parseInt(st.nextToken()));
    }
    return temp;
  }
}
