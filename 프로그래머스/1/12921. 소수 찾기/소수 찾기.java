import java.util.*;

/* 에라토스테네스의 체 */
class Solution {
    public int solution(int n) {
        boolean[] isPrimeNumbers = new boolean[n + 1];
        
        Arrays.fill(isPrimeNumbers, true);
        
        /* 2부터 시작해 특정 수의 배수에 해당하는 수를 모두 삭제한다. */
        for (int i = 2; i <= n; i++) {
            if (!isPrimeNumbers[i]) continue;   // 이미 소수가 아니라면 건너뛴다.
            
            // 소수이거나 아직 방문하지 않은 경우, 해당 수의 배수부터 모든 숫자 삭제
            for (int j = 2; j <= n; j++) {
                if (i * j > n) break;
                if (isPrimeNumbers[i * j]) isPrimeNumbers[i * j] = false;
            }
        }
        
        int result = 0;
        
        for (int i = 2; i <= n; i++) {
            if (isPrimeNumbers[i]) result++;
        }
        
        return result;
    }
}