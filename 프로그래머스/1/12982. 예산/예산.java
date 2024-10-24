import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int count = 0;
        
        Arrays.sort(d);
        
        for (count = 0; count < d.length; count++) {
            if (budget < d[count]) break;
            budget -= d[count];
        }
        
        return count;
    }
}