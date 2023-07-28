import java.util.*;

/* 
    중복 순열의 변형
    뽑아야 하는 index는 0, 1
    그걸 뽑고 난 합이 n과 같아야하며, 뽑아야하는 정해진 경우는 없다.
    
    동적 배열이면 index로 뽑을 수 없다.
    
    1차: 중복 순열로 했더니 시간초과 ㅠ
    
    ---
    
    2차: 백준의 1, 2, 3 더하기 참조
*/
class Solution {
    public long solution(int n) {
        int[] dp = new int[2001];
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
        
        return dp[n];
    }
}