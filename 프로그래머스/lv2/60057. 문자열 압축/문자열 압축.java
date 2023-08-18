import java.util.*;

class Solution {
    
    public int solution(String s) {
        int min = s.length();
        
        if (s.length() == 1) {
            return 1;
        }
        
        for (int i = 1; i <= s.length() / 2; i++) {
            String start = s.substring(0, i);
            int count = 1;
            StringBuilder sb = new StringBuilder();
            
            for (int j = i; j <= s.length() - i; j += i) {
                String curr = s.substring(j, j + i);
                if (start.equals(curr)) {
                    count++;
                } else {
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(start);
                    start = curr;
                    count = 1;
                }
            }
            
            if (count > 1) {
                sb.append(count);
            }
            sb.append(start);
            
            // 문자열이 나누어 떨어지지 않는 경우 고려
            int div = s.length() % i;
            min = Math.min(min, sb.toString().length() + div);
        }
        
        return min; // 가장 작은 문자열 길이 저장
    }
}