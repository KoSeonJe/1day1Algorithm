import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
	
		String str = sc.next();
		String upstr =str.toUpperCase();
		
		int max =0;
		int count=1;
		
		char[] charr = new char[upstr.length()];
		String result="";
        for(int i=0; i<charr.length; i++) {
			charr[i] = upstr.charAt(i);
			
		}
		Arrays.sort(charr);
		if(charr.length>=2) {
			
		for(int i=0; i<charr.length-1; i++) {
			if(charr[i]==charr[i+1]) {
				count++;
			}else {
				count =1;
			}
			if(count>=max) {
				if(count>max) {
				max = count;
				result=String.valueOf(charr[i]); 
				}else {
					result ="?";
					
				}
			}
			
		}
		System.out.println(result);
		}else {
			System.out.println(charr[0]);
		}
		
		

		
		
		
		sc.close();
	}
	
}

