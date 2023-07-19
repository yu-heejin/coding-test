class Solution {
    
    private final String regex = "[0-9]+";
    
    public boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6) {
            if (s.matches(regex)) {
                return true;
            }
            
            return false;
        }
        
        return false;
    }
}