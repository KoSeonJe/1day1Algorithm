import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int k;

    //1. 가장 작은 소수 구하기
    //2. 배수대로 지우기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        k = Integer.parseInt(nk[1]);

        int temp = 2;
        boolean[] visited = new boolean[n+1];
        int count = 0;
        int result = 0;
        while (count <= k) {
            if (visited[temp]) {
                temp++;
                continue;
            }
            int divide = n / temp;
            if (divide == 0) {
                temp++;
                continue;
            }
            for (int i = 1; i <= divide; i++) {
                if (visited[temp * i]) {
                    continue;
                }
                visited[temp * i] = true;
                count++;
                if (count == k) {
                    result = temp * i;
                    System.out.println(result);
                    return;
                }
            }
        }
        br.close();
    }
}
