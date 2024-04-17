import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int M = sc.nextInt();
    Main problem = new Main();
    int N = problem.calculate(M);
    System.out.println(N);
    sc.close();
  }

  private int calculate(int m) {
    int result = 0;
    for (int i = 0; i < m ; i++) {
      int sum = 0;
      int number = i;
      while (number != 0) {
        sum = sum + number % 10;
        number = number / 10;
      }

      if (sum + i == m) {

        result = i;
        break;
      }
    }
    return result;
  }
}
