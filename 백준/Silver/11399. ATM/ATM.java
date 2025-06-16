import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(input[i]);
        }

        // 가장 적은 시간 순서대로 정렬
        Arrays.sort(times);

        int result = 0;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            sum += times[i];
            result += sum;
        }

        System.out.println(result);
    }
}