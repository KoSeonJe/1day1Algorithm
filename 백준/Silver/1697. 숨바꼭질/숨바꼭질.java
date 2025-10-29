import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    static int k;
    static int MAX = 100000;

    static class Node {
        private int value;
        private List<Node> nodes = new ArrayList<>();
        private int depth;

        public Node(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }

        public void addNodes(Node node) {
            nodes.add(node);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        k = Integer.parseInt(nk[1]);

        bfs2(n);
        br.close();
    }

    private static void bfs2(int n) {
        boolean[] visited = new boolean[MAX + 1];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{n, 0});
        visited[n] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int position = poll[0];
            int time = poll[1];

            if (position == k) {
                System.out.println(time);
                break;
            };

            int[] newPosition = {position + 1, position - 1, position * 2};
            for (int np : newPosition) {
                if (np >= 0 && np <= MAX && !visited[np]) {
                    visited[np] = true;
                    queue.add(new int[]{np, time + 1});
                }
            }
        }
    }
}
