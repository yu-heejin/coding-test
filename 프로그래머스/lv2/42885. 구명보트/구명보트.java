import java.util.*;

class Solution {
    // Greedy: 가장 큰 무게를 가진 사람부터 태운다.
    
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int answer = 0;
        int minIndex = 0;
        int maxIndex = people.length - 1;
        
        while (minIndex <= maxIndex) {
            if (people[minIndex] + people[maxIndex] <= limit) {
                minIndex++;
            }
            
            maxIndex--;
            answer++;
        }
        
        return answer;
    }
}
