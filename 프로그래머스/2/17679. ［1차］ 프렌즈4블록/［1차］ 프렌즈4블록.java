import java.util.*;

class Solution {
    
    boolean[][] visited;
    char[][] initBoard;
    
    public int solution(int m, int n, String[] board) {
        visited = new boolean[m][n];
        initBoard = new char[m][n];
        int answer = 0;
        
        for (int i = 0; i < m; i++) {
            char[] input = board[i].toCharArray();
            for (int j = 0; j < n; j++) {
                initBoard[i][j] = input[j];
            }
        }
        
        while (true) {
            // 사라질 블록을 체크한다.
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (initBoard[i][j] != 'X' &&
                        initBoard[i][j] == initBoard[i][j + 1] &&
                        initBoard[i][j] == initBoard[i + 1][j + 1] &&
                        initBoard[i][j] == initBoard[i + 1][j]
                    ) {
                        visited[i][j] = true;
                        visited[i][j + 1] = true;
                        visited[i + 1][j] = true;
                        visited[i + 1][j + 1] = true;
                    }
                }
            }
            
            // 사라질 블록이 없는 경우 break
            if (canStop(m, n)) break;
            
            // 사라질 블록의 개수를 체크
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) {
                        answer++;
                        initBoard[i][j] = 'X';
                    }
                }
            }
            
            // 블록을 밑으로 내린다.
            for (int i = m - 1; i > 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (initBoard[i][j] == 'X') {
                        int upIndex = i - 1;
                        while (upIndex > 0 && initBoard[upIndex][j] == 'X') upIndex--;
                        if (upIndex >= 0 && initBoard[upIndex][j] != 'X') {
                            initBoard[i][j] = initBoard[upIndex][j];
                            initBoard[upIndex][j] = 'X';
                        }
                    }
                }
            }
            
            // visited 배열 초기화
            for (int i = 0; i < m; i++) {
                Arrays.fill(visited[i], false);
            }
        }
        
        return answer;
    }
    
    private boolean canStop(int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) return false;
            }
        }
        
        return true;
    }
}