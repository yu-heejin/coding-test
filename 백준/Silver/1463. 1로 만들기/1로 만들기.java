import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        
        dp[1] = 0;
        // 초기값을 기반으로 작은 문제에서 큰 문제를 해결
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;    // 기본적으로 1을 빼준다.
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
        
        System.out.println(dp[n]);
    }
}