import java.util.*;

class Solution {
    
    // 1. 문자열은 두 글자씩 끊어야한다.
    // 2. 특수문자는 제거한다.
    // 3. 합집합은 max, 교집합은 min
    public int solution(String str1, String str2) {
        if (str1.length() == 0 && str2.length() == 0) {
            return 65536;
        }
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        if (str1.equals(str2)) {
            return 65536;
        }
        
        List<String> split1Result = new ArrayList<>();
        List<String> split2Result = new ArrayList<>();
        
        for (int i = 0; i < str1.length() - 1; i++) {
            if (str1.substring(i, i + 2).matches("[a-zA-Z]+")) {
                split1Result.add(str1.substring(i, i + 2));
            }
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            if (str2.substring(i, i + 2).matches("[a-zA-Z]+")) {
                split2Result.add(str2.substring(i, i + 2));
            }
        }
        
        // 다중집합의 교집합과 합집합
        List<String> union = new ArrayList<>();
        List<String> intersection = new ArrayList<>();
        
        Collections.sort(split1Result);
        Collections.sort(split2Result);

        // 합집합
        // 두 중복되는 요소를 삭제하고 교집합에 넣는다.
        // 모든 요소를 합집합에 넣는다.
        for(String s : split1Result) {
            if(split2Result.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }

        // 교집합
        // 삭제된 요소를 제외하고 합집합에 넣는다. (교집합 제외)
        for(String s : split2Result) {
            union.add(s);
        }
        
        return (int)(((double) intersection.size() / union.size()) * 65536);
    }
}