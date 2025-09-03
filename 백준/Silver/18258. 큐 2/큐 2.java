import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

  private final ArrayDeque<Integer> que = new ArrayDeque<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Main myQueues = new Main();
    myQueues.orderInput(br, n);
  }

  private void orderInput(BufferedReader br, int n) throws IOException {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n ; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String orderName = st.nextToken();
      if (Objects.equals(orderName, "push")) {
        int number = Integer.parseInt(st.nextToken());
        order(orderName, number, sb);
        continue;
      }
      order(orderName, -1, sb);
    }
    System.out.println(sb.toString());
  }

  private void order(String orderName, int n, StringBuilder sb){
    switch (orderName){
      case "push" :
        que.add(n);
        break;
      case "pop" :
        if(que.isEmpty()){
          sb.append(-1).append("\n");
        }else{
          sb.append(que.poll()).append("\n");
        }
        break;
      case "size" :
        sb.append(que.size()).append("\n");
        break;
      case "empty" :
        if (que.isEmpty()) {
          sb.append(1).append("\n");
        }else{
          sb.append(0).append("\n");
        }
        break;
      case "front" :
        if(que.isEmpty()){
          sb.append(-1).append("\n");
        }else{
          sb.append(que.peek()).append("\n");
        }
        break;
      case "back" :
        if (que.isEmpty()) {
          sb.append(-1).append("\n");
        }else{
          sb.append(que.getLast()).append("\n");
        }
        break;
    }
  }
}