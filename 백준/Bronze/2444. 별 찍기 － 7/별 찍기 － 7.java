import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                builder.append(" ");
            }
            for (int k = n - i; k <= n + i; k++) {
                builder.append("*");
            }
            builder.append("\n");
        }
        for (int i = 1; i < n; i++) {
            for (int j = n - i; j < n; j++) {
                builder.append(" ");
            }
            for (int k = n - i - 4; k >= -(n - i + 2); k--) {
                builder.append("*");
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }
}
