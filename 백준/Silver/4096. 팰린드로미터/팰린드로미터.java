import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();


        while(true){
            String num = br.readLine();

            if(num.equals("0"))
                break;

            if(isPalindrome(num)){ //팰린드롬이다
                sb.append(0).append("\n");
            }else{ //팰린드롬이 아니다
                sb.append(haveToAdd(num)).append("\n");
            }
        }

        bw.write(sb+" ");
        bw.close();

    }
    static boolean isPalindrome(String num){
        int start = 0;
        int end = num.length()-1;
        while(start < end){
            if(num.charAt(start) != num.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    static int haveToAdd(String num){
        int ret = 0; //더해야 할 값
        int length = num.length(); //자리수

        while(!isPalindrome(num)){
            //String을 int로 바꾼 후 +1
            //다시 int를 String으로 바꿔준다
            int next = Integer.parseInt(num) + 1;
            ret++;
            num = Integer.toString(next);

            //자리수 맞추기
            if(num.length() < length){
                String newNum = "";
                for(int i=0; i<length-num.length(); i++){
                    newNum += "0";
                }
                newNum += num;
                num = newNum;
            }
        }
        return ret;
    }
}