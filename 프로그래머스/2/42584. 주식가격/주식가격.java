import java.util.*;

class Solution {
    
    public int[] solution(int[] prices) {
        int[] answers = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            answers[i] = 0;
            // 떨어지지 않을 때까지 버텨야함
            for (int j = i + 1; j < prices.length; j++) {
                answers[i]++;
                if (prices[i] > prices[j]) break;
            }
        }
        
        return answers;
    }
}