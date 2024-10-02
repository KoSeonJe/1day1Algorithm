import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int target;
    static int[] arr;
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        StringTokenizer nums = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(nums.nextToken());
        }
        partialSequence(0, 0);

        if (target == 0) {
            count--;
        }
        bw.write(String.valueOf(count));
        br.close();
        bw.close();
    }

    private static void partialSequence(int depth, int sum) {
        if (depth == N) {
            if (sum == target) {
                count ++;
            }
            return;
        }

        partialSequence(depth + 1, sum + arr[depth]);
        partialSequence(depth + 1, sum);
    }
}
