class Solution {
    private final int GENERAL_ANT = 5;
    private final int SOLDIER_ANT = 3;
    private final int ERGATE = 1;
    private int count = 0;
   
    public int solution(int hp) {
        hp = getResultByGeneralAnt(hp);
        hp = getResultBySoldierAnt(hp);
        getResultByErgate(hp);
        
        return count;
    }
    
    private int getResultByGeneralAnt(int hp) {
        count += hp / GENERAL_ANT;
        hp %= GENERAL_ANT;
        
        return hp;
    }
    
    private int getResultBySoldierAnt(int hp) {
        count += hp / SOLDIER_ANT;
        hp %= SOLDIER_ANT;
        
        return hp;
    }
    
    private void getResultByErgate(int hp) {
        while (hp != 0) {
            hp--;
            count++;
        }
    }
}
