import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] wh = br.readLine().split(" ");
        int xSize = Integer.parseInt(wh[0]);
        int ySize = Integer.parseInt(wh[1]);

        String[] pq = br.readLine().split(" ");
        int p = Integer.parseInt(pq[0]);
        int q = Integer.parseInt(pq[1]);

        int hour = Integer.parseInt(br.readLine());

        int sumP = p + hour;
        int sumQ = q + hour;

        int changeCountX = sumP / xSize;
        int restCountX = sumP % xSize;

        int changeCountY = sumQ / ySize;
        int restCountY = sumQ % ySize;

        int resultX = 0;
        int resultY = 0;
        if (changeCountX % 2 == 0) {
            resultX = restCountX;
        } else {
            resultX = xSize - restCountX;
        }

        if (changeCountY % 2 == 0) {
            resultY = restCountY;
        } else {
            resultY = ySize - restCountY;
        }



        System.out.println(resultX + " " + resultY);
        br.close();
    }
}
