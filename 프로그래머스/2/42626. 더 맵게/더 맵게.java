import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        int result = 0;
        
        while (!pq.isEmpty()) {
            if (pq.peek() >= K) {
                // 모든 음식이 K 이상의 스코빌을 가진다.
                break;
            }
            
            if (pq.size() < 2) {
                // 더 이상 섞을 수 없다.
                break;
            }
            
            int first = pq.poll();    // 가장 맵지 않은 음식
            int second = pq.poll();   // 두번째로 맵지 않은 음식
            int sum = first + (second * 2);

            pq.add(sum);
            result++;    // 섞어야하는 최소 횟수
        }
        
        while (!pq.isEmpty()) {
            if (pq.poll() < K) {
                return -1;
            }
        }
        
        return result;
    }
}