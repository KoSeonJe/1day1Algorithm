import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> que = fill(n);

        List<Integer> drawed = draw(que);
        StringBuilder builder = new StringBuilder();
        for (int drawedPart : drawed) {
            builder.append(drawedPart).append(" ");
        }
        System.out.println(builder);
        br.close();
    }

    private static List<Integer> draw(Deque<Integer> que) {
        List<Integer> temp = new ArrayList<>();
        boolean flag = true;
        while (que.size() > 1) {
            int drawed = que.poll();
            if (flag) {
                temp.add(drawed);
                flag = false;
            } else {
                que.add(drawed);
                flag = true;
            }
        }
        temp.add(que.poll());
        return temp;
    }

    private static Deque<Integer> fill(int n) {
        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            que.add(i);
        }
        return que;
    }
}
