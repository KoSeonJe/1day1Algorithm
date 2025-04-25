import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        String operation = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = Integer.parseInt(br.readLine());
        while (!Objects.equals(operation, "=")) {
            operation = br.readLine();
            if (operation.equals("=")) {
                break;
            }
            int num = Integer.parseInt(br.readLine());
            result = calculate(operation, result, num);
        }
        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    public static int calculate(String operation, int number1, int number2) {
        switch (operation) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                return number1 / number2;
        }
        return -1;
    }
}