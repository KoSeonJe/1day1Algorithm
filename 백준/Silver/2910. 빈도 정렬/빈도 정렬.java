import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        List<Integer> datas = inputData(n, br);
        StringBuilder builder = sortAndBuild(datas);
        bw.write(builder.toString());
        br.close();
        bw.close();
    }

    private static StringBuilder sortAndBuild(List<Integer> datas) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new LinkedHashSet<>(datas);
        for (int node : set) {
            int count = 0;
            for (int data : datas) {
                if (data == node) {
                    count++;
                }
            }
            map.put(node, count);
        }
        List<Integer> origin = new ArrayList<>(set);
        Collections.sort(datas, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.get(o1) < map.get(o2)) {
                    return 1;
                }
                if (map.get(o1) > map.get(o2)) {
                    return -1;
                }

                return origin.indexOf(o1) - origin.indexOf(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int data : datas) {
            sb.append(data).append(" ");
        }
        return sb;
    }

    private static List<Integer> inputData(int n, BufferedReader br) throws IOException {
        List<Integer> datas = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            datas.add(Integer.parseInt(st.nextToken()));
        }
        return datas;
    }
}
