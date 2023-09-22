class Solution {
    
    private final String[] OPERATOR = { "+", "-" };
    private int[] bucket;
    private int count = 0;
    
    public int solution(int[] numbers, int target) {
        // 숫자의 순서를 유지, +, -만 사용
        bucket = new int[numbers.length];
        combination(numbers, 2, numbers.length, target);
        
        return count;
    }
    
    private void combination(int[] numbers, int n, int r, int target) {
        if (r == 0) {
            int sum = 0;
            
            for (int i = 0; i < numbers.length; i++) {
                if (OPERATOR[bucket[i]].equals("+")) {
                    sum += numbers[i];
                } else {
                    sum -= numbers[i];
                }
            }
            
            if (sum == target) {
                count++;
            }
            
            return;
        }
        
        int lastIndex = bucket.length - r - 1;
        int smallest = 0;   // 매번 전체에서 뽑는다.
    
        for (int i = smallest; i < n; i++) {
            bucket[lastIndex + 1] = i;
            combination(numbers, n, r - 1, target);
        }
    }
}