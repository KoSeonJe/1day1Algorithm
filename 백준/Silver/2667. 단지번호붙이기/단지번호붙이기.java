import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
  int[][] unit;
  boolean[][] visited;
  int houseCount;
  ArrayList<Integer> temp = new ArrayList<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Main houseUnit = new Main();
    int numOfUnit = sc.nextInt();
    houseUnit.createUnit(numOfUnit, sc);
    houseUnit.findUnit();
    sc.close();
  }

  private void createUnit(int numOfUnit, Scanner sc){
    unit = new int[numOfUnit][numOfUnit];
    visited = new boolean[numOfUnit][numOfUnit];
    for(int i =0; i<numOfUnit; i++){
      String line = sc.next();
      for(int j=0; j<numOfUnit; j++){
        unit[i][j] = line.charAt(j)-'0';
      }
    }
  }

  private void findUnit(){
    for(int i =0; i<unit.length; i++){
      for(int j =0; j<unit.length; j++){
        if(unit[i][j] == 1 && !visited[i][j]){
          visited[i][j]=true;
          houseCount=1;
          temp.add(dfs(i,j));
        }
      }
    }
    Collections.sort(temp);
    System.out.println(temp.size());
    for(Integer r : temp){
      System.out.println(r);
    }
  }

  private int dfs(int x, int y){
      findHouse(x+1,y);
      findHouse(x,y+1);
      findHouse(x-1,y);
      findHouse(x,y-1);
    return houseCount;
  }

  private void findHouse(int x , int y){
    if(!(x >= 0 && y >= 0 && x < unit.length && y < unit[0].length)) {
      return;
    }
      if(unit[x][y]==1 && !visited[x][y]){
        houseCount++;
        visited[x][y]=true;
        dfs(x,y);
      }
    
  }
}

