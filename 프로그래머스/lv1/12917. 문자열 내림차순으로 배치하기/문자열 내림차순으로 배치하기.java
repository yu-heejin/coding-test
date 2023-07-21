import java.util.*;

class Solution {
    public String solution(String s) {
        char[] alpha = s.toCharArray();
        Arrays.sort(alpha);
        
        StringBuilder st = new StringBuilder(new String(alpha));
        
        return st.reverse().toString();
    }
}