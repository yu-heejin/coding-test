class Solution {
    private final int MAX_NUM = 3;
    private int answer = 0;
    private int[] bucket;
    private boolean[] prime;
    
    public int solution(int[] nums) {
        bucket = new int[MAX_NUM];
        prime = new boolean[MAX_NUM];
        
        combination(nums, nums.length, MAX_NUM);
        return answer;
    }
    
    private void combination(int[] nums, int n, int r) {
        if (r == 0) {
            int sum = getSum(nums);
            
            if (isPrime(sum)) {
                answer++;
            }
            
            return;
        }
        
        int lastIndex = bucket.length - r - 1;
        int smallest = getSmallest(r, lastIndex);
        
        for (int i = smallest; i < n; i++) {
            bucket[lastIndex + 1] = i;
            combination(nums, n, r - 1);
        }
    }
    
    private int getSmallest(int r, int lastIndex) {
        if (bucket.length > r) {
            return bucket[lastIndex] + 1;
        }
        
        return 0;
    }
    
    private int getSum(int[] nums) {
        int sum = 0;
        
        for (int i = 0; i < bucket.length; i++) {
            sum += nums[bucket[i]];
        }
        
        return sum;
    }
    
    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        
        if (num == 2) {
            return true;
        }
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
