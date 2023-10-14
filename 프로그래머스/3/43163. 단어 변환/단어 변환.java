import java.util.*;

class Solution {
    private boolean[] visited;
    private int min = 52;
    
    public int solution(String begin, String target, String[] words) {        
        // 탐색을 시작할 위치를 선택한다.
        for (int i = 0; i < words.length; i++) {
            if (canChange(begin, words[i])) {
                visited = new boolean[words.length];
                checkCount(words[i], target, words, 1);
            }
        }
        
        return min == 52 ? 0 : min;
    }
    
    private void checkCount(String begin, String target, String[] words, int depth) {
        if (begin.equals(target)) {
            if (min > depth) {
                min = depth;
            }
            
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && canChange(begin, words[i])) {
                visited[i] = true;
                checkCount(words[i], target, words, depth + 1);
                visited[i] = false;
            }
        }
    }
    
    private boolean canChange(String begin, String word) {
        int count = 0;
        
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) == word.charAt(i)) {
                count++;
            }
        }
        
        if (count == begin.length() - 1) {
            return true;
        }
        
        return false;
    }
}