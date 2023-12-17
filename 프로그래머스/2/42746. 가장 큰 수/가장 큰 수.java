import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] numberToString = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            numberToString[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(numberToString, (o1, o2) -> {
            long result1 = Long.parseLong(o1 + o2);
            long result2 = Long.parseLong(o2 + o1);
            
            if (result1 > result2) {
                return -1;    
            } else if (result2 > result1) {
                return 1;
            }
            
            return 0;  // 이 부분 없으면 런타임 에러
        });
        
        StringBuilder sb = new StringBuilder();
        for (String n : numberToString) {
            sb.append(n);
        }
        
        if (sb.toString().charAt(0) == '0') return "0";

        // return String.valueOf(Long.parseLong(sb.toString()));    // 해당 부분은 숫자가 Long 범위를 넘어가는 경우 에러가 발생할 수 있음
        return sb.toString();
    }
}
