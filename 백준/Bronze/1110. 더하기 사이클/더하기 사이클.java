
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int input = sc.nextInt();
    

    int sum=0;
    int result=1;
    int nresult=0;
    int a3;
    int a4;
    String str1 = String.format("%02d", input);
    int a1 = (int)str1.charAt(0)-48;
    int a2 = (int)str1.charAt(1)-48;
    sum= a1+a2;
    
    String str2 =String.format("%02d", sum);
    a3 = (int)str2.charAt(0)-48;
    a4 = (int)str2.charAt(1)-48;

    String s = String.valueOf(a2);
    String s2 = String.valueOf(a4);
    String sresult = s+s2;
    nresult = Integer.parseInt(sresult);
    
    while(input!=nresult) {
        str1 = String.format("%02d", nresult);
        a1 = (int)str1.charAt(0)-48;
        a2 = (int)str1.charAt(1)-48;
        sum= a1+a2;
        
     str2 =String.format("%02d", sum);
    a3 = (int)str2.charAt(0)-48;
    a4 = (int)str2.charAt(1)-48;
    
    s = String.valueOf(a2);
    s2 = String.valueOf(a4);
   sresult = s+s2;
    nresult = Integer.parseInt(sresult);
    
    
    
    
    
    result++;
    }
    System.out.println(result);
        sc.close();
	}

}