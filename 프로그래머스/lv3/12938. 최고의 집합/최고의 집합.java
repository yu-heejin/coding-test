import java.util.*;

class Solution {
    
    // s의 합이 되는 원소를 다 뽑고 n개씩 뽑는다.
    // 가장 큰 값의 합을 구한다.
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