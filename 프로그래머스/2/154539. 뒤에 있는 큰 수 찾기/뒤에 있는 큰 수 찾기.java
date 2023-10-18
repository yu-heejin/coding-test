import java.util.*;

class Solution {
    
    public int[] solution(int[] numbers) {
        Stack<Integer> index = new Stack<>();
        int[] answer = new int[numbers.length];
        
        Arrays.fill(answer, -1);
        
        for (int i = 0; i < numbers.length; i++) {
            while (!index.isEmpty() && numbers[i] > numbers[index.peek()]) {
                answer[index.pop()] = numbers[i];
            }
            index.push(i);
        }
        
        return answer;
    }
}