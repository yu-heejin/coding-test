class Solution {
    // h - 인덱스 는 주어진 저자/저널이 각각 '최소' h 번 인용된 '최소' h개의 논문을 출판한 h 의 '최대값'으로 정의됩니다 .
    public int solution(int[] citations) {
        int size = citations.length;
        int answer = 0;

        for (int h = 0; h <= size; h++) {
            int count = 0;
            
            for (int i = 0; i < size; i++) {
                if (citations[i] >= h) {
                    count++;
                }
            }
            
            if (count >= h) {
                answer = Math.max(answer, h);
            }
        }
        
        return answer;
    }
}