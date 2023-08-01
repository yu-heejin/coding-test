import java.util.*;

class Solution {
    // '모두' 제거해야만 1을 반환한다.
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        if (!stack.isEmpty()) {
            return 0;
        }
        
        return 1;
    }
}