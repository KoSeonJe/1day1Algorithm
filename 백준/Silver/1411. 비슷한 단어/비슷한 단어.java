import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = br.readLine();
        }
        List<String> same = convertToInt(input);

        int count = 0;
        for (int i = 0; i < same.size(); i++) {
            for (int j = i + 1; j < same.size(); j++) {
                if (Objects.equals(same.get(i), same.get(j))) {
                    count++;
                }
            }
        }
        System.out.println(count);
        br.close();
    }

    private static List<String> convertToInt(final String[] input) {
        List<String> temps = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            String inputPart = input[i]; // aa
            String temp = "";
            Map<Character, Integer> maps = new HashMap<>();
            int k = 0;
            for (int j = 0; j < inputPart.length(); j++) {
                char c = inputPart.charAt(j);
                if (maps.containsKey(c)) {
                    temp += maps.get(c);
                    continue;
                }
                temp += k;
                maps.put(c, k);
                k++;
            }
            temps.add(temp);
        }
        return temps;
    }
}
