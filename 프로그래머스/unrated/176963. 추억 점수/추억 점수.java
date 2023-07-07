import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] scores = new int[photo.length];
        int scoresIndex = 0;
        Map<String, Integer> yearningPerPerson = new HashMap<>();
        
        for (int i = 0; i < name.length; i++) {
            yearningPerPerson.put(name[i], yearning[i]);
        }
        
        Arrays.fill(scores, 0);
        
        for (String[] p : photo) {
            for (String person : p) {
                scores[scoresIndex] += yearningPerPerson.getOrDefault(person, 0);
            }
            scoresIndex++;
        }
        
        return scores;
    }
}