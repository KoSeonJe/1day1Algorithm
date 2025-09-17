import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<char[]> caseChars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            caseChars.add(br.readLine().toCharArray());
        }
        calculateAfter(caseChars);
        StringBuilder builder = new StringBuilder();
        for (char[] caseChar : caseChars) {
            builder.append(new String(caseChar)).append("\n");
        }
        System.out.println(builder);
        br.close();
    }

    private static void calculateAfter(final List<char[]> caseChars) {
        List<char[]> nextChars = new ArrayList<>();
        for (char[] caseChar : caseChars) {
            int i = caseChar.length - 2;
            // casChar[i] < caseChar[i + 1] 찾기
            //뒤에서부터 처음 감소하는 지점 찾기.
            while (i >= 0 && caseChar[i] >= caseChar[i + 1]) {
                i --;
            }
            if (i == -1) {
                nextChars.add(caseChar);
                continue;
            }

            int j = caseChar.length - 1;
            while (j >= 0 && caseChar[i] >= caseChar[j]) {
                j--;
            }

            swap(caseChar, i, j);
            reverse(caseChar, i + 1);
        }
    }

    private static void reverse(char[] caseChar, int start) {
        int end = caseChar.length - 1;
        while (start < end) {
            char temp = caseChar[start];
            caseChar[start] = caseChar[end];
            caseChar[end] = temp;
            start++;
            end--;
        }
    }

    private static void swap(final char[] caseChar, final int i, final int j) {
        char temp = caseChar[i];
        caseChar[i] = caseChar[j];
        caseChar[j] = temp;
    }
}
