import java.util.*;

class Solution {
    
    private final String[] WORD = { "수", "박" };
    
    public String solution(int n) {
        StringBuilder s = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            s.append(WORD[i % 2]);
        }
        
        return s.toString();
    }
}