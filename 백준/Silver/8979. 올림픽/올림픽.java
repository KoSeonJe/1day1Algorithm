import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static class Country {

    private int id;
    private int gold;
    private int silver;
    private int bronze;

    public Country(int id, int gold, int silver, int bronze) {
      this.id = id;
      this.gold = gold;
      this.silver = silver;
      this.bronze = bronze;
    }

    public int getId() {
      return id;
    }

    public int getGold() {
      return gold;
    }

    public int getSilver() {
      return silver;
    }

    public int getBronze() {
      return bronze;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Country country = (Country) o;
      return gold == country.gold && silver == country.silver && bronze == country.bronze;
    }

    @Override
    public int hashCode() {
      return Objects.hash(gold, silver, bronze);
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int count = Integer.parseInt(st.nextToken());
    int target = Integer.parseInt(st.nextToken());
    PriorityQueue<Country> countries = inputData(count, br);
    int rank = 0;
    int sameRank = 0;
    int result = 1;
    int size = countries.size();
    Country last = new Country(0, 0, 0, 0);
    for (int i = 0; i <size; i++) {
      Country country = countries.poll();
      if (country.equals(last)) {
        rank++;
        result = sameRank;
      } else {
        rank++;
        sameRank = rank;
        result = rank;
      }
      if (country.getId() == target) {
        break;
      }
      last = country;
    }

    bw.write(String.valueOf(result));
    br.close();
    bw.close();
  }

  private static PriorityQueue<Country> inputData(int count, BufferedReader br) throws IOException {
    PriorityQueue<Country> countries = new PriorityQueue<>(new Comparator<Country>() {
      @Override
      public int compare(Country o1, Country o2) {
        if (o1.getGold() != o2.getGold()) {
          return o2.getGold() - o1.getGold();
        }
        if (o1.getSilver() != o2.getSilver()) {
          return o2.getSilver() - o1.getSilver();
        }
        return o2.getBronze() - o1.getBronze();
      }
    });

    for (int i = 0; i < count; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int id = Integer.parseInt(st.nextToken());
      int gold = Integer.parseInt(st.nextToken());
      int silver = Integer.parseInt(st.nextToken());
      int bronze = Integer.parseInt(st.nextToken());
      countries.add(new Country(id, gold, silver, bronze));
    }
    return countries;
  }
}
