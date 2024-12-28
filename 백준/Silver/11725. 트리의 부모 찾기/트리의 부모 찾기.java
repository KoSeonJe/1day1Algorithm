import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {

  class Node {
    Node parent;
    int key;

    public Node(int key) {
      this.key = key;
    }

    @Override
    public boolean equals(Object o) {
      Node node = (Node)o;
      return node.key == this.key;
    }

    @Override
    public int hashCode() {
      return Objects.hash(key);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Main findTreeParent = new Main();
    findTreeParent.inputData(sc, n);
    sc.close();
  }

  private void inputData(Scanner sc, int n) {
    Queue<Node> nodes = new PriorityQueue<>((o1, o2) -> {
      if (o1.key > o2.key) {
        return 1;
      } else if (o1.key < o2.key) {
        return -1;
      }

      return 0;
    });
    Set<Node> checks = new HashSet<>();
    Queue<Node> temp = new ArrayDeque<>();
    Map<Integer, List<Integer>> boards = new HashMap<>();
    Node root = new Node(1);
    root.parent=new Node(-1);
    checks.add(root);
    temp.add(root);
    for (int i = 0; i < n-1 ; i++) {
      int num1 = sc.nextInt();
      int num2 = sc.nextInt();
      putBoards(boards, num1, num2);
      putBoards(boards, num2, num1);
    }
  
    while (!temp.isEmpty()) {
      Node node = temp.poll();
      List<Integer> values = boards.remove(node.key);
      for (int i = 0; i < values.size(); i++) {
        Node child = new Node(values.get(i));
        int size = checks.size();
        checks.add(child);
        if (!(size == checks.size())) {
          child.parent = node;
          nodes.add(child);
          temp.add(child);
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!nodes.isEmpty()) {
      sb.append(nodes.poll().parent.key + "\n");
    }
    System.out.println(sb);
  }

  private void putBoards(Map<Integer, List<Integer>> boards, int num1, int num2) {
    if (boards.get(num1) == null) {
      List<Integer> temp = new ArrayList<>();
      temp.add(num2);
      boards.put(num1, temp);
    } else {
      List<Integer> childs = boards.get(num1);
      childs.add(num2);
    }
  }
}

