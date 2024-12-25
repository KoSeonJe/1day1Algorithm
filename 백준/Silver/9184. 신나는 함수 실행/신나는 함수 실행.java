import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  class Node{
    int a;
    int b;
    int c;
    int count;

    public Node(int a, int b, int c, int count) {
      this.a = a;
      this.b = b;
      this.c = c;
      this.count = count;
    }
  }
  int[][][] memo = new int[21][21][21];
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Main functionExecution = new Main();
    functionExecution.executedFunction(sc);
    sc.close();
  }

   private void executedFunction(Scanner sc) {
    int a = 0;
    int b = 0;
    int c = 0;
    List<Node> temp = new ArrayList<>();
    while(!(a==-1&&b==-1&&c==-1)){
      a=sc.nextInt();
      b=sc.nextInt();
      c=sc.nextInt();
      if(!(a==-1&&b==-1&&c==-1)) {
        temp.add(new Node(a, b, c, W(a, b, c)));
      }
    }
    for(Node node : temp){
      System.out.println("w("+ node.a+", "+node.b+", "+node.c+") = "+ node.count);
    }
  }

  private int W(int a, int b, int c) {

    if (a <= 0 || b <= 0 || c <= 0) {
      return 1;
    }

    if (a > 20 || b > 20 || c > 20) {
      return W(20,20,20);
    }

    if (memo[a][b][c] != 0) {
      return memo[a][b][c];
    }

    if (a < b && b < c) {
      memo[a][b][c]= W(a, b, c - 1) + W(a, b - 1, c - 1) - W(a, b - 1, c);
      return memo[a][b][c];
    }
    memo[a][b][c] = W(a - 1, b, c) + W(a - 1, b - 1, c) + W(a - 1, b, c - 1) - W(a - 1, b - 1, c - 1);
    return memo[a][b][c];
  }
  }