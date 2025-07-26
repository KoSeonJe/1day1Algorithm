import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    static int[] vertical = {1, 2, 3, 4, 5, 6};
    static int[] horizontal = {65, 66, 67, 68, 69, 70};
    static List<Location> visited = new ArrayList<>();

    static List<Location> possibleMove = List.of(
            new Location(1, 2),
            new Location(-1, 2),
            new Location(2, 1),
            new Location(2, -1),
            new Location(1, -2),
            new Location(-1, -2),
            new Location(-2, 1),
            new Location(-2, -1)
    );


    static class Location {
        int horizontal;
        int vertical;

        public Location(final int horizontal, final int vertical) {
            this.horizontal = horizontal;
            this.vertical = vertical;
        }

        public Location diff(Location location) {
            return new Location(this.horizontal - location.horizontal, this.vertical - location.vertical);
        }

        @Override
        public boolean equals(final Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final Location location = (Location) o;
            return horizontal == location.horizontal && vertical == location.vertical;
        }

        @Override
        public int hashCode() {
            return Objects.hash(horizontal, vertical);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Location> locations = new ArrayList<>();
        for (int i = 0; i < 36; i++) {
            String location = br.readLine();
            locations.add(new Location(location.charAt(0), Integer.parseInt(String.valueOf(location.charAt(1)))));
        }
        for (int i = 0; i < locations.size(); i++) {
            visited.add(locations.get(i));
            if (i == locations.size() - 1) {
                break;
            }

            if (visited.contains(locations.get(i + 1))) {
                System.out.println("Invalid");
                return;
            }

            if (!canMoveKnight(locations.get(i), locations.get(i + 1))) {
                System.out.println("Invalid");
                return;
            }
        }

        if (!canMoveKnight(locations.get(locations.size() - 1), locations.get(0))) {
            System.out.println("Invalid");
            return;
        }
        System.out.println("Valid");
        br.close();
    }

    public static boolean canMoveKnight(Location before, Location after) {
        Location diff = after.diff(before);

        for (Location possible : possibleMove) {
            if (!validAfter(after)) {
                return false;
            }

            if (possible.equals(diff)) {
                return true;
            }
        }

        return false;
    }

    private static boolean validAfter(final Location after) {
        boolean containHorizontal = false;
        boolean containVertical = false;
        for (int horizontalPart : horizontal) {
            if (horizontalPart == after.horizontal) {
                containHorizontal = true;
                break;
            }
        }

        if (!containHorizontal) {
            return false;
        }

        for (int verticalPart : vertical) {
            if (verticalPart == after.vertical) {
                containVertical = true;
                break;
            }
        }

        return containVertical;
    }
}
