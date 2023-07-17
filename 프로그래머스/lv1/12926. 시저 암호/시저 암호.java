import java.util.*;

// 알파벳 순환이 핵심 포인트임
class Solution {
    public String solution(String s, int n) {
        StringBuilder st = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isUpperCase(c)) {
                c = (char) ((c - 'A' + n) % 26 + 'A');
            } else if (Character.isLowerCase(c)) {
                c = (char) ((c - 'a' + n) % 26 + 'a');
            }
            
            st.append(c);
        }
        
        return st.toString();
    }
}