import java.util.*;

// https://born2bedeveloper.tistory.com/41
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int start = 1;
        int end = distance;
        
        Arrays.sort(rocks);
        int answer = 0;
        
        /**
            mid는 바위 간의 최소 거리 후보값이다.
            따라서 mid보다 작은 거리를 가진 바위는 제거해야 최소 거리를 유지할 수 있다.
            즉, 바위를 몇개 제거해야 이 거리보다 짧은 거리가 없어질지 고민해봐야한다.
        **/
        while (start <= end) {
            int mid = (start + end) / 2;   // 거리 최소값의 후보
            int removeRocks = 0;   // 제거한 바위 수
            int rock = 0;   // 기준 점 (이전 바위 위치) - 거리는 왼쪽에서 오른쪽으로 거리를 재기 때문에 prev 돌이 필요하다.
            
            for (int i = 0; i < rocks.length; i++) {
                // mid 거리를 만족시키지 못하는 돌은 제거한다.
                if (rocks[i] - rock < mid) {
                    // 돌과 돌 사이의 거리가 mid보다 작으면 제거해 그 이상의 거리를 유지한다. (mid가 최소가 되어야 한다.)
                    removeRocks++;
                } else {
                    rock = rocks[i];      // 기준점이 되는 돌, 제거되지 않은 돌은 기준점이 된다.
                }
            }
            
            // 마지막 바위의 거리 계산
            if (distance - rock < mid) {
                removeRocks++;
            }
            
            if (removeRocks <= n) {
                // 조건을 만족하는 경우, 더 큰 최소값이 나올 수 있으므로 mid를 증가
                answer = mid;
                start = mid + 1;
            } else if (removeRocks > n) {
                // 너무 많이 제거했다는 의미는 길이를 너무 넓게 잡았다는 의미로 mid를 감소
                end = mid - 1;
            }
        }
        
        return answer;
    }
}