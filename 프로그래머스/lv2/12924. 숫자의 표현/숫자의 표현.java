class Solution {
    
    public int solution(int n) {
        if (n == 1) return 1;
        
        int count = 0;
        
        for (int i = 1; i <= n; i++) {
            if (i == n) {
                count++;
                continue;
            }
            int start = i + 1;
            int sum = i;
            while (sum <= n) {
                sum += start;
                
                if (sum == n) {
                    count++;
                    break;
                }
                
                start++;
            }
        }
        
        return count;
    }
}