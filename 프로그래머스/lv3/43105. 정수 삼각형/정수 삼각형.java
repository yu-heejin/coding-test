class Solution {
    
    public int solution(int[][] triangle) {
        int max = -1;
        
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    // 왼쪽만 더해준다.
                    triangle[i][j] += triangle[i - 1][j];
                } else if (j == triangle[i].length - 1) {
                    // 오른쪽만 더해준다.
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
                
                if (max < triangle[i][j]) {
                    max = triangle[i][j];
                }
            }
        }
        
        return max;
    }
}