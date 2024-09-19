import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), "*");
    String front = st.nextToken();
    String back = st.nextToken();

    List<String> strs = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String word = br.readLine();

      if(word.length() < front.length() || word.length() < back.length()){
        strs.add("NE");
        continue;
      }

      if(front.length() + back.length() > word.length()){
        strs.add("NE");
        continue;
      }

      String wordFront = word.substring(0, front.length());
      String wordBack = word.substring(word.length() - back.length());
      if (front.equals(wordFront) && back.equals(wordBack)) {
        strs.add("DA");
      } else {
        strs.add("NE");
      }
    }

    for (String str : strs) {
      bw.write(str + "\n");
    }
    br.close();
    bw.close();
  }
}
