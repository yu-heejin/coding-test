class Solution {
    
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = land[i][j];
            }
        }
        
        for (int i = 1; i < land.length; i++) {  // 현재 행이자 dp의 현재 행
            for (int j = 0; j < 4; j++) {  // dp의 현재 열
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j != k && dp[i-1][k] + dp[i][j] > max) {
                        max = dp[i-1][k] + dp[i][j];
                    }
                }
                
                dp[i][j] = max;
            }
        }
        
        int max = 0;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        
        return max;
    }
}