import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int target = Integer.parseInt(br.readLine());
    int[] materials = inputMaterial(n, br);
    int count = caluclate(materials, target);
    bw.write(String.valueOf(count));
    br.close();
    bw.close();
  }

  private static int caluclate(int[] materials, int target) {
    int count = 0;
    for (int i = 0; i < materials.length; i++) {
      for (int j = i + 1; j < materials.length; j++) {
        if (materials[i] + materials[j] == target) {
          count++;
        }
      }
    }
    return count;
  }

  private static int[] inputMaterial(int n, BufferedReader br) throws IOException {
    int[] materials = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      materials[i] = Integer.parseInt(st.nextToken());
    }
    return materials;
  }
}
