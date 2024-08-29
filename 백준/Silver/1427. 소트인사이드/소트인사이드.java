import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int result = convertDesc(n);
    bw.write(String.valueOf(result));
    br.close();
    bw.close();
  }

  private static int convertDesc(int n) {
    String s = String.valueOf(n);
    String[] nums = s.split("");
    List<Integer> sortTemp = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      sortTemp.add(Integer.parseInt(nums[i]));
    }
    Collections.sort(sortTemp, Collections.reverseOrder());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < sortTemp.size(); i++) {
      sb.append(sortTemp.get(i));
    }
    return Integer.parseInt(sb.toString());
  }
}
