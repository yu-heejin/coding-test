import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> time = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            // 주식 가격이 떨어진 경우, 주식이 처음 들어간 시점과 현재 시점 사이의 초를 구한다.
            // 기존에 스택에 쌓인 모든 값들을 비교
            // 1초간 머무른 것도 1초, 1초간 유지한 것도 1초
            while (!time.isEmpty() && prices[time.peek()] > prices[i]) {
                int index = time.pop();
                answer[index] = i - index;
            }
            
            time.push(i);
        }
        
        // 끝까지 살아남은 주식들
        while (!time.isEmpty()) {
            int index = time.pop();
            answer[index] = prices.length - 1 - index;
        }
        
        return answer;
    }
}