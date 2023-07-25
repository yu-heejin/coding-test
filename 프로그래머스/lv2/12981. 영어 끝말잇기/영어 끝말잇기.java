import java.util.*;

class Solution {
    private List<String> beforeWords;
    private List<int[]> people;
    
    public int[] solution(int n, String[] words) {
        beforeWords = new ArrayList<>();
        people = new ArrayList<>(); 
        
        // 참가자 및 순서 저장
        initPeople(n);
        
        // 끝말잇기 플레이
        int peopleIndex = 0;
        
        for (int i = 0; i < words.length; i++) {
            int[] person = people.get(peopleIndex);
                
            if (beforeWords.contains(words[i])) {
                return person;
            }
            
            if (i > 0) {
                char beforeChar = words[i - 1].charAt(words[i - 1].length() - 1);
            
                if (beforeChar != words[i].charAt(0)) {
                    return person;
                }
            }
            
            beforeWords.add(words[i]);
            person[1]++;
            
            peopleIndex = (peopleIndex + 1) % n;
        }
        
        return new int[] { 0, 0 };
    }
    
    private void initPeople(int n) {
        for (int i = 1; i <= n; i++) {
            people.add(new int[] { i, 1 });
        }
    }
}