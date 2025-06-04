import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class Main {

    static int finish = 210;

    static class Info {
        int time;
        String answerType;

        public Info(int time, String answerType) {
            this.time = time;
            this.answerType = answerType;
        }

        public int getTime() {
            return time;
        }

        public String getAnswerType() {
            return answerType;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        List<Info> infos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] part = br.readLine().split(" ");
            infos.add(new Info(Integer.parseInt(part[0]), part[1]));
        }

        Deque<Integer> people = new ArrayDeque<>();
        for (int i = 0; i < 8; i++) {
            int temp = (k - 1 + i) % 8 + 1;
            people.add(temp);
        }

        int tempTime = 0;
        for (Info info : infos) {
            tempTime += info.getTime();
            if (finish <= tempTime) {
                break;
            }
            if (Objects.equals(info.answerType, "T")) {
                int pass = people.removeFirst();
                people.add(pass);
            }
        }
        int realResult = people.getFirst();
        System.out.println(realResult);

        br.close();
    }
}
