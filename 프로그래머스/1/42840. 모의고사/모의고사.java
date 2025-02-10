import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] firstAnswers = {1, 2, 3, 4, 5};
        int[] secondAnswers = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdAnswers = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = {0, 0, 0};
        int firstIndex = 0;
        int secondIndex = 0;
        int thirdIndex = 0;
        
        for (int answer : answers) {
            if (firstAnswers[firstIndex] == answer) {
                scores[0]++;
            }
            
            if (secondAnswers[secondIndex] == answer) {
                scores[1]++;
            }
            
            if (thirdAnswers[thirdIndex] == answer) {
                scores[2]++;
            }
            
            firstIndex = (firstIndex + 1) % 5;
            secondIndex = (secondIndex + 1) % 8;
            thirdIndex = (thirdIndex + 1) % 10;
        }
        
        List<Integer> results = new ArrayList<>();
        // 최대 값을 찾기 위해 먼저 비교한다.
        int max = Math.max(scores[0], Math.max(scores[1], scores[2]));
        for (int i = 0; i < 3; i++) {
            // 최대 점수랑 같으면 결과에 포함한다.
            if (scores[i] == max) {
                results.add(i + 1);
            }
        }
        
        Collections.sort(results);
        
        int[] resultForReturn = new int[results.size()];
        
        for (int i = 0; i < results.size(); i++) {
            resultForReturn[i] = results.get(i);
        }
        
        return resultForReturn;
    }
}