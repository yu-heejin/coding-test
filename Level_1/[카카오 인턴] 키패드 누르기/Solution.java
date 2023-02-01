// Code idea reference from: https://tosuccess.tistory.com/211
class Solution {
    private final int[][] KEYPAD_POSITION = {
        {0, 0},
        {1, 0},
        {2, 0},
        {0, 1},
        {1, 1},
        {2, 1},
        {0, 2},
        {1, 2},
        {2, 2},
        {0, 3},
        {1, 3},
        {2, 3}
    };
    private final int LEFT_DEFAULT_POSITION = 9;
    private final int RIGHT_DEFAULT_POSITION = 11;
    private final int NUMBER_FOR_CHANGING_ZERO = 11;
    private final String LEFT = "L";
    private final String RIGHT = "R";
    private int[] leftPosition = KEYPAD_POSITION[LEFT_DEFAULT_POSITION];
    private int[] rightPosition = KEYPAD_POSITION[RIGHT_DEFAULT_POSITION];
    
    public String solution(int[] numbers, String hand) {
        StringBuffer answer = new StringBuffer();
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numbers[i] = NUMBER_FOR_CHANGING_ZERO;
            }
            
            String result = getLeftOrRight(numbers[i], hand);
            answer.append(result);
            getLeftOrRightPosition(result, numbers[i]);
        }
        
        return answer.toString();
    }
    
    private String getLeftOrRight(int number, String hand) {
        if (number == 1 || number == 4 || number == 7) {
            return LEFT;
        } 
        
        if (number == 3 || number == 6 || number == 9) {
            return RIGHT;
        }
        
        int[] numbersPosition = KEYPAD_POSITION[number - 1];
        int tempLeftPosition = getManhattanDistance(numbersPosition, leftPosition);
        int tempRightPosition = getManhattanDistance(numbersPosition, rightPosition);
        
        if (tempLeftPosition < tempRightPosition) {
            return LEFT;   
        } 
        
        if (tempLeftPosition == tempRightPosition) {
            if (hand.equals("left")) {
                return LEFT;
            } 
            
            return RIGHT;
        } 
        
        return RIGHT;
        
    }
    
    private int getManhattanDistance(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }
    
    
    private void getLeftOrRightPosition(String result, int number) {
        if (result.equals(LEFT)) {
            leftPosition = KEYPAD_POSITION[number - 1];
            return;
        }
        
        rightPosition = KEYPAD_POSITION[number - 1];
    }
}
