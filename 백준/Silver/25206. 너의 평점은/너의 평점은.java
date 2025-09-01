import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    static Map<String, Double> rankScore = Map.of(
            "A+", 4.5,
            "A0", 4.0,
            "B+", 3.5,
            "B0", 3.0,
            "C+", 2.5,
            "C0", 2.0,
            "D+", 1.5,
            "D0", 1.0,
            "F", 0.0
    );

    static class Subject {
        String name;
        double score;
        String rank;

        public Subject(final String name, final double score, final String rank) {
            this.name = name;
            this.score = score;
            this.rank = rank;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Subject> subjects = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String[] parts = br.readLine().split(" ");
            subjects.add(new Subject(parts[0], Double.parseDouble(parts[1]), parts[2]));
        }

        double sumScore = subjects.stream()
                .filter(subject -> !subject.rank.equals("P"))
                .mapToDouble(subject -> subject.score)
                .sum();

        double sumRank = subjects.stream()
                .filter(subject -> !subject.rank.equals("P"))
                .mapToDouble(subject -> subject.score * rankScore.get(subject.rank))
                .sum();
        System.out.println(sumRank / sumScore);
        br.close();
    }
}
