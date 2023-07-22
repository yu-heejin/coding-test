import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder st = new StringBuilder();
        String[] numbers = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (String n : numbers) {
            int num = Integer.parseInt(n);
            
            if (num > max) {
                max = num;
            }
            
            if (num < min) {
                min = num;
            }
        }
        
        st.append(min);
        st.append(" ");
        st.append(max);
        
        return st.toString();
    }
}