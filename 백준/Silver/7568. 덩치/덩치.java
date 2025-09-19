import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static class Human {
        int key;
        int weight;
        int rank = 1;

        public Human(final int key, final int weight) {
            this.key = key;
            this.weight = weight;
        }

        public boolean isBiggerThan(final Human human) {
            return key > human.key && weight > human.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Human> humans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] kw = br.readLine().split(" ");
            humans.add(new Human(Integer.parseInt(kw[0]), Integer.parseInt(kw[1])));
        }
        for (int i = 0; i < humans.size(); i++) {
            Human human = humans.get(i);
            for (int j = 0; j < humans.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (humans.get(j).isBiggerThan(human)) {
                    human.rank++;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Human human : humans) {
            stringBuilder.append(human.rank).append(" ");
        }
        System.out.println(stringBuilder);
        br.close();
    }
}
