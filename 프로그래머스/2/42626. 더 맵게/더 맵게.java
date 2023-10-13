import java.util.*;

class Solution {
    
    PriorityQueue<Integer> q = new PriorityQueue<>();
    
    // 런타임 에러: 스코빌 지수가 하나 남은 경우
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        initQueue(scoville, K);
        
        if (q.peek() > K) {
            return answer;
        }
        
        while (!q.isEmpty()) {
            int min1 = q.poll();
            
            if (q.isEmpty()) {
                if (min1 >= K) {
                    return answer;
                }
                
                return -1;
            }
            
            if (min1 >= K) {
                return answer;
            }
            
            int min2 = q.poll();
            int mix = min1 + (min2 * 2);
            
            q.add(mix);
            
            answer++;
        }
        
        return answer;
    }
    
    private void initQueue(int[] scoville, int K) {
        for (int s : scoville) {
            q.add(s);
        }
    }
}