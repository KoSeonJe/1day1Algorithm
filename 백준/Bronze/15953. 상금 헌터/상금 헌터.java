import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  private static int solution(int[] nums) {
    int answer = 0;
    int a = nums[0];
    int aValues = 0;
    int b = nums[1];
    int bValues = 0;

    if (a < 1 || a > 21) {
      aValues = 0; // 21위 이상일 경우 상금 0
    } else if (a == 1) {
      aValues = 5000000;
    } else if (a <= 3) {
      aValues = 3000000;
    } else if (a <= 6) {
      aValues = 2000000;
    } else if (a <= 10) {
      aValues = 500000;
    } else if (a <= 15) {
      aValues = 300000;
    } else if (a <= 21) {
      aValues = 100000;
    }

    if (b < 1 || b > 31) {
      bValues = 0; // 31위 이상일 경우 상금 0
    } else if (b == 1) {
      bValues = 5120000;
    } else if (b <= 3) {
      bValues = 2560000;
    } else if (b <= 7) {
      bValues = 1280000;
    } else if (b <= 15) {
      bValues = 640000;
    } else if (b <= 31) {
      bValues = 320000;
    }
    return aValues + bValues;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    List<Integer> results = new ArrayList<>();
    for (int i = 0; i < t; i++) {
      int[] input = getInput(br);
      results.add(solution(input));
    }
    resolve(results);
  }

  private static int[] getInput(BufferedReader br) throws IOException {
    int[] input;
      int[] nums = Arrays.stream(br.readLine().split(" "))
          .mapToInt(Integer::parseInt)
          .toArray();
      input = nums;
    return input;
  }

  private static void resolve(List<Integer> answer) throws IOException {
    int size = answer.size();
    try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      for (int i = 0; i < size; i++) {
        bw.write(String.valueOf(answer.remove(0)) + "\n");
      }
    }
  }
}
