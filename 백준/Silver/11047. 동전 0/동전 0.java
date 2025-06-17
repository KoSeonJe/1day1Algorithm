import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int count =0;
	static int rest =0;
	static int n=0;
	static int coin =0;
	static int[] coinvalue;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		made();
		System.out.println(rest);
		
	}
	
	public static void made() {
	     n = scanner.nextInt();
		coin = scanner.nextInt();
		coinvalue = new int[n];
		for(int i=coinvalue.length-1; i>=0; i--) {
			coinvalue[i] = scanner.nextInt();
		}
		madehighcoin();
		
	}
	public static void madehighcoin() {
		int container=0;
		
		for(int highcoin : coinvalue) {
			if(coin-highcoin >= 0) {
				container=highcoin;
				break;
			}
		}
		coinrest(container);
	}

	public static void coinrest(int highcoin) {

		
		
		rest = rest+coin/highcoin;
		coin = coin%highcoin;
		if(coin!=0) {
			madehighcoin();
		}
		
		
		
	}
	
} 
