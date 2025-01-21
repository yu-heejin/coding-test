import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int number = 666;
        int i = 0;
        int[] numbers = new int[n];

        while (i < n) {
            if (Integer.toString(number).contains("666")) {
                numbers[i] = number;
                i++;
            }

            number++;
        }

        System.out.println(numbers[n-1]);
    }
}