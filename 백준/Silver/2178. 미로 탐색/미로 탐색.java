import java.util.*;
import java.io.*;

public class Main {
    
    // 상하좌우로 움직이기 위한 상수
    static final int[] MOVE_X = { -1, 1, 0, 0 };
    static final int[] MOVE_Y = { 0, 0, -1, 1 };
    static int n, m;
    static int[][] board;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        
        board = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        System.out.println(bfs());
    }
    
    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        
        // 출발 지점 insert
        q.offer(new int[] {0, 0});
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + MOVE_X[i];
                int ny = curr[1] + MOVE_Y[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                
                if (board[nx][ny] == 1) {
                    q.offer(new int[] {nx, ny});
                    board[nx][ny] = board[curr[0]][curr[1]] + 1;
                }
            }
        }
        
        return board[n - 1][m - 1];
    }
}