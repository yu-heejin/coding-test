import java.util.*;

// 참고 링크: https://kimwoolina.tistory.com/35
// https://st-lab.tistory.com/118
class Solution {
    int answer = 0;
    
    public int solution(int n) {
        /**
            visited 의 인덱스는 행, 값은 열을 나타낸다.
            퀸을 (1, 3)에 놓은 경우, visited[1] = 3 으로 표현하겠다는 것.
            (어차피 퀸들을 같은 행, 열에 둘 수 없으므로 이렇게 1차원 배열로도 표현할 수 있다.)

            예시) n=4 이고 visited = [1, 3, 0, 2] 인 경우,
            체스판을 그려보면 아래와 같다. (1이 퀸)
            0 1 0 0
            0 0 0 1
            1 0 0 0
            0 0 1 0
    **/
        int[] board = new int[n];   // 한 행에 하나만 놓는다는 전제조건
        // n x n 보드에 n개의 퀸을 놓아야 하므로 적어도 하나의 행에 하나의 퀸이 있다.
        backtracking(0, n, board);
        
        return answer;
    }
    
    private boolean isPossible(int[] board, int depth) {
        // 앞에 놨었던 행까지만 검사해야한다.
        for (int i = 0; i < depth; i++) {
            // 같은 열에 퀸이 있는지?
            if (board[i] == board[depth]) {
                return false;
            }
            
            // 대각선에 퀸이 있는 경우
            if (Math.abs(depth - i) == Math.abs(board[depth] - board[i])) {
                return false;
            }
        }
        
        return true;
    }
    
    private void backtracking(int depth, int n, int[] board) {
        if (depth == n) {
            // 모든 퀸을 다 놓았다면 가지수 증가
            answer++;
            return;
        }
        
        // depth행의 i열에 퀸을 놓는 경우
        for (int i = 0; i < n; i++) {
            board[depth] = i;
            
            if (isPossible(board, depth)) {
                // 가능하면 다음 단계로 이동, 아니면 다음열에 둔다
                backtracking(depth + 1, n, board);
            }
        }
    }
}