
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    int h = Integer.parseInt(st.nextToken());

    int result1 = Math.min(Math.abs(x - 0), Math.abs(y - 0));
    int result = Math.min(Math.abs(x - w), Math.abs(y - h));

    int finalResult = Math.min(result, result1);
    System.out.println(finalResult);
    bf.close();
  }
}
