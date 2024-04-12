import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String l = sc.next();
        int count = 0;
        int temp = 0;
        while (count < n) {
            temp = temp+1;
            String sTemp = String.valueOf(temp);
            if(!sTemp.contains(l)){
                count++;
            }
        }
        System.out.println(temp);
        sc.close();
    }
}
