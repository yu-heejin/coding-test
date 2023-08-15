import java.util.*;

class Solution {
    
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> days = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            days.offer((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        
        // 맨 처음 나오는 날짜가 맨 처음 작업이 완료되는 날짜
        List<Integer> answer = new ArrayList<>();
        while (!days.isEmpty()) {
            int day = days.poll();  // 해당 작업이 완료되는 날짜
            int success = 1;
            // 해당 작업이 완료되는 날짜에 뒤에 있는 작업들이 완료되어있는 경우
            while (!days.isEmpty() && day >= days.peek()) {
                success++;
                days.poll();
            }
            
            answer.add(success);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}