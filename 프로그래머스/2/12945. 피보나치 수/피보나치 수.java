class Solution {
    public int solution(int n) {
        int[] dp = new int[n + 1];
        
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 오버플로우 때문에 미리 나눈 후 계산하는 것이 좋다.
            dp[i] = (dp[i - 1] % 1234567) + (dp[i - 2] % 1234567);
        }
        
        return dp[n] % 1234567;
    }
}