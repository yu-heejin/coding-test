import java.util.*;

class Solution {
    
    private final char[] words = { 'A', 'E', 'I', 'O', 'U' };
    private int[] bucket;
    private List<String> answer = new ArrayList<>();
    
    public int solution(String word) {
        for (int i = 1; i <= 5; i++) {
            bucket = new int[i];
            combination(5, i);
        }
        Collections.sort(answer);
        
        return answer.indexOf(word) + 1;
    }
    
    // 매번 전체 아이템중에서 뽑는다.
    private void combination(int n, int r) {
        if (r == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bucket.length; i++) {
                sb.append(words[bucket[i]]);
            }
            answer.add(sb.toString());
            return;
        }

        int lastIndex = bucket.length - r - 1;
        int smallest = 0;   // 매번 전체에서 뽑는다.

        for (int i = smallest; i < n; i++) {
            bucket[lastIndex + 1] = i;
            combination(n, r - 1);
        }
    }
}