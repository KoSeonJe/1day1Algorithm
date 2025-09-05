import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    // 1 1/1
    // 2 2/1
    // 3 1/2
    // 4 3/1
    // 5 2/2
    // 6 1/3
    // 1 + 2 + 3 + 4 + 5 + 6
    // 짝수면 왼, 홀수면 오른쪽
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int count = 0;
        int i = 1;
        int deno = 0;
        int numer = 0;
        while(count < x) {
            count = count + i;
            i++;
        }

        if((i-1)%2 == 0) {
            deno = 1 + (count - x);
            numer = (i-1) - (count-x);
        }else {
            deno = (i-1) - (count-x);
            numer = 1 + (count - x);
        }


        System.out.println(numer  + "/" + deno);
    }
}
