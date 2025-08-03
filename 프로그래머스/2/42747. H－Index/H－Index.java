import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // 최댓값 기준으로 정렬
        // primitive type은 내림차순이 안돼서 오름차순으로 정렬 후 거꾸로 탐색
        Arrays.sort(citations);

        // 가장 큰 수 저장
        int answer = 0;
        int hIndex = citations[citations.length - 1];
        
        while (hIndex >= 0) {
            int count = 0;
            
            for (int j = citations.length - 1; j >= 0; j--) {
                if (citations[j] >= hIndex) {
                    count++;
                } else {
                    // 정렬된 상태이므로 멈춤
                    break;
                }
            }
            
            if (count >= hIndex) {
                answer = Math.max(answer, hIndex);
            }
            
            hIndex--;
        }
        
        return answer;
    }
}