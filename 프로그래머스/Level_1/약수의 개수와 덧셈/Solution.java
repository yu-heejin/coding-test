class Solution {
    public int solution(int left, int right) {
        int sum = 0;
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
            sum = getNumberOfDivisors(i);
            answer = calculateAnswer(sum, i, answer);
            sum = 0;
        }
        
        return answer;
    }
    
    private int getNumberOfDivisors(int i) {
        int sum = 0;
        
        for (int j = 1; j <= Math.sqrt(i); j++) {
            sum = getSum(sum, i, j);
        }
        
        return sum;
    }
    
    private int getSum(int sum, int i, int j) {
        if ((i % j == 0) && (i / j != j)) {   // 나눈 수가 제곱근이 아니면 한번 더 증가
            sum += 2;
            return sum;
        } 
        
        if (i % j == 0) {
            sum++;
        }
        
        return sum;
    }
    
    private int calculateAnswer(int sum, int i, int answer) {
        if (sum % 2 == 0) {
            answer += i;
            return answer;
        } 
        
        answer -= i;
        return answer;
    }
}
