import java.util.Map;
import java.util.HashMap;

class Solution {
    Map<Integer, Double> failRate;
    public int[] solution(int N, int[] stages) {
        failRate = new HashMap<>();
        
        initFailRate(stages, N);
        return getAnswer(N);
    }
    
    private void initFailRate(int[] stages, int N) {
        int users = stages.length;
        
        for (int i = 0; i < N; i++) {
            int userCount = getUserCount(stages, i + 1);
            
            failRate.put(i + 1, (double)userCount / users);
            users -= userCount;
        }
    }
    
    private int getUserCount(int[] stages, int stage) {
        int userCount = 0;
        
        for (int i = 0; i < stages.length; i++) {
            if (stages[i] == stage) {
                userCount++;
            }
        }
        
        return userCount;
    }
    
    private int[] getAnswer(int N) {
        int[] answer = new int[N];
        int answerIndex = 0;
        
        while (failRate.size() > 0) {
            Map.Entry<Integer, Double> max = getMaxValue();
            
            answer[answerIndex] = max.getKey();
            answerIndex++;
            failRate.remove(max.getKey());
        }
        
        return answer;
    }
    
    private Map.Entry<Integer, Double> getMaxValue() {
        Map.Entry<Integer, Double> max = null;
        
        for (Map.Entry<Integer, Double> entry : failRate.entrySet()) {
            if (max == null || entry.getValue() > max.getValue()) {
                max = entry;
            }
        }
        
        return max;
    }
}
