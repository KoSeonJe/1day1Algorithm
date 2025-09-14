import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int x;
    static int y;

    static class Location {

        int direction;
        int distance;

        public Location(final int direction, final int distance) {
            this.direction = direction;
            this.distance = distance;
        }

        public int calculateMinDistance(final Location location) {
            Point point = getPoint();
            Point otherPoint = location.getPoint();
            int diffX = Math.abs(point.x - otherPoint.x);
            int diffY = Math.abs(point.y - otherPoint.y);

            int plus = 0;
            if (
                    this.direction == 1 && location.direction == 2 ||
                            this.direction == 2 && location.direction == 1
            ) {
                int min1 = Math.min(point.x, otherPoint.x);
                int min2 = Math.min(x - point.x, x - otherPoint.x);
                plus = Math.min(min1, min2) * 2;
            } else if (
                    this.direction == 3 && location.direction == 4 ||
                            this.direction == 4 && location.direction == 3
            ) {
                int min1 = Math.min(point.y, otherPoint.y);
                int min2 = Math.min(y - point.y, y - otherPoint.y);
                plus =  Math.min(min1, min2) * 2;
            }
            return diffX + diffY + plus;
        }

        public Point getPoint() {
            switch (direction) {
                case 1 : {
                    return new Point(distance, y);
                }
                case 2 : {
                    return new Point(distance, 0);
                }
                case 3 : {
                    return new Point(0, y-distance);
                }
                case 4 : {
                    return new Point(x, y-distance);
                }
            }
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] xy = br.readLine().split(" ");
        x = Integer.parseInt(xy[0]);
        y = Integer.parseInt(xy[1]);
        int storeCount = Integer.parseInt(br.readLine());

        List<Location> locations = new ArrayList<>();
        for (int i = 0; i < storeCount; i++) {
            String[] dd = br.readLine().split(" ");
            locations.add(new Location(Integer.parseInt(dd[0]), Integer.parseInt(dd[1])));
        }
        String[] dongXY = br.readLine().split(" ");
        Location dong = new Location(Integer.parseInt(dongXY[0]), Integer.parseInt(dongXY[1]));

        int sum = 0;
        for (Location location : locations) {
            sum += dong.calculateMinDistance(location);
        }

        System.out.println(sum);
        br.close();
    }
}
