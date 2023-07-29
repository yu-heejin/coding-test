class Solution {
    private final int TRUE = 1;
    private final int FALSE = 2;
    
    public int solution(int n) {
        int sqrtResult = (int) Math.sqrt(n);
        int powResult = (int) Math.pow(sqrtResult, 2);
        
        if (n == powResult) {
            return TRUE;
        }
        
        return FALSE;
    }
}
