import java.util.*;

class Solution {
    private Map<Character, Integer> keyCount;
    
    public int[] solution(String[] keymap, String[] targets) {
        keyCount = new HashMap<>();
        
        // 키맵에서 각 알파벳을 누를 때의 최소값을 저장한다.
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char key = keymap[i].charAt(j);
                int count = keyCount.getOrDefault(key, 101);
                
                if ((j + 1) < count) {
                    keyCount.put(key, j + 1);
                }
            }
        }
        
        // target 구하기
        int[] result = new int[targets.length];
        
        Arrays.fill(result, 0);
        
        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                char key = targets[i].charAt(j);
                
                if (keyCount.containsKey(key)) {
                    result[i] += keyCount.get(key);
                } else {
                    // 단, 목표 문자열을 작성할 수 없을 때는 -1을 저장한다.
                    // 즉, 하나라도 없는 문자가 나오는 경우 작성할 수 없다고 판단하여 중단
                    result[i] = -1;
                    break;
                }
            }
        }
        
        return result;
    }
}