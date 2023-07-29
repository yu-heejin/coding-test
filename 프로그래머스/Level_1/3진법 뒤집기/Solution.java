class Solution {
    private final int BASE_NUMBER = 3;
    
    public int solution(int n) {
        String resultNumber = getResultNumber(n, "");
        String reverseNumber = getReverseResultNumber(resultNumber);
        
        return getAnswer(n, reverseNumber);
    }
    
    private String getResultNumber(int n, String resultNumber) {
        if (n == 0) return resultNumber;
        
        resultNumber = getResultNumber(n / BASE_NUMBER, resultNumber);
        resultNumber += n % BASE_NUMBER;
        return resultNumber;
    }
    
    private String getReverseResultNumber(String resultNumber) {
        StringBuilder builder = new StringBuilder(resultNumber);
        
        return builder.reverse().toString();
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
