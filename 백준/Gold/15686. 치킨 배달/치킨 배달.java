import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Location> houses = new ArrayList<>();
    static List<Location> chickens = new ArrayList<>();
    static List<Location> selected = new ArrayList<>();
    static boolean[] visited;
    static int m;
    static int minSumDiff = Integer.MAX_VALUE;

    static class Location {

        int x;
        int y;

        public Location(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        public int distance(Location location) {
            return Math.abs(x - location.x) + Math.abs(y - location.y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 치킨집 개수와 M이 같을 때, 그냥 반환
        // M이 더 크다면 그 차이만큼 제거하고 완전탐색
        // = 최소 수

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        fillData(n, br);
        visited = new boolean[chickens.size()];
        if (chickens.size() == m) {
            System.out.println(calculateMin(chickens));
        } else {
            calculateMinDiff(0, 0);
            System.out.println(minSumDiff);
        }
        br.close();
    }

    private static void calculateMinDiff(int index, final int start) {
        if (index == m) {
            int minDiff = calculateMin(selected);
            if (minSumDiff > minDiff) {
                minSumDiff = minDiff;
            }
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            selected.add(chickens.get(i));
            calculateMinDiff(index + 1, i + 1);
            selected.remove(selected.size() - 1);
            visited[i] = false;
        }
    }

    private static int calculateMin(List<Location> chickens) {
        int sum = 0;
        for (Location house : houses) {
            int min = Integer.MAX_VALUE;
            for (Location chicken : chickens) {
                int distance = house.distance(chicken);
                if (min > distance) {
                    min = distance;
                }
            }
            sum += min;
        }
        return sum;
    }

    private static void fillData(final int n, final BufferedReader br) throws IOException {
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(row[j]);
                if (value == 1) {
                    houses.add(new Location(i, j));
                    continue;
                }
                if (value == 2) {
                    chickens.add(new Location(i, j));
                }
            }
        }
    }
}
