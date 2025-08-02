class Solution {
    private char[] op = {'+', '-'};
    private int count = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target, 0);
        
        return count;
    }
    
    private void dfs(int sum, int[] numbers, int target, int start) {
        if (start == numbers.length) {
            if (sum == target) count++;
            return;
        }
        
        for (int j = 0; j < 2; j++) {
            switch (op[j]) {
                case '+':
                    dfs(sum + numbers[start], numbers, target, start + 1);
                    break;

                case '-':
                    dfs(sum - numbers[start], numbers, target, start + 1);
                    break;
            }
        }
    }
}