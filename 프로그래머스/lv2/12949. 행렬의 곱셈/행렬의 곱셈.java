class Solution {
    // 행렬은 앞쪽의 열과 뒤쪽의 행이 같아야 곱할 수 있다.
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for (int i = 0; i < arr1.length; i++) {  // 열
            for (int j = 0; j < arr2[0].length; j++) {  // 행
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}