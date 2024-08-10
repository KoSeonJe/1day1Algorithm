import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  private static String solution(int[] data) {
    int sum = 0;
    List<Integer> results = new ArrayList<>();
    for (int i = 0; i < data.length; i++) {
      int answer = data[i] * (i + 1) - sum;
      sum = (i + 1) * data[i];
      results.add(answer);
    }
    String sResult = "";

    for (Integer result : results) {
      sResult += result + " ";
    }
    return sResult;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] num = getInput(br);
    int[] data = getInput(br);
    br.close();
    resolve(solution(data));
  }

  private static int[] getInput(BufferedReader br) throws IOException {
    int[] input;
    int[] nums = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();
    input = nums;

    return input;
  }

  private static void resolve(String answer) throws IOException {
    try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      bw.write(answer);
    }
  }
}
