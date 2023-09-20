import java.util.*;

class Solution {
    
    public String solution(int n, int t, int m, int p) {
        int start = 0;
        int order = 1;
        int answerCount = 0;
        StringBuilder sb = new StringBuilder();
        
        while (answerCount < t) {
            String convert = Integer.toString(start, n);
            for (int i = 0; i < convert.length(); i++) {
                if (order == p && answerCount < t) {
                    sb.append(convert.charAt(i));
                    answerCount++;
                }
                
                order++;
                if (order > m) {
                    order = 1;
                }
            }
            
            start++;
        }
        
        return sb.toString().toUpperCase();
    }
}