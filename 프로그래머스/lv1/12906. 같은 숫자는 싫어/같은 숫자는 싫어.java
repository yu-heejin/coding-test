import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answers = new ArrayList<>();
        int answersIndex = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                // 원소를 처음 넣는 경우
                answers.add(arr[i]);
                answersIndex++;
            } else if (arr[i] != answers.get(answersIndex - 1)) {
                // 현재 원소가 이전의 원소와 다른 경우
                answers.add(arr[i]);
                answersIndex++;
            }
        }
        
        return answers.stream().mapToInt(i -> i).toArray();
    }
}