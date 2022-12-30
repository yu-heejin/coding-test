class Solution {
    private final int PIZZA_PIECE = 7;
    
    public int solution(int n) {
        int answer = n / PIZZA_PIECE;
        
        if (n % PIZZA_PIECE > 0) {
            answer++;
        }
        
        return answer;
    }
}
