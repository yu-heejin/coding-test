import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> idAndNickname = new HashMap<>();
        List<String> answer = new ArrayList<>();
        
        for (int i = 0; i < record.length; i++) {
            String[] token = record[i].split(" ");
            if (token[0].equals("Enter") || token[0].equals("Change")) {
                idAndNickname.put(token[1], token[2]);
            }
        }
        
        for (int i = 0; i < record.length; i++) {
            String[] token = record[i].split(" ");
            if (token[0].equals("Enter")) {
                String nickname = idAndNickname.get(token[1]);
                answer.add(nickname + "님이 들어왔습니다.");
            }
            
            if (token[0].equals("Leave")) {
                String nickname = idAndNickname.get(token[1]);
                answer.add(nickname + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}