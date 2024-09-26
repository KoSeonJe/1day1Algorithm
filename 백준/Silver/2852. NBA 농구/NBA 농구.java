import static java.util.Comparator.comparing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Time{

        int num;
        int minute;
        int second;

        public void setNum(int num) {
            this.num = num;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }

        public void setSecond(int second) {
            this.second = second;
        }

        public int getNum() {
            return num;
        }

        public int getMinute() {
            return minute;
        }

        public int getSecond() {
            return second;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Time> times = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String[] time = st.nextToken().split(":");

            Time timeTemp = new Time();
            timeTemp.setNum(num);
            timeTemp.setMinute(Integer.parseInt(time[0]));
            timeTemp.setSecond(Integer.parseInt(time[1]));
            times.add(timeTemp);
            if (i == n - 1) {
                times.add(timeTemp);
            }
        }
        times.sort(comparing(Time::getMinute)
            .thenComparing(Time::getSecond));
        String oneTime = calculateOne(times);
        String twoTime = calculateTwo(times);

        bw.write(oneTime + "\n");
        bw.write(twoTime);
        br.close();
        bw.close();
    }

    private static String calculateTwo(List<Time> times) throws IOException {
        int[] teams = new int[3];

        int minute = 0;
        int second = 0;

        int resultMinute = 0;
        int resultSecond = 0;

        for (int i = 0; i < times.size(); i++) {
            Time time = times.get(i);
            int num = time.getNum();
            int newMinute = time.getMinute();
            int newSecond = time.getSecond();

            if (teams[1] < teams[2]) {

                if (i == times.size() -1) {
                    if (second == 0) {
                        resultMinute += 48 - newMinute;
                        resultSecond += 0;
                    } else{
                        resultMinute += 47 - newMinute;
                        resultSecond += 60 - newSecond;
                    }
                }

                if (newSecond >= second) {
                    resultMinute += newMinute - minute;
                    resultSecond += newSecond - second;
                } else{
                    resultMinute += newMinute - minute-1;
                    resultSecond += (newSecond+ 60) - second;
                }
            }
            teams[num] += 1;
            minute = newMinute;
            second = newSecond;
        }
        if (resultSecond / 60 >= 1) {
            int min = resultSecond / 60;
            resultSecond = resultSecond % 60;
            resultMinute += min;
        }
        String resultM = resultMinute/10 == 0 ? "0"+resultMinute : resultMinute+"";
        String resultS = resultSecond/10 == 0 ? "0"+resultSecond : resultSecond+"";
        return resultM + ":" + resultS;
    }

    private static String calculateOne(List<Time> times) throws IOException {
        int[] teams = new int[3];

        int minute = 0;
        int second = 0;

        int resultMinute = 0;
        int resultSecond = 0;

        for (int i = 0; i < times.size(); i++) {
            Time time = times.get(i);
            int num = time.getNum();
            int newMinute = time.getMinute();
            int newSecond = time.getSecond();

            if (teams[1] > teams[2]) {

                if (i == times.size() -1) {
                    if (second == 0) {
                        resultMinute += 48 - newMinute;
                        resultSecond += 0;
                    } else{
                        resultMinute += 47 - newMinute;
                        resultSecond += 60 - newSecond;
                    }

                    break;
                }

                if (newSecond >= second) {
                    resultMinute += newMinute - minute;
                    resultSecond += newSecond - second;
                } else{
                    resultMinute += newMinute - minute-1;
                    resultSecond += (newSecond+ 60) - second;
                }
            }
            teams[num] += 1;
            minute = newMinute;
            second = newSecond;
        }

        if (resultSecond / 60 >= 1) {
            int min = resultSecond / 60;
            resultSecond = resultSecond % 60;
            resultMinute += min;
        }

        String resultM = resultMinute/10 == 0 ? "0"+resultMinute : resultMinute+"";
        String resultS = resultSecond/10 == 0 ? "0"+resultSecond : resultSecond+"";
        return resultM + ":" + resultS;
    }
}
