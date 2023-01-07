class Solution {
    private final int SAME_NUMBER = 1;
    private final int NOT_SAME_NUMBER = -1;
    
    public int solution(int num1, int num2) {
        if (num1 == num2) {
            return SAME_NUMBER;
        }
        
        return NOT_SAME_NUMBER;
    }
}
