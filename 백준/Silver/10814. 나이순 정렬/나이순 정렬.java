import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

  static class Member {
    private int age;
    private String name;

    public Member(int age, String name) {
      this.age = age;
      this.name = name;
    }
    public int getAge() {
      return age;
    }
    public String getName() {
      return name;
    }
    public String toString() {
      return age + " " + name;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    List<Member> members = inputMember(n, br);
    List<Member> sortedMembers = sort(members);
    StringBuilder sb = new StringBuilder();
    for (Member member : sortedMembers) {
      sb.append(member.toString() + "\n");
    }
    bw.write(sb.toString());
    br.close();
    bw.close();
  }

  private static List<Member> sort(List<Member> members) {
    Collections.sort(members, new Comparator() {
      public int compare(Object o1, Object o2) {
        if (((Member) o1).getAge() > ((Member) o2).getAge()) {
          return 1;
        }
        if (((Member) o1).getAge() < ((Member) o2).getAge()) {
          return -1;
        }
          return 0;
      }
    });
    return members;
  }

  private static List<Member> inputMember(int n, BufferedReader br) throws IOException {
    List<Member> members = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int age = Integer.parseInt(st.nextToken());
      String name = st.nextToken();
      members.add(new Member(age, name));
    }
    return members;
  }


}
