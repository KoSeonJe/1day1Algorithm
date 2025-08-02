import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] xParts = br.readLine().split(" ");
        List<Integer> xs = new ArrayList<>();
        for (String part : xParts) {
            xs.add(Integer.parseInt(part));
        }

        String[] yParts = br.readLine().split(" ");
        List<Integer> ys = new ArrayList<>();
        for (String part : yParts) {
            ys.add(Integer.parseInt(part));
        }

        Collections.sort(xs);
        Collections.sort(ys,Collections.reverseOrder());

        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp += xs.get(i) * ys.get(i);
        }

        System.out.println(temp);
        br.close();
    }
}
