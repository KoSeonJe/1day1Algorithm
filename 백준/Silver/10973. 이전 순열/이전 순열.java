import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        if (nextPermutaion(arr)){
            for (int value : arr) {
                System.out.print(value + " ");
            }
        } else {
            System.out.println(-1);
        }
    }
    public static boolean nextPermutaion(int[] arr) {
        int i = arr.length-1;
        while(i > 0 && arr[i] > arr[i-1]) {
            i--;
        }

        if(i == 0) //마지막 순열인 경우
            return false;

        int j = arr.length-1;
        while(arr[i-1] < arr[j]) {
            j--;
        }
        swap(arr, i-1, j);

        j = arr.length-1;
        while(i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }

        return true;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}