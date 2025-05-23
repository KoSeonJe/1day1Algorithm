import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int l;

    static class Person {
        private int number;
        private int receiveCount;

        public Person(int number, int receiveCount) {
            this.number = number;
            this.receiveCount = receiveCount;
        }

        public int throwBall() {
            if (receiveCount % 2 == 0) {
                return -l;
            }
            return l;
        }


        public int receive() {
            receiveCount++;
            return receiveCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nml = br.readLine().split(" ");
        int n = Integer.parseInt(nml[0]);
        int m = Integer.parseInt(nml[1]);
        l = Integer.parseInt(nml[2]);
        List<Person> persons = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            persons.add(new Person(i, 0));
        }

        int throwCount = 0;
        int currentlocation = 0;
        Person holder = persons.get(currentlocation);
        int receiveCount = holder.receive();
        while (receiveCount < m) {
            int move = holder.throwBall();
            currentlocation += move;
            if (currentlocation < 0) {
                currentlocation = n + currentlocation;
            }
            if (currentlocation >= n) {
                currentlocation = currentlocation - n;
            }
            holder = persons.get(currentlocation);
            receiveCount = holder.receive();
            throwCount++;
        }
        System.out.println(throwCount);
        br.close();
    }
}
