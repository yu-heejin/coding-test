import java.util.*;

public class Solution {
    /*
        n = 5
        1. 2.5 -> 4 (1)
        2. 2
        3. 0
        
        n = 6
        1. 3
        2. 1.5 -> 2 (1)
        3. 0
    */
    public int solution(int n) {
        int usage = 0;
        
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                usage++;
                n--;
            }
        }
        
        return usage;
    }
}