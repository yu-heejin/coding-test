class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 카펫의 면적은 brown과 yellow를 합친 값
        // width x height = brown + yellow
        // 이 경우 width, height는 총 합의 약수이다.
        int carpetArea = brown + yellow;
        
        // yellow의 배치 현황(개수)은 (width - 2) * (height * 2)
        // 카펫의 가로 길이 >= 세로 길이
        // 노란색이 1이라 가정할 때, 가로와 세로의 길이는 3 이상이어야한다.
        for (int i = 3; i <= carpetArea; i++) {
            if (carpetArea % i == 0 && carpetArea / i >= 3) {
                int row = Math.max(i, carpetArea / i);
                int col = Math.min(i, carpetArea / i);
                int yellowArea = (row - 2) * (col - 2);
                
                if (yellowArea == yellow) {
                    answer[0] = row;
                    answer[1] = col;
                    break;
                }
            }
        }
        
        return answer;
    }
}