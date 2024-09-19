import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		for(int i=0; i< N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start=0, end=0, cnt=0, sum=0;
		while(start< N) {
			if(sum > M || end == N) sum -= arr[start++];
			else sum += arr[end++];
			
			if(sum == M) cnt++;
		}
		
		System.out.println(cnt);
	}
}