import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        // 오름차순 정렬
        Arrays.sort(times);
        long result = 0;
        
        // 최소 시간 및 최대 시간 범위 지정
        long left = 0;
        long right = (long)times[times.length - 1] * n;  // 최악의 경우, 오래걸리는 곳에만 입국심사 하는 경우
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            // mid 시간 동안 각 심사국에서 몇명을 처리하는지 보려면 나누기 필요
            long total = 0;
            for (int i = 0; i < times.length; i++) {
                total += (mid / times[i]);
            }
            
            if (total < n) {
                // 실제 인원보다 처리를 못하는 경우 - left를 늘린다
                left = mid + 1;
            } else {
                // 모든 사람이 검사 받았으나 더 작은 최솟값이 있을 수도 있음
                right = mid - 1;
                result = mid;
            }
        }
        
        return result;
    }
}