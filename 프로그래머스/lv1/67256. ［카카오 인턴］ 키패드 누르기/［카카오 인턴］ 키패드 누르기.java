import java.util.*;

class Solution {
    
    private final int[][] KEYPAD_POSITION = {
        {0, 0}, // 1
        {1, 0}, // 2
        {2, 0}, // 3
        {0, 1}, // 4
        {1, 1}, // 5
        {2, 1}, // 6
        {0, 2}, // 7
        {1, 2}, // 8
        {2, 2}, // 9
        {0, 3}, // *
        {1, 3}, // 0
        {2, 3} // #
    };
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        int[] left = KEYPAD_POSITION[9];
        int[] right = KEYPAD_POSITION[11];
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numbers[i] = 11;
            }
            
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer.append("L");
                left = KEYPAD_POSITION[numbers[i] - 1];
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer.append("R");
                right = KEYPAD_POSITION[numbers[i] - 1];
            } else { // 가운데 열의 숫자 2, 5, 8, 0 처리
                int leftDistance = getManhattanDistance(left, KEYPAD_POSITION[numbers[i] - 1]);
                int rightDistance = getManhattanDistance(right, KEYPAD_POSITION[numbers[i] - 1]);

                if (leftDistance < rightDistance) {
                    answer.append("L");
                    left = KEYPAD_POSITION[numbers[i] - 1];
                } else if (leftDistance > rightDistance) {
                    answer.append("R");
                    right = KEYPAD_POSITION[numbers[i] - 1];
                } else { // 거리가 같을 때
                    if (hand.equals("left")) {
                        answer.append("L");
                        left = KEYPAD_POSITION[numbers[i] - 1];
                    } else {
                        answer.append("R");
                        right = KEYPAD_POSITION[numbers[i] - 1];
                    }
                }
            }

        }
        
        return answer.toString();
    }
    
    // |x1 - x2| + |y1 - y2|
    private int getManhattanDistance(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }
}