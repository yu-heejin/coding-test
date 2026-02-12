import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 첫번째 자리는 2, 3, 5, 7만 올 수 있음(소수)
        int[] firstNumber = new int[] {2, 3, 5, 7};

        for (int i = 0; i < 4; i++) {
            dfs(firstNumber[i], n - 1);
        }
    }

    public static void dfs(int number, int depth) {
        if (depth == 0) {
            System.out.println(number);
            return;
        }

        // 짝수는 2를 제외하고 소수가 될 수 없다.
        for (int i = 1; i < 10; i += 2) {
            int tempNumber = number * 10 + i;
            if (isPrime(tempNumber)) {
                dfs(tempNumber, depth - 1);
            }
        }
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}