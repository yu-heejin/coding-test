import java.util.*;

class Solution {
    public String solution(String s) {
        String[] alphabet = s.split("");
        
        Arrays.sort(alphabet, Collections.reverseOrder());
        
        return String.join("", alphabet);
    }
}