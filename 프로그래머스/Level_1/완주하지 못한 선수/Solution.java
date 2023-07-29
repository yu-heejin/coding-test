import java.util.Map;
import java.util.HashMap;

class Solution {
    private final int DEFAULT_VALUE = 0;
    private Map<String, Integer> participantCount;
    private Map<String, Integer> completionCount;
    
    public String solution(String[] participant, String[] completion) {
        participantCount = new HashMap<>();
        completionCount = new HashMap<>();
        
        initParticipantCount(participant);
        initCompletionCount(completion);
        
        return getAnswer(participant);
    }
    
    private void initParticipantCount(String[] participant) {
        for (int i = 0; i < participant.length; i++) {
            participantCount.put(participant[i], participantCount.getOrDefault(participant[i], DEFAULT_VALUE) + 1);
        }
    }
    
    private void initCompletionCount(String[] completion) {
        for (int i = 0; i < completion.length; i++) {
            completionCount.put(completion[i], completionCount.getOrDefault(completion[i], DEFAULT_VALUE) + 1);
        }
    }
    
    private String getAnswer(String[] participant) {
        for (int i = 0; i < participant.length; i++) {
            if (completionCount.containsKey(participant[i])) {
                if (participantCount.get(participant[i]) > completionCount.get(participant[i])) {
                    return participant[i];
                }
            } else {
                return participant[i];
            }
        }
        
        return "";
    }
}
