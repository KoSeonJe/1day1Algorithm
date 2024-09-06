import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    Main pocketmon = new Main();
    Map<Integer, String> pocketmonFinder = new HashMap<>();
    Map<String, Integer> indexFinder = new HashMap<>();
    pocketmon.createPocket(sc, n, pocketmonFinder, indexFinder);
    StringBuilder sb = new StringBuilder();
    pocketmon.printAnwser(sc, m, pocketmonFinder, indexFinder, sb);
    System.out.println(sb);
    sc.close();
  }

  private void printAnwser(Scanner sc, int m, Map<Integer, String> pocketmonFinder,
      Map<String, Integer> indexFinder, StringBuilder sb) {
    for (int i = 0; i <m ; i++) {
      String problem = sc.next();
      if(isInteger(problem)){
        int temp = Integer.parseInt(problem);
        sb.append(pocketmonFinder.get(temp)).append("\n");
      }else{
        sb.append(indexFinder.get(problem)).append("\n");
      }
    }
  }

  private boolean isInteger(String next) {
    try {
      Integer.parseInt(next);
      return true;
    } catch (NumberFormatException exception) {
      return false;
    }
  }

  private void createPocket(Scanner sc, int n, Map<Integer, String> pocketmonFinder,
      Map<String, Integer> indexFinder) {
    for (int i = 0; i < n; i++) {
      String input = sc.next();
      pocketmonFinder.put(i + 1, input);
      indexFinder.put(input, i + 1);
    }
  }
}
