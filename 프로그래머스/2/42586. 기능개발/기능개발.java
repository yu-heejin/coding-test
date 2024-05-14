import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 하루 지날 때마다 speeds만큼 작업률 상승
        // 앞에 있는 작업이 모두 끝나야 뒤에 있는 작업이 배포된다.
        List<Integer> answer = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        
        // 큐에 작업을 담는다.
        for (int i = 0; i < progresses.length; i++) {
            q.add(new int[] { progresses[i], speeds[i] });
        }
        
        while (!q.isEmpty()) {
            int count = 0;
            
            // speeds만큼 더해준다.
            for (int[] p : q) {
                p[0] += p[1];
            }
            
            // 오늘 몇개의 기능이 배포되는지 확인
            while (!q.isEmpty() && q.peek()[0] >= 100) {
                count++;
                q.poll();
            }
            
            if (count > 0) {
                answer.add(count);
            }
            
            count = 0;
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}