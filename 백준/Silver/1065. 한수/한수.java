import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x= sc.nextInt();
		int result = checked(x);
		System.out.println(result);
		
		sc.close();
		
	}
	
	
	public static int checked(int n) {
		int total=100;

		int count =0;

		
		if(n>=100) {
			while(n>=total) {
				String value=String.valueOf(total);
				char[] score = new char[value.length()];
				int[] arr = new int[value.length()];
				
			for(int i=0; i<value.length(); i++) {
				score[i] =value.charAt(i);
				arr[i] =(int)score[i]-48;
			}
			
			if(total<1000) {
			for(int i=0; i<arr.length-2; i++) {
			if(arr[i+2]-arr[i+1] == arr[i+1]-arr[i]) {
				count++;
			}
			}
			
			}else if(total<10000) {
				for(int i=0; i<arr.length-3; i++) {
					if(arr[i+2]-arr[i+1] == arr[i+1]-arr[i] &arr[i+2]-arr[i+1]== arr[i+3]-arr[i+2]){
						count++;
					}
					}
			}
			
			total++;
			}
			
			count = count+99;
		}else if(n<100|n>0) {
			for(int i=0; i<n; i++) {
				count++;
			}
		}
		
		return count;
	}
	
}
