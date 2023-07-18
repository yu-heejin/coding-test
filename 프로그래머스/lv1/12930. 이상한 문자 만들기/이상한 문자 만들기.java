import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder st = new StringBuilder();
        int index = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == ' ') {
                index = 0;
            } else if (i > 0 && s.charAt(i - 1) == ' ') {
                index = 0;
            }
            
            if (index % 2 == 0) {
                c = Character.toUpperCase(c);
            } else {
                c = Character.toLowerCase(c);
            }
            
            st.append(c);
            index++;
        }
        
        return st.toString();
    }
}