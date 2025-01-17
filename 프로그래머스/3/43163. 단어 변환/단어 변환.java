import java.util.*;

class Solution {
    private int minCount = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) return 0;
        
        dfs(begin, target, new boolean[words.length], words, 0);
        
        return minCount;
    }
    
    private void dfs(String current, String target, boolean[] visited, String[] words, int count) {
        if (current.equals(target)) {
            minCount = Math.min(minCount, count);
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;
            
            int diffCount = 0;
            for (int j = 0; j < current.length(); j++) {
                if (words[i].charAt(j) != current.charAt(j)) diffCount++;
            }
            
            if (diffCount == 1) {
                if (target.equals(words[i])) {
                    minCount = Math.min(minCount, count + 1);
                    break;
                } else {
                    visited[i] = true;
                    dfs(words[i], target, visited, words, count + 1);
                    visited[i] = false;
                }
            }
        }
    }
}