import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 정렬
        Arrays.sort(phone_book);
        
        boolean answer = true;
        for (int i = 0; i < phone_book.length - 1; i++) {
            // 인접한 두 번호끼리 비교
            if (phone_book[i + 1].indexOf(phone_book[i]) == 0) {
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}