import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    static ArrayDeque<Integer> que = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().split(" ");
            if (parts[0].equals("push")) {
                que.addLast(Integer.parseInt(parts[1]));
            } else {
                int result = calculateQueue(parts[0]);
                builder.append(result).append("\n");
            }
        }

        System.out.println(builder);

        br.close();
    }

    private static int calculateQueue(String command) {
        switch (command) {
            case "pop" : {
                if (que.isEmpty()) {
                    return -1;
                }
                return que.poll();
            }
            case "size" : {
                return que.size();
            }
            case "empty" : {
                if (que.isEmpty()) {
                    return 1;
                }
                return 0;
            }
            case "front" : {
                if (que.isEmpty()) {
                    return -1;
                }
                return que.peek();
            }
            case "back" : {
                if (que.isEmpty()) {
                    return -1;
                }
                return que.peekLast();
            }
            default : {
                return 0;
            }
        }
    }
}
