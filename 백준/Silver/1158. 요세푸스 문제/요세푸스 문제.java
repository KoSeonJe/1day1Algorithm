import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class Main {
//1 4 - 3 6 2 7 5 1 4

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            que.add(i);
        }

        int count = 0;
        List<Integer> temps = new ArrayList<>();
        while (!que.isEmpty()) {
            count++;
            int value = que.poll();
            if (count == m) {
                temps.add(value);
                count = 0;
                continue;
            }
            que.add(value);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < temps.size(); i++) {
            if (i == 0) {
                builder.append("<");
            }
            if (i == temps.size() - 1) {
                builder.append(temps.get(i)).append(">");
                break;
            }
            builder.append(temps.get(i)).append(", ");
        }
        System.out.println(builder);
        br.close();
    }
}
