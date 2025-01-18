import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static String[][] keyboard = {
        {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"},
        {"a", "s", "d", "f", "g", "h", "j", "k", "l"},
        {"z", "x", "c", "v", "b", "n", "m"}
    };

    static String[][] child = {
        {"q", "w", "e", "r", "t"},
        {"a", "s", "d", "f", "g"},
        {"z", "x", "c", "v"}
    };
    static String[][] parent = {
        {" ", "y", "u", "i", "o", "p"},
        {" ", "h", "j", "k", "l"},
        {"b", "n", "m"}
    };

    static class Point {

        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDistance(Point newPoint) {
            return Math.abs(x - newPoint.getX()) + Math.abs(y - newPoint.getY());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        String left = st.nextToken();
        String right = st.nextToken();

        String target = reader.readLine();
        int time = calculateTime(target, left, right);
        writer.write(String.valueOf(time));
        reader.close();
        writer.close();
    }

    private static int calculateTime(String target, String left, String right) {
        int time = target.length();
        String leftLocation = left;
        String rightLocation = right;

        String[] chars = target.split("");
        for (int i = 0; i < chars.length; i++) {
            if (isChild(chars[i])) {
                Point leftPoint = getPoint(leftLocation);
                Point newPoint = getPoint(chars[i]);

                time += leftPoint.getDistance(newPoint);
                leftLocation = chars[i];
                continue;
            }

            Point rightPoint = getPoint(rightLocation);
            Point newPoint = getPoint(chars[i]);
            time += rightPoint.getDistance(newPoint);
            rightLocation = chars[i];
        }
        return time;
    }

    private static Point getPoint(String letter) {
        for (int i = 0; i < keyboard.length; i++) {
            for (int j = 0; j < keyboard[i].length; j++) {
                if (keyboard[i][j].equals(letter)) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    private static boolean isChild(String letter) {
        for (int i = 0; i < child.length; i++) {
            for (int j = 0; j < child[i].length; j++) {
                if (child[i][j].equals(letter)) {
                    return true;
                }
            }
        }
        return false;
    }
}
