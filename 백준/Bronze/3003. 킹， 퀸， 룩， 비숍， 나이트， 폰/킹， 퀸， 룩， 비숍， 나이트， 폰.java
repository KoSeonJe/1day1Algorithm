import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> chessCount = List.of(1, 1, 2, 2, 2, 8);
        List<Integer> input = inputChess(br);

        List<Integer> results = calculateDiff(chessCount, input);
        StringBuilder builder = new StringBuilder();
        for (int result : results) {
            builder.append(result).append(" ");
        }
        System.out.println(builder);
        
        br.close();
    }

    private static List<Integer> calculateDiff(List<Integer> chessCount, List<Integer> input) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < chessCount.size(); i++) {
            temp.add(chessCount.get(i) - input.get(i));
        }
        return temp;
    }

    private static List<Integer> inputChess(BufferedReader br) throws IOException {
        String[] integers = br.readLine().split(" ");
        List<Integer> temp = new ArrayList<>();
        for (String integer : integers) {
            temp.add(Integer.parseInt(integer));
        }
        return temp;
    }
}
