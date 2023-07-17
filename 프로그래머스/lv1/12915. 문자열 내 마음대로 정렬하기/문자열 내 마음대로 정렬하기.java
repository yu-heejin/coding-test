import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        // 해당 인덱스 글자를 맨 앞에 붙인 후 정렬한다.
        for (int i = 0; i < strings.length; i++) {
            char index = strings[i].charAt(n);
            strings[i] = index + strings[i];
        }
        
        Arrays.sort(strings);
        
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].substring(1);
        }
        
        return strings;
    }
}