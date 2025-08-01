import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> tempAnswer = new ArrayList<>();
        Queue<Integer> tasks = new LinkedList<>();
        
        // 배포까지 필요한 날짜를 큐에 삽입
        for (int i = 0; i < progresses.length; i++) {
            // 0으로 안 나누어 떨어지면 하루 더 일해야함
            if ((100 - progresses[i]) % speeds[i] != 0) {
                tasks.offer((100 - progresses[i]) / speeds[i] + 1);
            } else {
                tasks.offer((100 - progresses[i]) / speeds[i]);
            }
        }
        
        // 첫번째 기능 배포 날짜
        int deploy = tasks.peek();
        int count = 0;
        
        while (!tasks.isEmpty()) {
            // 현재 배포 날짜가 큐의 다음기능 배포 날짜보다 크면 제거
            if (tasks.peek() <= deploy) {
                count++;
                tasks.poll();
            } else {
                // 더이상 제거할 수 없는 경우 정답 추가
                tempAnswer.add(count);
                count = 0;
                deploy = tasks.peek();    // 다음 배포 날짜
            }
        }
        
        // 마지막 배포
        if (count > 0) {
            tempAnswer.add(count);
        }
        
        int[] answer = new int[tempAnswer.size()];
        
        for (int i = 0; i < tempAnswer.size(); i++) {
            answer[i] = tempAnswer.get(i);
        }
        
        return answer;
    }
}