import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        if (n == 1) {
            System.out.println(br.readLine());
        } else if (n == 2) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Integer.parseInt(br.readLine());
            }
            System.out.println(sum);
        } else {
            int[] drinks = new int[n];
        
            for (int i = 0; i < n; i++) {
                drinks[i] = Integer.parseInt(br.readLine());
            }
            
            int[] dp = new int[n];
            
            // 첫번째 잔
            dp[0] = drinks[0];
            // 두번쨰 잔
            dp[1] = drinks[0] + drinks[1];
            // 세번째 잔
            // 1, 2번째 / 1, 3번째 / 2, 3번째
            dp[2] = Math.max(drinks[0] + drinks[1], drinks[0] + drinks[2]);
            dp[2] = Math.max(dp[2], drinks[1] + drinks[2]);
            
            for (int i = 3; i < n; i++) {
                // 자기 자신을 먹는 경우 경우의 수 여러개
                // 1. 내 이전 와인을 먹고 한칸 띄고 먹는 경우
                // 2. 내 이전 와인을 건너 뛰고 이전까지 먹는 경우
                dp[i] = Math.max(dp[i - 2] + drinks[i], drinks[i - 1] + dp[i - 3] + drinks[i]);
                // 자기 자신을 먹지 않는 경우
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
            
            System.out.println(dp[n - 1]);
        }
    }
}