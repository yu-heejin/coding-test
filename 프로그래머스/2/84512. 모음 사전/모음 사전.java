class Solution {
    char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    int answer = 0;
    int index = 0;
    
    public int solution(String word) {
        dfs(new StringBuilder(), word);
        
        return answer;
    }
    
    private void dfs(StringBuilder s, String word) {
        if (s.length() > 5) return;
        
        if (s.length() > 0) index++;
        

        if (s.toString().equals(word)) {
            answer = index;
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            s.append(alphabet[i]);
            dfs(s, word);
            s.deleteCharAt(s.length() - 1);
        }
    }
}