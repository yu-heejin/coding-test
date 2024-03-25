import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        
        int[][] things = new int[n + 1][2];      // {물건의 무게, 가치}
        
        for (int i = 1; i <= n; i++) {
            input = br.readLine().split(" ");
            
            things[i][0] = Integer.parseInt(input[0]);     // w
            things[i][1] = Integer.parseInt(input[1]);     // v
        }
        
        // dp[i][j] = 배낭의 최대 무게가 i이고 j번째 아이템까지 살펴봤을 때의 최대 가치
        int[][] dp = new int[k + 1][n + 1];      // {최대 무게, 아이템}
        
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if (things[j][0] > i) {
                    // 해당 물건을 담을 수 없는 경우 이전 무게의 가치
                    dp[i][j] = dp[i][j - 1];
                } else {
                    // 해당 물건을 담을 수 있는 경우
                    // 해당 물건을 넣은 경우의 가치와 해당 물건을 넣지 않았을 경우의 가치 비교
                    // 해당 물건을 넣은 경우 남은 무게
                    int before = i - things[j][0];
                    dp[i][j] = Math.max(dp[i][j - 1], dp[before][j - 1] + things[j][1]);
                }
            }
        }
        
        System.out.println(dp[k][n]);
    }
}