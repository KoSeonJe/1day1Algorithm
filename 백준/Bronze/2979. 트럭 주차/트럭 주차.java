import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int result = solve(br);
    bw.write(String.valueOf(result));

    br.close();
    bw.close();
  }

  private static int solve(BufferedReader br) throws IOException {
    StringTokenizer abc = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(abc.nextToken());
    int b = Integer.parseInt(abc.nextToken());
    int c = Integer.parseInt(abc.nextToken());

    StringTokenizer aTime = new StringTokenizer(br.readLine());
    int aStart = Integer.parseInt(aTime.nextToken());
    int aEnd = Integer.parseInt(aTime.nextToken());
    StringTokenizer bTime = new StringTokenizer(br.readLine());
    int bStart = Integer.parseInt(bTime.nextToken());
    int bEnd = Integer.parseInt(bTime.nextToken());
    StringTokenizer cTime = new StringTokenizer(br.readLine());
    int cStart = Integer.parseInt(cTime.nextToken());
    int cEnd = Integer.parseInt(cTime.nextToken());

    List<Integer> aTemp = createList(aStart, aEnd);
    List<Integer> bTemp = createList(bStart, bEnd);
    List<Integer> cTemp = createList(cStart, cEnd);
    aTemp.addAll(bTemp);
    aTemp.addAll(cTemp);

    Collections.sort(aTemp);

    int min = Collections.min(aTemp);
    int max = Collections.max(aTemp);
    int sum = 0;
    for (int i = min; i <= max; i++) {
      int count = Collections.frequency(aTemp, i);
      if (count == 1) {
        sum += a * 1;
      } else if (count == 2) {
        sum += b * 2;
      } else if (count == 3) {
        sum += c * 3;
      }
    }
    return sum;
  }

  private static List<Integer> createList(int start, int end) {
    List<Integer> numbers = new ArrayList<>();
    for (int i = start; i < end; i++) {
      numbers.add(i);
    }
    return numbers;
  }

}
