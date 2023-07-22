import java.util.*;

class Solution {
    private int zeroCount = 0;
    private int changeCount = 0;
    
    public int[] solution(String s) {
        while (!s.equals("1")) {
            s = deleteZero(s);
            s = makeBinary(s.length());
        }
        
        return new int[] {changeCount, zeroCount};
    }
    
    private String deleteZero(String s) {
        String answer = s.replace("0", "");
        zeroCount += s.length() - answer.length();
        
        return answer;
    }
    
    private String makeBinary(int length) {
        StringBuilder st = new StringBuilder();
        
        while (length != 0) {
            st.insert(0, length % 2);
            length = length / 2;
        }
        
        changeCount++;
        
        return st.toString();
    }
}