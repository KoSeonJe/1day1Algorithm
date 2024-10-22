import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Main maxHeap = new Main();
    maxHeap.input(sc, n);
    sc.close();
  }

  private void input(Scanner sc, int n) {
    int[] heap = new int[n+1];
    for (int i = 1; i < n+1; i++) {
      int x = sc.nextInt();

      if(x==0){
        if(heap[1] == 0){
          System.out.println(0);
          continue;
        }

          System.out.println(heap[1]);
          heap[1] = heap[i];
          heap[i] = 0;
          //내려가는 메소드
          int p = 1;
          while(true) {
            if (p > i) {
              break;
            }

            if(2 * p + 1 >= n + 1 && 2 * p >= n + 1){
              break;
            }

            if (2 * p + 1 >= n + 1) {
              if (heap[p] < heap[2 * p]) {
                swap(p, 2 * p, heap);
                p = 2 * p;
              }
              break;
            }

            if (heap[p] < heap[2 * p] && heap[p] < heap[2 * p + 1]) {
              if (heap[2 * p] > heap[2 * p + 1]) {
                swap(p, 2 * p, heap);
                p = 2 * p;
              }else{
                swap(p, 2 * p + 1, heap);
                p = 2 * p + 1;
              }
            } else if (heap[p] < heap[2 * p]) {
              swap(p, 2 * p, heap);
              p = 2 * p;
            } else if (heap[p] < heap[2 * p + 1]) {
              swap(p, 2 * p + 1, heap);
              p = 2 * p + 1;
            }else{
              break;
            }

          }
      }

      int temp = i;
      heap[i] = x;
      //올라가는 메소드
      while(true) {
        if (temp <= 1) {
          break;
        }
       if (heap[temp] > heap[temp / 2]) {
          swap(temp, temp / 2, heap);
          temp = temp/2;
        } else {
          break;
        }
      }

    }
  }

  private void swap(int i, int i1, int[] heap) {
    int temp = 0;
    temp = heap[i];
    heap[i] = heap[i1];
    heap[i1] = temp;
  }
}
