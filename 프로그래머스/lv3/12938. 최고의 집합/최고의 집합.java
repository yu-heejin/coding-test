import java.util.*;

class Solution {
    
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[] { -1 };
        }
        
        int[] answer = new int[n];
        int basic = s / n;
        int add = s % n;
        
        Arrays.fill(answer, basic);
        
        int i = 0;
        while (add > 0) {
            answer[i]++;
            add--;
            i = (i + 1) % n;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}