import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		//지나간 시간을 저장 할 변수
		int time = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			String Z = st.nextToken();
			
			time += T;
			
			if(time > 210) break;
			
			if(Z.equals("T")) K++;
			
			if(K == 9) K = 1;
		}
		System.out.println(K);
	}

}