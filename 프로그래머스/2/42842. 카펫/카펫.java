class Solution {
    public int[] solution(int brown, int yellow) {
        int s = brown + yellow;   // 전체 면적
        int[] answer = new int[2];   // 카펫의 가로와 세로
        
        // 면적에 따른 가로, 세로 길이 찾기
        for (int width = s; width > 0; width--) {
            // 나누어 떨어지는 경우에만 넓이가 된다.
            if (s % width > 0) continue;
            
            int height = s / width;
            
            // 노란 카펫의 개수 (넓이)
            int tempYellow = (width - 2) * (height - 2);
            // 갈색의 개수 (넓이)
            int tempBrown = s - tempYellow;
            
            if (tempYellow == yellow && tempBrown == brown) {
                answer[0] = width;
                answer[1] = height;
                break;
            }
        }
        
        return answer;
    }
}