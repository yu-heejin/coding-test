import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] numbers = new int[n];
        
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        
        // 구간합(카데인 알고리즘)
        int[] dp = new int[n];   // n을 끝으로 가지는 구간합 중에서 가장 큰 값
        dp[0] = numbers[0];
        int max = dp[0];
        for (int end = 1; end < n; end++) {
            dp[end] = Math.max(dp[end - 1] + numbers[end], numbers[end]);
            max = Math.max(max, dp[end]);
        }
        
        System.out.println(max);
    }
}