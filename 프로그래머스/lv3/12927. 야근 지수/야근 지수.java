import java.util.*;

class Solution {
    
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> list = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < works.length; i++) {
            list.add(works[i]);
        }
        
        for (int i = 0; i < n; i++) {
            int work = list.poll();
            work--;
            list.add(work);
        }
        
        long answer = 0;
        while (!list.isEmpty()) {
            int work = list.poll();
            if (work >= 0) {
                answer += (work * work);
            }
        }
        
        return answer;
    }
}