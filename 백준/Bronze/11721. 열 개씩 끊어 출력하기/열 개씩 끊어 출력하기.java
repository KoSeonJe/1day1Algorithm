import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp = br.readLine();
        int length = temp.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length / 10 ; i++) {
            builder.append(temp.substring(i * 10, 10 * (i + 1))).append("\n");
        }

        if (length % 10 != 0) {
            builder.append(temp.substring((length/10) * 10));
        }

        System.out.println(builder);
        br.close();
    }
}
