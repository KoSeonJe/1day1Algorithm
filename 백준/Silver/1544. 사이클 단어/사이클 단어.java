import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<String> temps = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            temps.add(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (temps.isEmpty()) {
                break;
            }
            String removed = temps.remove(0);
            count++;
            List<String> removeTarget = new ArrayList<>();
            for (String temp : temps) {
                if (removed.length() != temp.length()) {
                    continue;
                }
                char c = removed.charAt(0);
                List<Integer> indexes = new ArrayList<>();
                for (int j = 0; j < temp.length(); j++) {
                    if (c == temp.charAt(j)) {
                        indexes.add(j);
                    }
                }
                for (int index : indexes) {
                    boolean isEqual = true;
                    for (int j = 0; j < removed.length(); j++) {
                        if (removed.charAt(j) != temp.charAt((j + index) % temp.length())) {
                            isEqual = false;
                            break;
                        }
                    }
                    if (isEqual) {
                        removeTarget.add(temp);
                        break;
                    }
                }
            }
            temps.removeAll(removeTarget);
        }
        System.out.println(count);
        br.close();
    }
}
