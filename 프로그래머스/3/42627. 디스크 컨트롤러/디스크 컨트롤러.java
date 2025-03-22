import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 소요시간을 위한 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        // 작업 요청시점을 위한 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        int count = 0;   // 요청된 작업 수
        int time = 0;    // 현재 시간
        int answer = 0;
        
        // 아직 큐에 남아있는가 || 모든 작업들이 요청되었는가
        while (!pq.isEmpty() || count < jobs.length) {
            // 현재 시간보다 요청 시간이 작거나 같으면 큐에 추가
            while (count < jobs.length && jobs[count][0] <= time) {
                pq.offer(jobs[count++]);
            }
            
            // 큐에 작업이 없는 경우, 작업 소요시간이 가장 빠른 작업 수행
            if (pq.isEmpty()) {
                // 대기 큐에 작업이 없고, 디스크가 놀고있는 상태라면 시간을 강제로 다음 작업의 도착 시간까지 점프해야한다.
                time = jobs[count][0];
            } else {
                // 작업이 있는 경우
                int[] job = pq.poll();
                time += job[1];
                // 종료된 시간 - 요청 시간 = 반환 시간 (작업 요청부터 종료된 시간)
                answer += time - job[0];
            }
        }
        
        return answer / jobs.length;
    }
}