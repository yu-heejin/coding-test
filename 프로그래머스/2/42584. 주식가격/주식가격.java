import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        Stack<Integer> times = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            while (!times.isEmpty() && prices[times.peek()] > prices[i]) {
                // 현재 가격이 더 작은 경우, 현재 가격보다 더 작은 가격의 시간(인덱스)을 계산
                int index = times.pop();
                result[index] = i - index;
            }
            
            times.push(i);
        }
        
        // 가격이 떨어지지 않은 시간을 계산하기 때문에, 마지막 시간은 비교할 미래 시간이 없어서 0초
        while (!times.isEmpty()) {
            int index = times.pop();
            result[index] = prices.length - 1 - index;
        }
        
        return result;
    }
}