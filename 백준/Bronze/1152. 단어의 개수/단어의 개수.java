import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		String  sentence = sc.nextLine();
		StringTokenizer st = new StringTokenizer(sentence);
		
		int result =st.countTokens();

		System.out.println(result);
		sc.close();
	}
	
}