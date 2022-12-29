class Solution {
    private final int DISH_PRICE = 12000;
    private final int BEVERAGE_PRICE = 2000;
    private final int SERVICE_DISH = 10;
    
    public int solution(int n, int k) {
        if (n >= SERVICE_DISH) {
            k -= checkServiceBeverage(n);
        }
        
        return (DISH_PRICE * n) + (BEVERAGE_PRICE * k);
    }
    
    private int checkServiceBeverage(int n) {
        int count = 0;
        
        n -= n % SERVICE_DISH;
        
        while (n != 0) {
            count++;
            n -= SERVICE_DISH;
        }

        return count;
    }
}
