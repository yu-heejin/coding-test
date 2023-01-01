class Solution {
    private final double DISCOUNT5 = 0.95;
    private final double DISCOUNT10 = 0.9;
    private final double DISCOUNT20 = 0.8;
    private final int DISCOUNT5_PRICE = 100000;
    private final int DISCOUNT10_PRICE = 300000;
    private final int DISCOUNT20_PRICE = 500000;
    
    public int solution(int price) {
        return getTotalPrice(price);
    }
    
    private int getTotalPrice(int price) {
        if (price >= DISCOUNT20_PRICE) {
            return (int) (price * DISCOUNT20);
        } 
        
        if (price >= DISCOUNT10_PRICE) {
            return (int) (price * DISCOUNT10);
        }
        
        if (price >= DISCOUNT5_PRICE) {
            return (int) (price * DISCOUNT5);
        } 
        
        return price;
    }
}
