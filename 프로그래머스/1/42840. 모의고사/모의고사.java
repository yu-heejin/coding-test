import java.util.*;

class Solution {
    private final int[] first = {1, 2, 3, 4, 5};
    private final int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
    private final int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int firstIndex = 0;
        int secondIndex = 0;
        int thirdIndex = 0;
        int firstCount = 0;
        int secondCount = 0;
        int thirdCount = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (first[firstIndex] == answers[i]) {
                firstCount++;
            }
            
            if (second[secondIndex] == answers[i]) {
                secondCount++;
            }
            
            if (third[thirdIndex] == answers[i]) {
                thirdCount++;
            }
            
            firstIndex = (firstIndex + 1) % first.length;
            secondIndex = (secondIndex + 1) % second.length;
            thirdIndex = (thirdIndex + 1) % third.length;
        }
        
        List<Integer> answer = new ArrayList<>();
        int max = Math.max(firstCount, Math.max(secondCount, thirdCount));
        
        if (max == firstCount) {
            answer.add(1);
        }
        
        if (max == secondCount) {
            answer.add(2);
        }
        
        if (max == thirdCount) {
            answer.add(3);
        }
        
        // List to int[]
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}