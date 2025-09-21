import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] numbers;
    static List<Integer> commandAll;
    static boolean[] visited;
    static int max = -1000000000;
    static int min = 1000000000;

    public static void main(String[] args) throws IOException {
        //11234 -> 모든 순열 백트래킹
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] commands = new int[4];
        StringTokenizer commandsSt = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            commands[i] = Integer.parseInt(commandsSt.nextToken());
        }
        commandAll = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int commandCount = commands[i];
            for (int j = 0; j < commandCount; j++) {
                commandAll.add(i);
            }
        }

        visited = new boolean[commandAll.size()];
        List<Integer> temp = new ArrayList<>();
        backTracking(0, temp);
        System.out.println(max);
        System.out.println(min);
        br.close();
    }

    private static void backTracking(final int index, final List<Integer> temp) {
        if (temp.size() == commandAll.size()) {
            int result = calculate(temp);
            if (max < result) {
                max = result;
            }

            if (min > result) {
                min = result;
            }
            return;
        }

        for (int i = 0; i < commandAll.size(); i++) {
            if (visited[i]) {
                continue;
            }
            temp.add(commandAll.get(i));
            visited[i] = true;
            backTracking(index + 1, temp);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }

    private static int calculate(final List<Integer> temps) {
        int i = 0;
        int sum = numbers[i];
        i++;
        for (int temp : temps) {
            switch (temp) {
                case 0: {
                    sum += numbers[i];
                    i++;
                    break;
                }
                case 1: {
                    sum -= numbers[i];
                    i++;
                    break;
                }
                case 2: {
                    sum *= numbers[i];
                    i++;
                    break;
                }
                case 3: {
                    if (sum < 0) {
                        sum = -(Math.abs(sum) / numbers[i]);
                    } else {
                        sum /= numbers[i];
                    }
                    i++;
                    break;
                }
            }
        }
        return sum;
    }
}
