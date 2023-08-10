import java.util.*;

class Solution {
    
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> inform = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            inform.put(want[i], number[i]);
        }
        
        // 10일 연속 일치 여부 확인
        // 할인 횟수가 같아야한다.
        int answer = 0;
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> counts = new HashMap<>();
            for (int j = 0; j < want.length; j++) {
                counts.put(want[j], 0);
            }
            
            for (int j = i; j < i + 10; j++) {
                if (counts.containsKey(discount[j])) {
                    counts.put(discount[j], counts.get(discount[j]) + 1);
                }
            }
            
            boolean isMatch = true;
            
            for (String key : counts.keySet()) {
                int count = counts.get(key);
                int infoCount = inform.get(key);
                
                if (count != infoCount) {
                    isMatch = false;
                    break;
                }
            }
            
            if (isMatch) {
                answer++;
            }
        }
        
        return answer;
    }
}