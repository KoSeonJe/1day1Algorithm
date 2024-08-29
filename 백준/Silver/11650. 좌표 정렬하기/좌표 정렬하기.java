import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static class Location {
    int x;
    int y;

    public Location(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }
    public int getY() {
      return y;
    }
    public String toString() {
      return x + " " + y;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    List<Location> locations = inputLocation(br, n);
    sort(locations);
    StringBuilder sb = new StringBuilder();
    for(Location loc : locations) {
      sb.append(loc.toString()).append("\n");
    }
    bw.write(sb.toString());
    br.close();
    bw.close();
  }

  private static void sort(List<Location> locations) {
    Collections.sort(locations, new Comparator<Location>() {

      @Override
      public int compare(Location o1, Location o2) {
        int compare = Integer.compare(o1.getX(), o2.getX());
        if (compare != 0) {
          return compare;
        }

        return Integer.compare(o1.getY(), o2.getY());
      }
    });
  }

  private static List<Location> inputLocation(BufferedReader br, int n) throws IOException {
    List<Location> locations = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      locations.add(new Location(x, y));
    }
    return locations;
  }
}
