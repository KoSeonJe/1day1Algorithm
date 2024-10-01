import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] temp;
    static int max;
    static int N;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        setArr(br);
        temp = new int[N];
        visited = new boolean[N];
        calculate(0, 0);

        bw.write(String.valueOf(max));
        br.close();
        bw.close();
    }

    private static void calculate(int depth, int maxTemp) {
        if (depth >= N) {
            if (max < maxTemp) {
                max = maxTemp;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            temp[depth] = arr[i];
            visited[i] = true;
            calculate(depth + 1, sumArr(temp));
            visited[i] = false;
        }
    }

    private static int sumArr(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum += Math.abs(arr[i] - arr[i + 1]);
        }
        return sum;
    }

    private static void setArr(BufferedReader br) throws IOException {
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
