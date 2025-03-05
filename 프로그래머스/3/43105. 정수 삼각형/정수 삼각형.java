class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];
        
        // dp 배열 초기화
        for (int i = 1; i <= triangle.length; i++) {
            dp[i - 1] = new int[i];
        }
        
        dp[0][0] = triangle[0][0];
        
        for (int i = 0; i < triangle.length - 1; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                int left = i + 1;
                int right = j + 1;
                
                // 왼쪽으로 이동하는 경우
                dp[left][j] = Math.max(dp[left][j], dp[i][j] + triangle[left][j]);
                
                // 오른쪽으로 이동하는 경우
                if (right < triangle[i + 1].length) {
                    dp[left][right] = Math.max(dp[left][right], dp[i][j] + triangle[left][right]);
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            max = Math.max(dp[triangle.length - 1][i], max);
        }
        
        return max;
    }
}