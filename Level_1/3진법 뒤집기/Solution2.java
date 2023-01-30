class Solution {
    private final int BASE_NUMBER = 3;
    
    public int solution(int n) {
        String reverseNumber = getReverseNumber(n, "");
        return getAnswer(n, reverseNumber);
    }
    
    private String getReverseNumber(int n, String reverseNumber) {
        while (n > 0) {
            reverseNumber += n % BASE_NUMBER;
            n /= BASE_NUMBER;
        }
        
        return reverseNumber;
    }
    
    private int getAnswer(int n, String reverseNumber) {
        int answer = 0;
        int numberForMultiple = 1;
        
        for (int i = reverseNumber.length() - 1; i >= 0; i--) {
            answer += (int)(reverseNumber.charAt(i) - '0') * numberForMultiple;
            numberForMultiple *= BASE_NUMBER;
        }
        
        return answer;
    }
}
