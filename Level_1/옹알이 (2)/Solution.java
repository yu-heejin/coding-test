class Solution {
    private String[] CAN_SAY_WORDS = { "aya", "ye", "woo", "ma" };
    private String[] CAN_SAY_WORDS_NUMBERS = { "1", "2", "3", "4" };
    
    public int solution(String[] babbling) {
        int count = 0;
        
        for (int i = 0; i < babbling.length; i++) {
            for (int j = 0; j < CAN_SAY_WORDS.length; j++) {
                babbling[i] = babbling[i].replace(CAN_SAY_WORDS[j], CAN_SAY_WORDS_NUMBERS[j]);
            }
            
            if (babbling[i].matches("^[0-9]*$") && !isContinuous(babbling[i])) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isContinuous(String babbling) {
        if (babbling.contains("11") || babbling.contains("22") || babbling.contains("33") || babbling.contains("44")) {
            return true;
        }
        
        return false;
    }
}
