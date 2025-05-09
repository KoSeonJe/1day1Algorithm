import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> mushrooms = createMush(br);

        int resultUnder = 0;
        int resultUpper = 0;
        int hold = 0;
        for (int i = 0; i < mushrooms.size(); i++) {
            resultUnder += mushrooms.get(i);
            if (i != mushrooms.size() - 1 &&resultUnder + mushrooms.get(i + 1) > 100) {
                resultUpper = resultUnder + mushrooms.get(i + 1);
                hold = i;
                break;
            }
        }

        if (Math.abs(100 - resultUnder) < Math.abs(100 - resultUpper)) {
            System.out.println(resultUnder);
            return;
        }

        System.out.println(resultUpper);
        br.close();
    }

    private static List<Integer> createMush(BufferedReader br) throws IOException {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            temp.add(Integer.parseInt(br.readLine()));
        }
        return temp;
    }
}
