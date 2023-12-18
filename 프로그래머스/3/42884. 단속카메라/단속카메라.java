import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> {
           return o1[1] - o2[1]; 
        });
        
        int count = 1;
        int minPosition = routes[0][1];
        
        for (int[] route : routes) {
            if (route[0] > minPosition && route[1] > minPosition) {
                count++;
                minPosition = route[1];
            }
        }
        
        return count;
    }
}