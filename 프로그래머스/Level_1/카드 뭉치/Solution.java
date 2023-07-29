class Solution {
    private final String YES = "Yes";
    private final String NO = "No";
    
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int count = 0;
        int cardIndex1 = 0;
        int cardIndex2 = 0;
        
        for (int i = 0; i < goal.length; i++) {
            if (goal[i].equals(cards1[cardIndex1 % cards1.length])) {
                count++;
                cardIndex1++;
            } else if (goal[i].equals(cards2[cardIndex2 % cards2.length])) {
                count++;
                cardIndex2++;
            }
        }
        
        if (count == goal.length) return YES;
        
        return NO;
    }
}
