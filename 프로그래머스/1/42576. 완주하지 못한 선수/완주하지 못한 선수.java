import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> pCounts = new HashMap<>();
        
        for (String p : participant) {
            pCounts.put(p, pCounts.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            pCounts.put(c, pCounts.get(c) - 1);
            
            if (pCounts.get(c) == 0) {
                pCounts.remove(c);
            }
        }
        
        return pCounts.keySet().iterator().next();
    }
}