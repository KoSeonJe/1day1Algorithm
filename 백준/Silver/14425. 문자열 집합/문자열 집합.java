import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int s = sc.nextInt();
    int m = sc.nextInt();
    Main ss = new Main();
    List<String> sSet = ss.input(s, sc);
    List<String> mSet = ss.input(m, sc);
    int result = ss.findEqualNumber(sSet, mSet);
    System.out.println(result);
    sc.close();
  }

  private int findEqualNumber(List<String> sSet, List<String> mSet) {
    mSet.retainAll(sSet);
    return mSet.size();
  }

  private List<String> input(int s, Scanner sc) {
    List<String> tempSet = new ArrayList<>();
    for (int i = 0; i < s; i++) {
      tempSet.add(sc.next());
    }
    return tempSet;
  }
}
