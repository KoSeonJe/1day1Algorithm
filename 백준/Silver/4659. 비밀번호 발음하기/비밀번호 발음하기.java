import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    List<String> passwords = inputPasswords(br);
    List<String> results = judgePasswords(passwords);
    StringBuilder sb = new StringBuilder();
    for (String result : results) {
      sb.append(result).append("\n");
    }
    bw.write(sb.toString());
    br.close();
    bw.close();
  }

  private static List<String> judgePasswords(List<String> passwords) {
    List<String> results = new ArrayList<>();
    for (String password : passwords) {
      if (containsVowel(password) && noThreeContinuous(password) && noTwoContinuousText(password)) {
        results.add(acceptBuilder(password));
        continue;
      }
      results.add(notAcceptBuilder(password));
    }
    return results;
  }

  private static boolean noTwoContinuousText(String password) {
    char[] texts = password.toCharArray();
    for (int i = 0; i < texts.length-1; i++) {
      if(texts[i] == texts[i+1] && texts[i] != 'e' && texts[i] != 'o'){
        return false;
      }
    }
    return true;
  }

  private static boolean noThreeContinuous(String password) {
    char[] texts = password.toCharArray();
    for (int i = 0; i < texts.length-2; i++) {
      if (isVowel(texts[i]) && isVowel(texts[i+1]) && isVowel(texts[i+2])) {
        return false;
      }
      if (isNotVowel(texts[i]) && isNotVowel(texts[i+1]) && isNotVowel(texts[i+2])) {
        return false;
      }
    }
    return true;
  }

  private static boolean isNotVowel(char text) {
    return text != 'a' && text != 'e' && text != 'i' && text != 'o' && text != 'u';
  }

  public static boolean isVowel(char text) {
    return text == 'a' || text == 'e' || text == 'i' || text == 'o' || text == 'u';
  }

  private static boolean containsVowel(String password) {
    if (password.contains("a") || password.contains("e") || password.contains("i") || password.contains("o") || password.contains("u")) {
      return true;
    }
    return false;
  }

  private static String acceptBuilder(String password) {
    return "<" + password + ">" + " is acceptable.";
  }

  private static String notAcceptBuilder(String password) {
    return "<" + password + ">" + " is not acceptable.";
  }

  private static List<String> inputPasswords(BufferedReader br) throws IOException {
    List<String> passwords = new ArrayList<>();
    boolean flag = true;
    while (flag) {
      String password = br.readLine();
      if (Objects.equals(password, "end")) {
        flag = false;
        break;
      }
      passwords.add(password);
    }
    return passwords;
  }
}
