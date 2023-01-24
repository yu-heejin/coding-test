class Solution {
    public long solution(int price, int money, int count) {
        long sum = getSum(price, count);
        return getAnswer(money, sum);
    }
    
    private long getSum(int price, int count) {
        long sum = 0;
        
        for (int i = 1; i <= count; i++) {
            sum += price * i;
        }
        
        return sum;
    }
    
    private long getAnswer(int money, long sum) {
        if (money >= sum) {
            return 0;
        }
        
        return sum - money;
    }
}
