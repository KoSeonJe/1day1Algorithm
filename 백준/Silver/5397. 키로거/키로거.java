import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    List<String> passwords = getPassword(n, br);
    StringBuilder sb = new StringBuilder();
    for(String password : passwords) {
      sb.append(password).append("\n");
    }
    bw.write(sb.toString());
    br.close();
    bw.close();
  }

  private static List<String> getPassword(int n, BufferedReader br) throws IOException {
    List<String> passwords = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String temp = br.readLine();
      if (!(temp.contains("<") || temp.contains(">") || temp.contains("-"))) {
        passwords.add(temp);
        continue;
      }
      LinkedList<Character> stack = new LinkedList<>();
      int point = 0;
      for (int j = 0; j < temp.length(); j++) {
        if (temp.charAt(j) == '<') {
          if (point > 0) {
            point--;
          }
          continue;
        }

        if(temp.charAt(j) == '>') {
          if (point < stack.size()) {
            point++;
          }
          continue;
        }

        if (temp.charAt(j) == '-') {
          if (point > 0) {
            stack.remove(point - 1);
            point--;
          }
          continue;
        }
        stack.add(point, temp.charAt(j));
        point++;
      }
      StringBuilder sb = new StringBuilder();
      for(char c : stack) {
        sb.append(c);
      }
      passwords.add(sb.toString());
    }
    return passwords;
  }
}
