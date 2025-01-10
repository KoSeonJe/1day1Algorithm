import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
      
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int a3 = sc.nextInt();
        int a4 = sc.nextInt();
        int a5 = sc.nextInt();
        int a6 = sc.nextInt();

        System.out.println(1-a1);
        System.out.println(1-a2);
        System.out.println(2-a3);
        System.out.println(2-a4);
        System.out.println(2-a5);
        System.out.println(8-a6);

        sc.close();
    }
}