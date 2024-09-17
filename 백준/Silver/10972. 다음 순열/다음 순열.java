import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = inputData(n, br);
    int[] next = calculate(arr);
    if (next == null) {
      bw.write("-1");
    } else {
      StringBuilder sb = new StringBuilder();
      for (int parm : next) {
        if (parm == 0) {
          continue;
        }
        sb.append(parm).append(" ");
      }
      bw.write(sb.toString());
    }
    br.close();
    bw.close();
  }

  private static int[] calculate(int[] arr) {
    int lastIndex = arr.length-1;
    int startIndex = arr.length-1;
    int standardIndex = 0;
    for (int i = lastIndex; i > 1 ; i--) {
      if (arr[i] < arr[i - 1]) {
        startIndex--;
      } else {
        break;
      }
    }

    if (startIndex == 1) {
      return null;
    }

    standardIndex = startIndex - 1;

    for (int i = lastIndex; i >= startIndex; i--) {
      if(arr[standardIndex] < arr[i]) {
        int temp = arr[standardIndex];
        arr[standardIndex] = arr[i];
        arr[i] = temp;
        break;
      }
    }

    int count = 0;
    for (int i = 0; i <= (lastIndex - startIndex) / 2; i++) {
      swap(startIndex + count, lastIndex - count, arr);
      count++;
    }

    return arr;
  }

  private static void swap(int i, int i1, int[] arr) {
    int temp = arr[i];
    arr[i] = arr[i1];
    arr[i1] = temp;
  }

  private static int[] inputData(int n, BufferedReader br) throws IOException {
    int[] arr = new int[n+1];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    return arr;
  }
}
