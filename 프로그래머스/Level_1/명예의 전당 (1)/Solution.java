import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Solution {
    private final int BASIC_MIN_INDEX = 0;
    
    private int[] lowestRanks;
    private List<Integer> hallOfFame;
    private int minScore;
    private int minIndex;
    
    public int[] solution(int k, int[] score) {
        lowestRanks = new int[score.length];
        hallOfFame = new ArrayList<>();
        minScore = Integer.MAX_VALUE;
        
        for (int i = 0; i < score.length; i++) {
            if (hallOfFame.size() < k) {
                hallOfFame.add(score[i]);
                findMinScore(score, i);
            } else if (hallOfFame.get(minIndex) < score[i]) {
                hallOfFame.set(minIndex, score[i]);
                findMinScoreAndSortHallOfFame();
            }
            
            lowestRanks[i] = minScore;
        }
        
        return lowestRanks;
    }
    
    private void findMinScore(int[] score, int index) {
        if (minScore > score[index]) {
            minScore = score[index];
            minIndex = index;
        }
    }
    
    private void findMinScoreAndSortHallOfFame() {
        Collections.sort(hallOfFame);
        minScore = hallOfFame.get(BASIC_MIN_INDEX);
        minIndex = BASIC_MIN_INDEX;
    }
}
