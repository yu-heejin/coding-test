import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[][] tp = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            tp[i] = new int[] { Integer.parseInt(input[0]), Integer.parseInt(input[1]) };
        }
        
        int max = -1;
        
        for (int i = 0; i < n; i++) {
            // 현재 위치에서 상담을 시작할 때 기간을 초과하지 않는다면
            if (i + tp[i][0] <= n) {
                // 상담이 마무리 된 후의 날짜에서 이득을 구한다.
                // 현재 이득 vs 향후 이득
                dp[i + tp[i][0]] = Math.max(dp[i + tp[i][0]], dp[i] + tp[i][1]);
            }
            
            // 상담이 진행되는 동안에도 이득을 넣어주어야한다.
            // 현재 이득 vs 이전 날짜에서 시작했을 때의 이득
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        
        System.out.println(dp[n]);
    }
}