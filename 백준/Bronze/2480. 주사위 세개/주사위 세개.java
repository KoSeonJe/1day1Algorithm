import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.List;


public class Main {

    private static int solution(int[] nums) {
      int answer = 0;
      List<Integer> list = new ArrayList<>(List.of(nums[0], nums[1], nums[2]));
      List<Integer> dislist = list.stream().distinct().collect(Collectors.toList());
      if (dislist.size() == 3) {
        int max = Collections.max(dislist);
        return max * 100;
      } else if (dislist.size() == 2) {
        if(list.get(0) == list.get(1)) {
          return 1000 + list.get(0) * 100;
        } else if (list.get(1) == list.get(2)) {
          return 1000 + list.get(1) * 100;
        } else if (list.get(2) == list.get(0)) {
          return 1000 + list.get(2) * 100;
        }
      }
      return 10000 + dislist.get(0) * 1000;
    }

    public static void main(String[] args) throws IOException {
      int[] input = getInput();
      resolve(solution(input));
    }

    private static int[] getInput() throws IOException {
      int[] input;
      try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
        int[] nums = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        input = nums;
      }
      return input;
    }

    private static void resolve(int answer) throws IOException {
      try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
        bw.write(String.valueOf(answer));
      }
    }
  }
