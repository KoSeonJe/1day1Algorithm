import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {

    static class Card {
        String name;
        int num;

        public Card(final String name, final int num) {
            this.name = name;
            this.num = num;
        }

        @Override
        public boolean equals(final Object o) {
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final Card card = (Card) o;
            return num == card.num && Objects.equals(name, card.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, num);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String totalNames = br.readLine();

        Set<Card> cards = new HashSet<>();
        int count = 0;
        while (!totalNames.isEmpty()) {
            String rawCard = totalNames.substring(0, 3);
            Card card = new Card(rawCard.substring(0, 1), Integer.parseInt(rawCard.substring(1, 3)));
            cards.add(card);
            count++;
            totalNames = totalNames.substring(3);
        }

        if (cards.size() != count) {
            System.out.println("GRESKA");
            return;
        }

        int pCount = calculateCount(cards, "P");
        int kCount = calculateCount(cards, "K");
        int hCount = calculateCount(cards, "H");
        int tCount = calculateCount(cards, "T");

        System.out.println(pCount + " " + kCount + " " + hCount + " " + tCount);
        br.close();
    }

    private static int calculateCount(final Set<Card> cards, final String name) {
        int count = 0;
        for (Card card : cards) {
            if (Objects.equals(card.name, name)) {
                count++;
            }
        }
        return 13 - count;
    }
}
