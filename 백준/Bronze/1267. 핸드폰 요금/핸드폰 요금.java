import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] time = br.readLine().split(" ");

        int y = 0;
        int m = 0;
        for (int i = 0; i < n; i++) {
            int timePart = Integer.parseInt(time[i]);
            int yValue = (timePart / 30) + 1;
            y += yValue;

            int mValue = (timePart / 60) + 1;
            m += mValue;
        }

        int totalY = y * 10;
        int totalM = m * 15;

        if (totalY == totalM) {
            System.out.println("Y M " + totalY);
        } else if (totalY < totalM){
            System.out.println("Y " + totalY);
        }  else{
            System.out.println("M " + totalM);
        }
        br.close();
    }
}
