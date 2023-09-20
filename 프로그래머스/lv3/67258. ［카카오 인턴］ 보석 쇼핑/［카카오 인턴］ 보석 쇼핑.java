import java.util.*;

class Solution {
    
    // 효율성 문제는 O(n)의 효율성을 보여야한다.
    public int[] solution(String[] gems) {
        // 1. 보석 종류 저장하기
        Set<String> gemCategory = new HashSet<>();
        for (int i = 0; i < gems.length; i++) {
            gemCategory.add(gems[i]);
        }
        
        int[] minSection = { 1, gems.length };
        Map<String, Integer> map = new HashMap<>();
        int start = 0;   // 시작 번호 고정
        int distance = minSection[1] - minSection[0];
        
        for (int end = 0; end < gems.length; end++) {
            // 구간별 보석 개수 카운트
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            
            // 만약 '시작' 위치에서 넣은 보석의 수가 1보다 많다면 (중복 보석)
            while (map.get(gems[start]) > 1) {
                // 시작 지점을 뒤로 땡기고 보석의 수를 1 감소한다.
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }
            
            // 보석을 모두 담았고 현재 구간의 거리가 더 작은 경우
            if (map.size() == gemCategory.size() && distance > ((end+1) - (start+1))) {
                distance = (end + 1) - (start + 1);
                minSection[0] = start + 1;
                minSection[1] = end + 1;
            }
        }
        
        return minSection;
    }
}