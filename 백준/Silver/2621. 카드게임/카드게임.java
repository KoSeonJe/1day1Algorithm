import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static class Card {
        private String color;
        private int score;

        public Card(String color, int score) {
            this.color = color;
            this.score = score;
        }

        public String getColor() {
            return color;
        }

        public int getScore() {
            return score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Card> cards = inputCardData(br);
        int result = calculate(cards);
        bw.write(String.valueOf(result));
        br.close();
        bw.close();
    }

    private static int calculate(List<Card> cards) {
        if (allEqualsColorAndContinuous(cards)) {
            int max = getMax(cards);
            return 900 + max;
        }

        int num2 = fourNumberEquals(cards);
        if (num2 != -1) {
            return num2 + 800;
        }

        int[] num3 = threeEqualsAndTwoEqualsNumber(cards);
        if (num3 != null) {
            return num3[0] * 10 + 700 + num3[1];
        }

        if (allEqualsColor(cards)) {
            int max = getMax(cards);
            return 600 + max;
        }

        if (continuousNumber(cards)) {
            int max = getMax(cards);
            return 500 + max;
        }

        int num6 = threeEqualsNumber(cards);
        if (num6 != -1) {
            return 400 + num6;
        }

        int[] num7s = twoEqualsAndTwoEqualsNumber(cards);
        if (num7s != null) {
            int max = Math.max(num7s[0], num7s[1]);
            int min = Math.min(num7s[0], num7s[1]);
            return max * 10 + min + 300;
        }

        int num8 = twoEqualsNumber(cards);
        if (num8 != -1) {
            return 200 + num8;
        }

        int max = getMax(cards);
        return max + 100;
    }

    public static int getMax(List<Card> cards) {
        return cards.stream()
                .max(Comparator.comparingInt(Card::getScore))
                .map(Card::getScore)
                .orElse(0);
    }

    private static int twoEqualsNumber(List<Card> cards) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Card card : cards) {
            countMap.put(card.getScore(), countMap.getOrDefault(card.getScore(), 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    private static int[] twoEqualsAndTwoEqualsNumber(List<Card> cards) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Card card : cards) {
            countMap.put(card.getScore(), countMap.getOrDefault(card.getScore(), 0) + 1);
        }
        List<Integer> pairs = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 2) {
                pairs.add(entry.getKey());
            }
        }
        if (pairs.size() == 2) {
            return new int[]{pairs.get(0), pairs.get(1)};
        }
        return null;
    }

    private static int threeEqualsNumber(List<Card> cards) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Card card : cards) {
            countMap.put(card.getScore(), countMap.getOrDefault(card.getScore(), 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 3) {
                return entry.getKey();
            }
        }
        return -1;
    }

    private static boolean continuousNumber(List<Card> cards) {
         List<Integer> scores = cards.stream()
            .map(Card::getScore)
            .sorted()
            .collect(Collectors.toList());
        for (int i = 0; i < scores.size() - 1; i++) {
            if (scores.get(i + 1) - scores.get(i) != 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean allEqualsColor(List<Card> cards) {
        String color = cards.get(0).getColor();
        return cards.stream().allMatch(card -> card.getColor().equals(color));
    }

    private static int fourNumberEquals(List<Card> cards) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Card card : cards) {
            countMap.put(card.getScore(), countMap.getOrDefault(card.getScore(), 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 4) {
                return entry.getKey();
            }
        }
        return -1;
    }

    private static int[] threeEqualsAndTwoEqualsNumber(List<Card> cards) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Card card : cards) {
            countMap.put(card.getScore(), countMap.getOrDefault(card.getScore(), 0) + 1);
        }
        int three = -1, two = -1;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 3) three = entry.getKey();
            if (entry.getValue() == 2) two = entry.getKey();
        }
        if (three != -1 && two != -1) {
            return new int[]{three, two};
        }
        return null;
    }

    private static boolean allEqualsColorAndContinuous(List<Card> cards) {
        return allEqualsColor(cards) && continuousNumber(cards);
    }

    private static List<Card> inputCardData(BufferedReader br) throws IOException {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cards.add(new Card(st.nextToken(), Integer.parseInt(st.nextToken())));
        }
        return cards;
    }
}