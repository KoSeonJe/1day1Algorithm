import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    static class Car {
        String number;
        int rank;
        List<Car> fronts;

        public Car(final String number, final int rank, final List<Car> fronts) {
            this.number = number;
            this.rank = rank;
            this.fronts = fronts;
        }

    }

    // 이전보다 순위가 높아진 경우
    // 이전과 순위는 같거나 낮지만 앞 차량이 뒤에 있는 경우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Car> daegn = new ArrayList<>();
        List<Car> fronts = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            Car car = new Car(br.readLine(), i, new ArrayList<>(fronts));
            daegn.add(car);
            fronts.add(car);
        }

        List<Car> younsik = new ArrayList<>();
        fronts = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            Car car = new Car(br.readLine(), i, new ArrayList<>(fronts));
            younsik.add(car);

            fronts.add(car);
        }

        int result = calculateUpRankCar(daegn, younsik);
        System.out.println(result);
        br.close();
    }

    private static int calculateUpRankCar(final List<Car> daegn, final List<Car> younsik) {
        int count = 0;
        for (Car daegnCar : daegn) {
            for (Car younsikCar : younsik) {
                if (Objects.equals(daegnCar.number, younsikCar.number)) {
                    if (daegnCar.rank > younsikCar.rank) {
                        count++;
                        break;
                    }

                    if (isNotOverLap(daegnCar.fronts, younsikCar.fronts)) {
//                        System.out.println(daegnCar.number);
//                        System.out.println(younsikCar.fronts.stream().map(front -> front.number).toList());
//                        System.out.println(daegnCar.fronts.stream().map(front -> front.number).toList());
                        count++;
                        break;
                    }
                }
            }
        }


        return count;
    }

    private static boolean isNotOverLap(final List<Car> daeFronts, final List<Car> youFronts) {
        for (Car daeFront : daeFronts) {
            boolean have = false;
            for (Car youFront : youFronts) {
                if (Objects.equals(daeFront.number, youFront.number)) {
                    have =true;
                    break;
                }
            }
            if (!have) {
                return true;
            }
        }
        return false;
    }
}
