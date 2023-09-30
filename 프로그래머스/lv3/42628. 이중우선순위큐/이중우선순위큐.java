import java.util.*;

class Solution {
    
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> doublePriority = new TreeMap<>();
        
        for (int i = 0; i < operations.length; i++) {
            String[] command = operations[i].split(" ");
            
            if (command[0].equals("I")) {
                doublePriority.put(
                    Integer.parseInt(command[1]), 
                    doublePriority.getOrDefault(Integer.parseInt(command[1]), 0) + 1
                );
            }
            
            if (doublePriority.size() == 0) {
                continue;
            }
            
            if (command[0].equals("D")) {
                int key = command[1].equals("1")
                    ? doublePriority.lastKey()
                    : doublePriority.firstKey();
                int count = doublePriority.get(key);
                
                if (count == 1) {
                    doublePriority.remove(key);
                } else {
                    doublePriority.put(key, count - 1);
                }
            }
        }
        
        if (doublePriority.size() == 0) {
            return new int[] { 0, 0 };
        }
        
        return new int[] { doublePriority.lastKey(), doublePriority.firstKey() };
    }
}