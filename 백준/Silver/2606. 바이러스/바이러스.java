import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  boolean[][] edge;
  boolean[] visited;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numOfVertices = sc.nextInt();
    int numOfEdges = sc.nextInt();
    Main virus = new Main();
    virus.createData(numOfVertices, numOfEdges, sc);
    System.out.println(virus.getVirusCount(numOfVertices+1));

    sc.close();
  }

  private void createData(int numOfVertices ,int numOfEdges, Scanner sc){
    edge = new boolean[numOfVertices+1][numOfVertices+1];
    for(int i =0; i<numOfEdges; i++){
      int num1 = sc.nextInt();
      int num2 = sc.nextInt();
      edge[num1][num2] = true;
      edge[num2][num1] = true;
    }
    visited = new boolean[numOfVertices+1];
  }

  private int getVirusCount(int numOfVertices){
    int virusCom = 1;
    visited[1] = true;
    Queue<Integer> que = new ArrayDeque<>();
    que.offer(virusCom);
    while(!que.isEmpty()){
      int temp = que.poll();
      for(int i =0; i<numOfVertices; i++){
        if(edge[temp][i]&& !visited[i]){
          que.offer(i);
          visited[i] = true;
        }
      }
    }

    int count = 0;
    for (boolean b : visited) {
      if (b) {
        count++;
      }
    }

    return count-1;
  }
}