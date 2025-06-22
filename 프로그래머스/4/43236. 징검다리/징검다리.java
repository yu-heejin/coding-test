import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int left = 0;
        int right = distance;    // 거리의 최대값
        int answer = 0;
        
        // 이분탐색 - 정렬
        Arrays.sort(rocks);
        
        while (left <= right) {
            int mid = (left + right) / 2;     // 내가 지정한 최소 거리
            int count = 0;    // 돌이 얼마나 지워지는지
            int prev = 0;
            
            for (int i = 0; i < rocks.length; i++) {
                // 가장 마지막에 남겨둔 돌을 기준으로 계산해야한다.
                int dist = rocks[i] - prev;
                
                if (dist < mid) {
                    count++;
                } else {
                    prev = rocks[i];
                }
            }
            
            if (distance - prev < mid) {
                count++;
            }
            
            if (count > n) {
                // 지워야 할 돌보다 지운 돌이 더 많으면 mid(최소거리)를 줄여 지워지는 돌의 개수를 줄여야 한다.
                right = mid - 1;
            } else if (count <= n) {
                // 지워야 할 돌보다 지운 돌이 적으면 mid를 늘여 지워지는 돌의 개수를 늘려야한다.
                answer = mid;
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    private int getDistance(int distance, int[] rocks, int index) {
        int before = 0;
        int after = distance;
        
        if (index > 0) {
            before = rocks[index - 1];
        }
        
        if (index < rocks.length - 1) {
            after = rocks[index + 1];
        }
        
        return Math.abs(after - before);
    }
}