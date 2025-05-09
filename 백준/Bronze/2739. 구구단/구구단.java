import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            builder.append(n).append(" * ").append(i).append(" = ").append(n * i).append("\n");
        }

        System.out.println(builder);
        br.close();
    }
}
