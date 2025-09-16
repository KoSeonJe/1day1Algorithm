import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Group {
        String address;

        public Group(String address) {
            if (address.length() != 4) {
                int diff = 4 - address.length();
                for (int i = 0; i < diff; i++) {
                    address = "0" + address;
                }
            }

            this.address = address;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp = br.readLine();
        String[] rawGroups = temp.split(":");
        List<Group> groups = new ArrayList<>();
        for (String group : rawGroups) {
            groups.add(new Group(group));
        }

        if (groups.size() < 8 && temp.endsWith("::")) {
            int i = 8 - groups.size();
            for (int j = 0; j < i; j++) {
                groups.add(new Group("0000"));
            }
        }

        fillFull(groups);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < groups.size(); i++) {
            if (i == groups.size() - 1) {
                builder.append(groups.get(i).address);
                break;
            }
            builder.append(groups.get(i).address).append(":");
        }
        System.out.println(builder);
        br.close();
    }

    private static void fillFull(final List<Group> groups) {
        if (groups.size() == 8) {
            return;
        }

        if (groups.size() > 8) {
            int diff = groups.size() - 8;
            int count = 0;
            for (int i = 0; i < groups.size(); i++) {
                if (groups.get(i).address.equals("0000")) {
                    groups.remove(i);
                    count++;

                    if (diff == count) {
                        break;
                    }
                }
            }

            return;
        }

        int index = 0;
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).address.equals("0000")) {
                index = i;
            }
        }

        int diff = 8 - groups.size();
        for (int i = 0; i < diff; i++) {
            groups.add(index, new Group("0000"));
        }

    }
}
