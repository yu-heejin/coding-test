import java.util.TreeMap;

class Solution {
    private final int NEGATIVE_INDEX = 0;
    private final int POSITIVE_INDEX = 1;
    private TreeMap<String, Integer> scores;
    
    public String solution(String[] survey, int[] choices) {
        scores = new TreeMap<>();
        
        for (int i = 0; i < survey.length; i++) {
            String[] types = survey[i].split("");
            
            if (choices[i] >= 1 && choices[i] <= 3) {
                updateNegativeScore(types[NEGATIVE_INDEX], (4 - choices[i]));
            } 
            
            if (choices[i] >= 5 && choices[i] <= 7) {
                updatePositiveScore(types[POSITIVE_INDEX], (choices[i] - 4));
            }
        }
        
        return getResult();
    }
    
    private void updateNegativeScore(String key, int score) {
        if (scores.containsKey(key)) {
            updateScore(key, score);
            return;
        } 
        
        scores.put(key, score);
    }
    
    private void updatePositiveScore(String key, int score) {
        if (scores.containsKey(key)) {
            updateScore(key, score);
            return;
        }
        
        scores.put(key, score);
    }
    
    private void updateScore(String searchKey, int score) {
        scores.put(searchKey, scores.get(searchKey) + score);
    }
    
    private String getResult() {
        /* code reference from: https://velog.io/@jp-share/%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%84%B1%EA%B2%A9-%EC%9C%A0%ED%98%95-%EA%B2%80%EC%82%AC%ED%95%98%EA%B8%B0 */
        StringBuilder builder = new StringBuilder();
        
        builder.append(scores.getOrDefault("R", 0) >= scores.getOrDefault("T", 0) ? "R" : "T");
        builder.append(scores.getOrDefault("C", 0) >= scores.getOrDefault("F", 0) ? "C" : "F");
        builder.append(scores.getOrDefault("J", 0) >= scores.getOrDefault("M", 0) ? "J" : "M");
        builder.append(scores.getOrDefault("A", 0) >= scores.getOrDefault("N", 0) ? "A" : "N");
        
        return builder.toString();
    }
}
