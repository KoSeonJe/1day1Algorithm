import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<Integer, Integer> MONTH_VALUE = new HashMap<>();
    private static final Map<Integer, String> DAY_OF_WEEK = new HashMap<>();

    static {
        MONTH_VALUE.put(1, 31);
        MONTH_VALUE.put(2, 28);
        MONTH_VALUE.put(3, 31);
        MONTH_VALUE.put(4, 30);
        MONTH_VALUE.put(5, 31);
        MONTH_VALUE.put(6, 30);
        MONTH_VALUE.put(7, 31);
        MONTH_VALUE.put(8, 31);
        MONTH_VALUE.put(9, 30);
        MONTH_VALUE.put(10, 31);
        MONTH_VALUE.put(11, 30);
        MONTH_VALUE.put(12, 31);

        DAY_OF_WEEK.put(0, "MON");
        DAY_OF_WEEK.put(1, "TUE");
        DAY_OF_WEEK.put(2, "WED");
        DAY_OF_WEEK.put(3, "THU");
        DAY_OF_WEEK.put(4, "FRI");
        DAY_OF_WEEK.put(5, "SAT");
        DAY_OF_WEEK.put(6, "SUN");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] date = br.readLine().split(" ");
        int month = Integer.parseInt(date[0]);
        int day = Integer.parseInt(date[1]);
        int temp = 0;
        for (int i = 1; i < month; i++) {
            temp += MONTH_VALUE.get(i);
        }
        temp += day;
        int dayOfWeek = temp % 7 - 1;
        if (dayOfWeek < 0) {
            dayOfWeek = 7 + dayOfWeek;
        }
        System.out.println(DAY_OF_WEEK.get(dayOfWeek));
        br.close();
    }
}
