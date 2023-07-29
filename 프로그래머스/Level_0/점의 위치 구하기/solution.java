import java.util.Arrays;
import java.util.List;

class Solution {
    private final List<Integer> ANSWERS = Arrays.asList(1, 2, 3, 4);
    private final int X_INDEX = 0;
    private final int Y_INDEX = 1;
    
    public int solution(int[] dot) {
        if (dot[X_INDEX] > 0 && dot[Y_INDEX] > 0) {
            return ANSWERS.get(0);
        }
        
        if (dot[X_INDEX] < 0 && dot[Y_INDEX] > 0) {
            return ANSWERS.get(1);
        }
        
        if (dot[X_INDEX] < 0 && dot[Y_INDEX] < 0) {
            return ANSWERS.get(2);
        }
        
        return ANSWERS.get(3);
    }
}
