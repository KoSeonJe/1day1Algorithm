import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    static List<List<Integer>> nums;
    static boolean[] visited;

    //시계 : 마지막꺼 빼고 첫번째에 추가
    //반시계 : 첫번째꺼 뺴고 마지막에 추가
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> num1 = createWheel(br); //2
        List<Integer> num2 = createWheel(br); //2, 6
        List<Integer> num3 = createWheel(br); //2, 6
        List<Integer> num4 = createWheel(br); //6

        nums = List.of(num1, num2, num3, num4);

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            String[] nd = br.readLine().split(" ");
            int num = Integer.parseInt(nd[0]);
            int direction = Integer.parseInt(nd[1]);
            visited = new boolean[4];
            List<Integer> selected = (num - 1)>= 0 ? nums.get(num - 1) : null;
            visited[num - 1] = true;
            move(direction, selected, num);
        }
        int n1 = num1.get(0) == 0 ? 0 : 1;
        int n2 = num2.get(0) == 0 ? 0 : 2;
        int n3 = num3.get(0) == 0 ? 0 : 4;
        int n4 = num4.get(0) == 0 ? 0 : 8;
        System.out.println(n1 + n2 + n3 + n4);
        br.close();
    }

    private static void move(final int direction, final List<Integer> selected, int num) {
        List<Integer> back = (num - 2)>= 0 ? nums.get(num - 2) : null;
        List<Integer> front = num < 4 ? nums.get(num) : null;
        if (back != null && !visited[num - 2] && !Objects.equals(selected.get(6), back.get(2))) {
            visited[num - 2] = true;
            if (direction == 1) {
                move(-1, back, num -1);
            } else {
                move(1, back, num -1);
            }
        }
        if (front != null && !visited[num] &&!Objects.equals(selected.get(2), front.get(6))) {
            visited[num] = true;
            if (direction == 1) {
                move(-1, front, num + 1);
            } else {
                move(1, front, num + 1);
            }
        }

        if (direction == 1) {
            selected.add(0, selected.remove(selected.size() - 1));
        } else {
            selected.add(selected.size() - 1, selected.remove(0));
        }

    }

    private static List<Integer> createWheel(final BufferedReader br) throws IOException {
        List<Integer> nums = new ArrayList<>();
        String[] split = br.readLine().split("");
        for (int i = 0; i < 8; i++) {
            nums.add(Integer.parseInt(split[i]));
        }

        return nums;
    }
}
