import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String N = br.readLine();
        for (int i=0; i<N.length(); i++) {
            int c = N.charAt(i) - '0';
            
            if (c >= 4) { // 숫자가 4보다 클 경우
                sb.append(1); // 1XX
                c -= 4;
            } else { // 그게 아니라면
                sb.append(0); // 0XX
            }
            if (c >= 2) { // 다음 숫자가 2보다 클 경우
                sb.append(1); // X1X
                c -= 2;
            } else { // 그게 아니라면
                sb.append(0); // X0X
            }
            if (c >= 1) { // 숫자가 1보다 클 경우
                sb.append(1); // XX1
            } else { // 그게 아니라면
                sb.append(0); // XX0
            }
        }
        
        // 0으로 시작하는지 판단해서 0을 제거
        if (sb.charAt(0) == '0') {
            if (sb.charAt(1) == '0')
                System.out.print(sb.substring(2, sb.length()));
            else
                System.out.print(sb.substring(1, sb.length()));
        } else {
            System.out.print(sb);
        }
        
        br.close();
    }
}