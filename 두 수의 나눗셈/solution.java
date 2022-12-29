class Solution {
    private final int MULTIPLE_NUMBER = 1000;
    
    public int solution(int num1, int num2) {
        // Java type casting 공부 다시하기!
        double result = (double) num1 / num2 * MULTIPLE_NUMBER;

        return (int) result;
    }
}
