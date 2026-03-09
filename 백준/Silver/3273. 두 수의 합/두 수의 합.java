import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1. 정렬
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        String[] rawNumbers = br.readLine().split(" ");
        int target = Integer.parseInt(br.readLine());

        int[] numbers = new int[rawNumbers.length];
        for (int i = 0; i <rawNumbers.length; i++) {
            numbers[i] = Integer.parseInt(rawNumbers[i]);
        }

        int result = 0;
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i+1; j<numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);

        br.close();
    }
}
