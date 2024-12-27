import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Main postFixNotation = new Main();
    int n = sc.nextInt();
   String st = sc.next();
    Map<String, Integer> numbers = postFixNotation.inputNumber(sc, n);
    postFixNotation.calculate(st, numbers);
    sc.close();
  }
  private void calculate(String st, Map<String, Integer> numbers) {
    char[] postFix = st.toCharArray();
    Stack<Double> stack = new Stack<>();
    for (char fix : postFix) {
      if (!((byte) fix >= 65 && (byte) fix <= 65 + numbers.size())) {
        double num1 = stack.pop();
        double num2 = stack.pop();
        double result = calculateNumber(num2, num1, fix);
        stack.push(result);
        continue;
      }
      stack.push((double) numbers.get(String.valueOf(fix)));
    }
    DecimalFormat df = new DecimalFormat("#.00");
    System.out.println(df.format(stack.pop()));
  }

  private double calculateNumber(double num1, double num2, int c) {
    double temp = 0;
    switch (c){
      case '*':
        temp = num1*num2;
        break;

      case '+':
        temp = num1+num2;
        break;

      case '-':
        temp = num1-num2;
        break;

      case '/':
        temp = num1/num2;
        break;

    }
    return temp;
  }

  private Map<String, Integer> inputNumber(Scanner sc, int n) {
    Map<String, Integer> nums = new HashMap<>();
    for (int i = 0; i <n; i++) {
      nums.put(Character.toString(65+i), sc.nextInt());
    }
    return nums;
  }
}
