import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                s = rotateString(s, i);
            }
            
            if (isCorrectedString(s)) {
                count++;
            }
        }
        
        return count;
    }
    
    private String rotateString(String s, int i) {
        StringBuilder sb = new StringBuilder(s);
        
        // 앞 문자를 잘라서 뒤에 붙여준다.
        String subString = sb.substring(0, 1);
        sb.delete(0, 1);
        sb.append(subString);
        
        return sb.toString();
    }
    
    private boolean isCorrectedString(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c =='(' || c == '{' || c == '[') {
                st.push(c);
            }

            if (c ==')' || c == '}' || c == ']') {
                if (st.isEmpty()) {
                    return false;
                }
                
                char before = st.pop();
                
                if (c == ')' && before != '(') {
                    return false;
                }
                
                if (c == '}' && before != '{') {
                    return false;
                }
                
                if (c == ']' && before != '[') {
                    return false;
                }
            }
        }
        
        if (!st.isEmpty()) {
            return false;
        }
        
        return true;
    }
}