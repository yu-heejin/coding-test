/* code reference from: https://day-log.tistory.com/29 */
class Solution {
    private final int ALPHABET_START = 97;
    private final int ALPHABET_END = 122;
    
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char result = getResult(s.charAt(i), skip, index);
            answer.append(String.valueOf(result));
        }
        
        return answer.toString();
    }
    
    private char getResult(char startAlphabet, String skip, int index) {
        for (int j = 1; j <= index; j++) {
            startAlphabet++;
            
            if (startAlphabet > ALPHABET_END) {
                startAlphabet = (char) ALPHABET_START;
            }
            
            while (skip.contains(String.valueOf(startAlphabet))) {
                startAlphabet++;
                if (startAlphabet > ALPHABET_END) {
                    startAlphabet = (char) ALPHABET_START;
                }
            }
        }
        
        return startAlphabet;
    }
}
