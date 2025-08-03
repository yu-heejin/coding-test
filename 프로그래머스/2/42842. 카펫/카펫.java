class Solution {
    // 가로 길이, 세로 길이 모두 자연수
    // yellow = x * y
    // brown = (x + 2) * (y + 2) - (x * y)
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int y = 1; y <= yellow; y++) {
            // 나누어 떨어지는 경우, 약수이다.
            if (yellow % y == 0) {
                // x = yellow / y
                int x = yellow / y;
                
                if (2 * x + 2 * y + 4 == brown) {
                    answer[0] = y + 2;
                    answer[1] = x + 2;
                }
            }
        }
        
        return answer;
    }
}