class Solution {
    public long solution(long n) {
        long sqrt = (long) Math.sqrt(n);
        
        if ((sqrt * sqrt) != n) {
            return -1;
        }
        
        return (long) Math.pow(sqrt + 1, 2);
    }
}