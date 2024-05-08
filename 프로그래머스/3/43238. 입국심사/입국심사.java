import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long left = 0;
        // 가장 긴 시간은 모든 사람들이 오래 걸리는 심사대에서 심사하는 경우
        long right = (long) times[times.length - 1] * n;
        long answer = 0L;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            // mid 시간 동안 몇 명을 처리할 수 있는지?
            long total = 0;
            
            for (int i = 0; i < times.length; i++) {
                total += (mid / times[i]);
            }
            
            // 해당 시간 동안 모든 사람을 처리할 수 없는 경우 left 증가
            if (total < n) {
                left = mid + 1;
            } else {
                // 해당 시간 동안 처리할 수 있는 최소 경우의 수를 구함
                right = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}