import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//1 4 1 1 4 3 3 3 2 2
//3 2 3 3
//4 4 1 1 1 2 3 3 2 3
public class Main {
    static int length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        length = Integer.parseInt(br.readLine());
        int[] diagram = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < length; i++) {
            diagram[i] = Integer.parseInt(st.nextToken());
        }
        int[] reverseDiagram = createReverseDiagram(diagram);
        int targetCount = Integer.parseInt(br.readLine());
        int equalsCount = 0;
        List<int[]> equalTargets = new ArrayList<>();
        for (int i = 0; i < targetCount; i++) {
            int[] target = new int[length];
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < length; j++) {
                target[j] = Integer.parseInt(tokenizer.nextToken());
            }
            if (equalsDiagram(diagram, target)) {
                equalsCount++;
                equalTargets.add(target);
            }

            if (equalsDiagram(reverseDiagram, target)) {
                equalsCount++;
                equalTargets.add(target);
            }
        }
        System.out.println(equalsCount);
        StringBuilder builder = new StringBuilder();
        for (int[] equalTarget : equalTargets) {
            for (int part : equalTarget) {
                builder.append(part).append(" ");
            }
            builder.append("\n");
        }
        System.out.println(builder);
        br.close();
    }

    private static int[] createReverseDiagram(final int[] diagram) {
        int[] reverse = new int[length];
        for (int i = 0; i < length; i++) {
           switch (diagram[i]) {
               case 1 : {
                   reverse[i] = 3;
                   break;
               }
               case 2 : {
                   reverse[i] = 4;
                   break;
               }
               case 3 : {
                   reverse[i] = 1;
                   break;
               }
               case 4 : {
                   reverse[i] = 2;
                   break;
               }
           }
        }
        int start = 0;
        int end = reverse.length - 1;
        while (start < end) {
            int temp = reverse[start];
            reverse[start] = reverse[end];
            reverse[end] = temp;
            start++;
            end--;
        }
        return reverse;
    }

    private static boolean equalsDiagram(final int[] diagram, final int[] target) {
        int start = diagram[0];

        for (int i = 0; i < length; i++) {
            if (target[i] != start) {
                continue;
            }
            for (int j = 0; j < length; j++) {
                int index = (j + i) % (target.length);
                if (diagram[j] != target[index]) {
                    break;
                }
                if (j == target.length - 1 && diagram[j] == target[index]) {
                    return true;
                }
            }
        }
        return false;
    }
}
