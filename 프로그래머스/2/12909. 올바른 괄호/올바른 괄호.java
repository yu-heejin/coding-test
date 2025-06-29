import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean isSuccess = true;
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                isSuccess = false;
                break;
            } else if (stack.peek() != '(') {
                isSuccess = false;
                break;
            } else {
                stack.pop();
            }
        }
        
        if (!stack.isEmpty()) {
            isSuccess = false;
        }
        
        return isSuccess;
    }
}