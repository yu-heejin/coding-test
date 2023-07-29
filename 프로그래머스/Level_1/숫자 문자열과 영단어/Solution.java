import java.util.HashMap;

class Solution {
    private final int MIN_NUMBER = 0;
    private final int MAX_NUMBER = 9;
    private HashMap<Integer, String> numberAndWord;
    
    public int solution(String s) {
        addNumberAndWord();

        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            String numberForChange = i + "";
            s = s.replace(numberAndWord.get(i), numberForChange);
        }
        
        return Integer.parseInt(s);
    }
    
    private void addNumberAndWord() {
        numberAndWord = new HashMap<>();
        
        numberAndWord.put(0, "zero");
        numberAndWord.put(1, "one");
        numberAndWord.put(2, "two");
        numberAndWord.put(3, "three");
        numberAndWord.put(4, "four");
        numberAndWord.put(5, "five");
        numberAndWord.put(6, "six");
        numberAndWord.put(7, "seven");
        numberAndWord.put(8, "eight");
        numberAndWord.put(9, "nine");
    }
}
