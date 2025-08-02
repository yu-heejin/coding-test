import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            
            return o1[1] - o2[1];
        });
        
        // job이 요청 시간대로 들어온다는 보장이 없으므로 정렬
        Arrays.sort(jobs, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        
        int currentTime = 0;
        int totalTime = 0;
        int index = 0;
        
        while (index < jobs.length || !q.isEmpty()) {
            // 1. 현재 시간과 요청시간이 같으면 큐에 삽입
            
            for (int i = index; i < jobs.length; i++) {
                if (currentTime >= jobs[i][0]) {
                    q.add(jobs[i]);
                    index++;
                }
            }
            
            // 2. 현재 큐에 아무것도 없으면, 현재 시간을 다음 요청 시간으로 맞춘다.
            if (q.isEmpty()) {
                currentTime = jobs[index][0];
            } else {
                // 3. 작업이 남아있으면 해당 작업을 실행한다.
                int[] currentJob = q.poll();
                // 대기 시간 + 실행 시간
                totalTime += (currentTime - currentJob[0] + currentJob[1]);
                // 수행 시간
                currentTime += currentJob[1];
            }
        }
        
        return totalTime / jobs.length;
    }
}