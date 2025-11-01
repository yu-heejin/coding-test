import java.util.*;

class Solution {
    private final int[] ONE = {1, 2, 3, 4, 5};
    private final int[] TWO = {2, 1, 2, 3, 2, 4, 2, 5};
    private final int[] THREE = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        List<Integer> result = new ArrayList<>();
        int oneAnswer = 0;
        int twoAnswer = 0;
        int threeAnswer = 0;
        int oneIndex = 0;
        int twoIndex = 0;
        int threeIndex = 0;
        
        for (int answer : answers) {
            if (ONE[oneIndex] == answer) {
                oneAnswer++;
            }
            
            if (TWO[twoIndex] == answer) {
                twoAnswer++;
            }
            
            if (THREE[threeIndex] == answer) {
                threeAnswer++;
            }
            
            oneIndex = (oneIndex + 1) % ONE.length;
            twoIndex = (twoIndex + 1) % TWO.length;
            threeIndex = (threeIndex + 1) % THREE.length;
        }
        
        if (oneAnswer > twoAnswer) {
            if (oneAnswer < threeAnswer) {
                // 3 > 1 > 2
                return new int[] {3};
            } else if (oneAnswer == threeAnswer) {
                // 3 == 1 > 2
                return new int[] {1, 3};
            } else {
                // 1 >
                return new int[] {1};
            }
        } else if (oneAnswer == twoAnswer) {
            if (oneAnswer < threeAnswer) {
                // 3 > 1 == 2
                return new int[] {3};
            } else if (oneAnswer == threeAnswer) {
                // 1 == 2 == 3
                return new int[] {1, 2, 3};
            } else {
                // 1 == 2 > 3
                return new int[] {1, 2};
            }
        } else {
            // 2 > 1
            if (twoAnswer < threeAnswer) {
                // 3 > 2 > 1
                return new int[] {3};
            } else if (twoAnswer == threeAnswer) {
                // 3 == 2 > 1
                return new int[] {2, 3};
            } else {
                // 2 >
                return new int[] {2};
            }
        }
    }
}