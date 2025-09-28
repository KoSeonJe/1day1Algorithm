import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n;
        StringBuilder builder = new StringBuilder();
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            double max = Double.MIN_VALUE;
            List<String> names = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] nameKey = br.readLine().split(" ");
                String name = nameKey[0];
                double key = Double.parseDouble(nameKey[1]);
                if (max > key) {
                    continue;
                } else if (max == key) {
                    names.add(name);
                } else if (max < key) {
                    names.clear();
                    max = key;
                    names.add(name);
                }
            }

            for (String name : names) {
                builder.append(name).append(" ");
            }
            builder.append("\n");
        }

        System.out.println(builder);
        br.close();
    }
}
