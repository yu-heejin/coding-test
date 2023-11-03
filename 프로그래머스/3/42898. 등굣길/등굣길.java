class Solution {
    
    final int DIVIDE = 1000000007;
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        
        // 웅덩이 -1로 초기화
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }
        
        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                
                // 위쪽이 웅덩이가 아니라면
                if (dp[i - 1][j] > 0) {
                    dp[i][j] += dp[i - 1][j] % DIVIDE;
                }
                
                // 왼쪽이 웅덩이가 아니라면
                if (dp[i][j - 1] > 0) {
                    dp[i][j] += dp[i][j - 1] % DIVIDE;
                }
            }
        }
        
        return dp[n][m] % DIVIDE;
    }
}