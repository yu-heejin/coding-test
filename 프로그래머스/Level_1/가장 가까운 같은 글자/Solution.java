class Solution {
    private final int NOT_FOUND = -1;
    
    public int[] solution(String s) {
        String temp  = "";
        String[] stringsBySplit = s.split("");
        int[] answers = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            answers[i] = getSearchResult(temp, stringsBySplit, i);
            temp += stringsBySplit[i];
        }
        
        return answers;
    }
    
    private int getSearchResult(String temp, String[] stringsBySplit, int index) {
        if (!temp.contains(stringsBySplit[index])) {
            return NOT_FOUND;
        } 
        
        return index - temp.lastIndexOf(stringsBySplit[index]);
    }
}
