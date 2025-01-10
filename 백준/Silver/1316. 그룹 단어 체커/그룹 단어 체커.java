import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)  {
		int n = sc.nextInt();
		int count =0;
		for(int i=0; i<n; i++) {
			boolean result =check();
			if(result) {
				count++;
			}
		}
		System.out.println(count);
		
	}
	
	public static boolean check() {
		boolean[] check = new boolean[26];
		String word = sc.next();
		int prev =0;
		
		for(int i=0; i<word.length(); i++) {
			int now = word.charAt(i);
			if(prev != now) {
				
				if(check[now-'a'] == false) {
					prev = now;
					check[now-'a']= true;
				}else {
					return false;
				}
			}else {
				continue;
			}
		}
		return true;
		
		
	}
}