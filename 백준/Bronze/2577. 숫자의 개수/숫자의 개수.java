import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());
    int c = Integer.parseInt(br.readLine());
    int result = a * b * c;
    int[] require = calculate(result);
    for (int i = 0; i <require.length; i++) {
      System.out.println(require[i]);
    }
    br.close();
  }

  private static int[] calculate(int result) {
    int[] temp = new int[10];
    String st = String.valueOf(result);
    for (int i = 0; i <st.length(); i++) {
      temp[Integer.parseInt(String.valueOf(st.charAt(i)))] += 1;
    }
    return temp;
  }
}
