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

        int switchCount = Integer.parseInt(reader.readLine());
        List<Integer> switchState = createSwitchState(reader, switchCount);

        int studentCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < studentCount; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            int sex = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            changeState(switchState, sex, number - 1);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= switchState.size(); i++) {
            if (i % 20 == 1 && i != 1) {
                result.append("\n");
            }
            result.append(switchState.get(i - 1)).append(" ");
        }
        writer.write(result.toString());
        reader.close();
        writer.close();
    }

    private static void changeState(List<Integer> switchState, int sex, int number) {
        if (sex == 1) {
            changeManState(switchState, number);
            return;
        }
        if (sex == 2) {
            changeWomanState(switchState, number);
            return;
        }
    }

    private static void changeWomanState(List<Integer> switchState, int number) {
        int depth = 0;
        while (number + depth < switchState.size() - 1 && number - depth > 0) {
            if (!Objects.equals(switchState.get(number + depth + 1), switchState.get(number - depth - 1))) {
                break;
            }
            depth++;
        }
        reverseNumber(switchState, number);
        for (int i = 1; i <= depth; i++) {
            reverseNumber(switchState, number + i);
            reverseNumber(switchState, number - i);
        }
    }

    private static void reverseNumber(List<Integer> switchState, int number) {
        if (switchState.get(number) == 0) {
            switchState.set(number, 1);
            return;
        }

        if (switchState.get(number) == 1) {
            switchState.set(number, 0);
            return;
        }
    }

    private static void changeManState(List<Integer> switchState, int number) {
        int size = switchState.size();
        int count = size / (number + 1);
        int temp = number;
        for (int i = 0; i < count; i++) {
            reverseNumber(switchState, temp);
            temp += number + 1;
        }
    }

    private static List<Integer> createSwitchState(BufferedReader reader, int switchCount) throws IOException {
        List<Integer> switchState = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < switchCount; i++) {
            switchState.add(Integer.parseInt(st.nextToken()));
        }
        return switchState;
    }
}
