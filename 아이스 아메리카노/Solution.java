class Solution {
    private final int COFFEE_PRICE = 5500;
    private final int COUNT_INDEX = 0;
    private final int CHANGES_INDEX = 1;
    private final int ANSWERS_SIZE = 2;
    
    public int[] solution(int money) {
        int count = 0;
        int multipleNumber = 1;
        int[] answers = new int[ANSWERS_SIZE];
        
        while (COFFEE_PRICE * multipleNumber <= money) {
            count++;
            multipleNumber++;
        }
        
        answers[COUNT_INDEX] = count;
        answers[CHANGES_INDEX] = getChanges(count, money);
        
        
        return answers;
    }
    
    private int getChanges(int count, int money) {
        if (count != 0) {
            return money % (COFFEE_PRICE * count);  // 0으로 나누면 오류가 난다.
        } 
        
        return money;
    }
}
