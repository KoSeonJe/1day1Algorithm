import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[21];
        for (int i = 1; i < 21; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < 10; i++) {
            String[] s = br.readLine().split(" ");
            int startIndex = Integer.parseInt(s[0]);
            int endIndex = Integer.parseInt(s[1]);
            swapRange(arr, startIndex, endIndex);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            builder.append(arr[i]).append(" ");
        }
        System.out.println(builder);
        br.close();
    }

    private static void swapRange(final int[] arr, final int startIndex, final int endIndex) {
        int length = endIndex - startIndex;

        for (int i = 0; i <= length/2; i++) {
            int temp = arr[endIndex-i];
            arr[endIndex-i] = arr[startIndex+i];
            arr[startIndex+i] = temp;
        }

    }
}
