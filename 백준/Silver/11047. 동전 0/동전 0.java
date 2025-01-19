import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        List<Integer> coinValues = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            coinValues.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(coinValues, Collections.reverseOrder());

        int count = 0;

        for (int value : coinValues) {
            if (value > k) {
                continue;
            }

            if (k % value == 0) {
                count += k / value;
                break;
            }

            while (k >= 0) {
                k -= value;
                count++;
            }

            if (k < 0) {
                while (k < 0) {
                    k += value;
                    count--;
                }
            }
            
            if (k == 0) {
                break;
            }
        }

        System.out.println(count);
    }
}