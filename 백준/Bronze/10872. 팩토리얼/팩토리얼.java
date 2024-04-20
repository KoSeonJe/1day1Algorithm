import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		System.out.println(factorial(n));
		
		sc.close();
	}
	public static int factorial(int n) {
		if(n==1 |n==0) {
			return 1;
		}
		return n*factorial(n-1);
	}

}
