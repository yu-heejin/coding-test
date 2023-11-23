import java.util.*;

class Solution {
    
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> big = new HashMap<>();
        
        for (int t : topping) {
            big.put(t, big.getOrDefault(t, 0) + 1);
        }
        
        Set<Integer> small = new HashSet<>();
        
        for (int i = 0; i < topping.length; i++) {
            small.add(topping[i]);
            big.put(topping[i], big.getOrDefault(topping[i], 0) - 1);
            
            if (big.get(topping[i]) <= 0) {
                big.remove(topping[i]);
            }
            
            if (big.size() == small.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}