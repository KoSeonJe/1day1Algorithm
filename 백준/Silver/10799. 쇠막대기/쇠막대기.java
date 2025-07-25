import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Deque<Character> temp = new ArrayDeque<>();
        char[] parts = input.toCharArray();

        int count = 0;
        for (int i = 0; i < parts.length; i++) {

            if (Objects.equals(parts[i], '(')) {
                if (i != parts.length -1 && parts[i + 1] == ')') {
                    count += temp.size();
                    continue;
                }
                temp.add(parts[i]);
                count += 1;
                continue;
            }

            if (Objects.equals(parts[i], ')')) {
                if (i != 0 && parts[i - 1] == '(') {
                    continue;
                }
                temp.remove();
            }
        }
        System.out.println(count);
        br.close();
    }
}
