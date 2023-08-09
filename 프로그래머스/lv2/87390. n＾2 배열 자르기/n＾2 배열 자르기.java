class Solution {
    /*
        (0,0) (0,1) (0,2)
        (1,0) (1,1) (1,2)
        (2,0) (2,1) (2,2)
        
        배열의 요소는 x와 y중 큰 값이 된다.
        n X n 배열일 때, ( i / n ) + 1 은 행의 값이 되고 ( i % n ) + 1 은 열의 값이 된다
    */
    public int[] solution(int n, long left, long right) {
        int x, y;
        int[] answer = new int[(int) (right - left) + 1];
        int index = 0;
        
        for (long i = left; i <= right; i++) {
            x = (int) (i / n) + 1;
            y = (int) (i % n) + 1;
            
            answer[index] = Math.max(x, y);
            index++;
        }
        
        return answer;
    }
}