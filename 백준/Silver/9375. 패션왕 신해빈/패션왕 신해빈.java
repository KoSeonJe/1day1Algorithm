import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. n! * 중복 개수
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();

                if (map.get(type) == null) {
                    map.put(type, 1);
                } else {
                    map.put(type, map.get(type) + 1);
                }
            }

            Set<String> set = map.keySet();
            int sum = 1;
            for (String node : set) {
                sum = sum * (map.get(node)+1);
            }
            int result = sum - 1;
            sb.append(result).append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
