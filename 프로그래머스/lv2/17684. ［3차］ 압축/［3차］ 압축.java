import java.util.*;

public class Solution {
    
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        // 1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
        char alphabet = 'A';
        int count = 1;
        while (alphabet <= 'Z') {
            dictionary.put(String.valueOf(alphabet), count);
            alphabet++;
            count++;
        }
        count = 26;
        
        // 문자 처리
        while (msg.length() > 0) {
            String temp = msg;
            // 1. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
            while (temp.length() > 0) {
                if (dictionary.containsKey(temp)) {
                    break;
                }
                temp = temp.substring(0, temp.length() - 1);
            }
            
            // 2. w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
            answer.add(dictionary.get(temp));
        
            // 3. 다음 글자가 남아있다면 w+c에 해당하는 단어를 사전에 등록한다.
            if (msg.length() > 1) {
                int startIdx = msg.indexOf(temp);
                int endIdx = startIdx + temp.length();
                String next;
                if (endIdx + 1 > msg.length() - 1) {
                    next = msg.substring(startIdx, endIdx);
                } else {
                    next = msg.substring(startIdx, endIdx + 1);
                }
                
                if (!dictionary.containsKey(next)) {
                    dictionary.put(next, ++count);
                }
                msg = msg.substring(endIdx);
            } else {
                msg = "";
            }
        }
        
        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}