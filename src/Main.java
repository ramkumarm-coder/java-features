import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        sieveOfErotosthemes(53);
    }

    public static void sieveOfErotosthemes(int k) {
        boolean[] arr = new boolean[k + 1];
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;


        for (int p = 2; p * p <= k; p++) {
            for (int i = p * p; i <= k; i += p) {
                arr[i] = false;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]) list.add(i);
//            System.out.print(arr[i] ? i + " " : "");
        }

        System.out.println(list);

    }

    public static void sieve(int k) {

        boolean[] arr = new boolean[k + 1];
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;

        for (int p = 2; p * p <= k; p++) {
            if (arr[p]) {
                for (int i = p * p; i <= k; i += p) {
                    arr[i] = false;
                }
            }
        }

        for (int i = 0; i < k; i++) {
            if (arr[i]) {
                System.out.print(i + " ");
            }
        }

    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;        // 0 and 1 are not prime
        if (n == 2 || n == 3) return true; // 2 and 3 are prime
        if (n % 2 == 0 || n % 3 == 0) return false; // eliminate multiples of 2 and 3

        // Check from 5 to √n with a step of 6
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

}
