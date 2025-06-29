import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        // numers의 길이는 100 이하, 모든 수도 100 이하
        Set<Integer> answer = new TreeSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) continue;
                
                answer.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] toArr = new int[answer.size()];
        int arrIndex = 0;
        for (int n : answer) {
            toArr[arrIndex] = n;
            arrIndex++;
        }
        
        return toArr;
    }
}