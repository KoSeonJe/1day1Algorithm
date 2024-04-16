import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Main problem = new Main();
    ArrayList<Integer> measure = problem.inputMeasure(n, sc);
    System.out.println(Collections.max(measure) * Collections.min(measure));
    sc.close();
  }

  private ArrayList<Integer> inputMeasure(int n, Scanner sc) {
    ArrayList<Integer> temp = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      temp.add(sc.nextInt());
    }
    return temp;
  }
}
