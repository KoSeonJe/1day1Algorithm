import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int pay = Integer.parseInt(reader.readLine());
        List<Integer> history = createHistory(reader);
        int BNP = calculateBNP(pay, history);
        int TIMING = calculateTIMING(pay, history);

        if (BNP == TIMING) {
            writer.write("SAMESAME");
        } else if (BNP > TIMING) {
            writer.write("BNP");
        } else if (BNP < TIMING) {
            writer.write("TIMING");
        }
        reader.close();
        writer.close();
    }

    private static int calculateTIMING(int pay, List<Integer> history) {
        int amount = pay;
        int totalCount = 0;
        int buyPoint = 0;
        int sellPoint = 0;
        for (int i = 1; i < history.size(); i++) {
            if(history.get(i - 1) > history.get(i)) {
                buyPoint++;
                sellPoint = 0;
            }
            if (buyPoint >= 3) {
                if (amount / history.get(i) != 0) {
                    totalCount += amount / history.get(i);
                    amount = amount % history.get(i);
                }
                continue;
            }

            if (history.get(i - 1) < history.get(i)) {
                sellPoint++;
                buyPoint = 0;
            }
            if (sellPoint >= 3) {
                amount += totalCount * history.get(i);
                continue;
            }

            if (Objects.equals(history.get(i - 1), history.get(i))) {
                sellPoint = 0;
                buyPoint = 0;
            }
        }
        return amount + totalCount * history.get(history.size() - 1);
    }

    private static int calculateBNP(int pay, List<Integer> history) {
        int temp = pay;
        int total = 0;
        for (int node : history) {
            if (temp / node != 0) {
                total += temp / node;
                temp = temp % node;
            }

            if (temp == 0) {
                break;
            }
        }
        return temp + total * history.get(history.size() - 1);
    }

    private static List<Integer> createHistory(BufferedReader reader) throws IOException {
        List<Integer> history = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        while (st.hasMoreTokens()) {
            history.add(Integer.parseInt(st.nextToken()));
        }
        return history;
    }
}
