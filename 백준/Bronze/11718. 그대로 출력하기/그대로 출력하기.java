import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        StringBuilder builder = new StringBuilder();
        while (count <= 100) {
            String input = br.readLine();
            if (input == null) {
                break;
            }
            builder.append(input).append("\n");
            count++;
        }
        System.out.println(builder.toString());
    }
}
