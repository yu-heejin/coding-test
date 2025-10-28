import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> tangerines = new HashMap<>();
        
        for (int t : tangerine) {
            tangerines.put(t, tangerines.getOrDefault(t, 0) + 1);
        }
        
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
            return tangerines.get(o2) - tangerines.get(o1);
        });
        
        for (int t : tangerines.keySet()) {
            q.add(t);
        }
        
        int answer = 0;
        while (k > 0) {
            int t = q.poll();
            k -= tangerines.get(t);
            answer++;
        }
        
        return answer;
    }
}