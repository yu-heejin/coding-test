import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int left = 0;
        int right = n - 1;
        int answer = 0;

        // 정렬
        Arrays.sort(numbers);
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == m) {
                answer++;
                left++;
            } else if (sum < m) {
                left++;
            } else if (sum > m) {
                right--;
            }
        }

        System.out.println(answer);
    }
}