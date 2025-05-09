import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        int v = Integer.parseInt(inputs[2]);

        int result = (v - a) / (a - b) + 1;
        if (((v - a) % (a - b)) != 0) {
            result = result + 1;
        }
        System.out.println(result);
        br.close();
    }
}
