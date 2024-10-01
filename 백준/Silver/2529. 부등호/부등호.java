import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static int N;
    static String[] arr;
    static int[] numbers;
    static boolean[] visited;
    static int[] temp;
    static Long max;
    static Long min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = inputArr(br.readLine());
        numbers = new int[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = i;
        }
        temp = new int[N + 1];
        visited = new boolean[10];
        max = Long.MIN_VALUE;
        calculateMax(0, Long.MIN_VALUE);
        temp = new int[N + 1];
        visited = new boolean[10];
        min = Long.MAX_VALUE;
        calculateMin(0, Long.MAX_VALUE);
        if ((int)(max / Math.pow(10L, N)) == 0) {
            String resultMax = "0" + max;
            bw.write(resultMax + "\n");
        } else {
            bw.write(String.valueOf(max) + "\n");
        }
        if ((int)(min / Math.pow(10L, N)) == 0) {
            String resultMin = "0" + min;
            bw.write(resultMin);
        } else {
            bw.write(String.valueOf(min));
        }
        br.close();
        bw.close();
    }

    private static void calculateMax(int depth, Long maxTemp) {
        if (depth >= N + 1) {
            if (max < maxTemp) {
                max = maxTemp;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (depth != 0) {
                if (!check(depth, i)) {
                    continue;
                }
            }
            if (visited[i]) {
                continue;
            }
            temp[depth] = numbers[i];
            visited[i] = true;
            calculateMax(depth + 1, parseArr(temp));
            visited[i] = false;
        }
    }

    private static void calculateMin(int depth, Long minTemp) {
        if (depth >= N + 1) {
            if (min > minTemp) {
                min = minTemp;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (depth != 0) {
                if (!check(depth, i)) {
                    continue;
                }
            }
            if (visited[i]) {
                continue;
            }
            temp[depth] = numbers[i];
            visited[i] = true;
            calculateMin(depth + 1, parseArr(temp));
            visited[i] = false;
        }
    }

    private static Long parseArr(int[] temp) {
        String result = "";
        for (int i = 0; i < temp.length; i++) {
            result += temp[i];
        }
        return Long.parseLong(result);
    }

    private static boolean check(int depth, int i) {
        if (arr[depth-1].equals("<")) {
            if (temp[depth-1] < i) {
                return true;
            }
            return false;
        } else if(arr[depth-1].equals(">")) {
            if (temp[depth-1] > i) {
                return true;
            }
            return false;
        }
        return false;
    }

    private static String[] inputArr(String input) {
        String[] arr = new String[N];
        StringTokenizer st = new StringTokenizer(input);
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken();
        }
        return arr;
    }
}
