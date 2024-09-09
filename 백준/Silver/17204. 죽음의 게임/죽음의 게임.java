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

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int target = Integer.parseInt(st.nextToken());
    List<Integer> numbers = inputNumber(n, br);
    int number = calculate(numbers, target);
    bw.write(String.valueOf(number));
    br.close();
    bw.close();
  }

  private static int calculate(List<Integer> numbers, int target) {
    int count = 0;
    int point = 0;
    for (int i = 0; i < numbers.size(); i++) {
      int num = numbers.get(point);
      point = num;
      count++;
      if (count >= numbers.size()) {
        return -1;
      }
      if (num == target) {
        break;
      }
    }
    return count;
  }

  private static List<Integer> inputNumber(int n, BufferedReader br) throws IOException {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      numbers.add(Integer.parseInt(br.readLine()));
    }
    return numbers;
  }
}
