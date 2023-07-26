import java.util.*;

public class Solution {
    /*
        2 나누기 2는 0이 아니라 1이다!!!!!
        n = 5
        1. 2.5 -> 4 (1)
        2. 2
        3. 1 -> 0 (1)
        
        n = 6
        1. 3
        2. 1.5 -> 2 (1)
        3. 1 -> 0 (1)
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
