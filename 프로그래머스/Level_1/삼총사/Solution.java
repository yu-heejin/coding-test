class Solution {
    private final int PEOPLE = 3;
    private int[] bucket;
    private int sum = 0;
    private int count = 0;
    
    public int solution(int[] number) {
        bucket = new int[PEOPLE];
        
        combination(number, number.length, PEOPLE);
        return count;
    }
    
    private void combination(int[] number, int n, int r) {
        if (r == 0) {
            sumBucketNumbers(number);
            checkSumResultZero();
            sum = 0;
            return;
        }
        
        int lastIndex = bucket.length - r - 1;
        int smallest = getSmallest(r, lastIndex);
        
        for (int i = smallest; i < n; i++) {
            bucket[lastIndex + 1] = i;
            combination(number, n, r - 1);
        }
    }
    
    private void sumBucketNumbers(int[] number) {
        for (int i = 0; i < bucket.length; i++) {
            sum += number[bucket[i]];
        }
    }
    
    private void checkSumResultZero() {
        if (sum == 0) {
            count++;
        }
    }
    
    private int getSmallest(int r, int lastIndex) {
        if (bucket.length > r) {
            return bucket[lastIndex] + 1;
        }
        
        return 0;
    }
}
