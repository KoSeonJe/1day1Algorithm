import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                builder.append(" ");
            }
            for (int k = 0; k < n - i; k++) {
                builder.append("*");
            }

            builder.append("\n");
        }
        System.out.println(builder.toString());
    }
}
