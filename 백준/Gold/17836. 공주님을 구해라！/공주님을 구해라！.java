import java.io.*;
import java.util.*;

public class Main {
    static final int[] MOVE_X = {-1, 1, 0, 0};
    static final int[] MOVE_Y = {0, 0, -1, 1};
    
    static int min = Integer.MAX_VALUE;
    static int[][] board;
    static int n, m, t;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        t = Integer.parseInt(input[2]);
        
        board = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        bfs();
        
        System.out.println(min == Integer.MAX_VALUE ? "Fail" : min);
    }
    
    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][2];    // 그람 없는 경우, 있는 경우 방문
        
        // 출발지점 삽입
        q.add(new int[] {0, 0, 0, 0});   // x, y, 시간, 검 보유 여부
        visited[0][0][0] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            if (curr[0] == n - 1 && curr[1] == m - 1 && curr[2] <= t) {
                min = Math.min(min, curr[2]);
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + MOVE_X[i];
                int ny = curr[1] + MOVE_Y[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 이미 방문한 곳이면 pass
                if (visited[nx][ny][curr[3]]) continue;
                // 검이 없는데 마법의 벽인 경우 Pass
                if (curr[3] == 0 && board[nx][ny] == 1) continue;
                
                // 검을 획득한 경우
                if (board[nx][ny] == 2) {
                    // curr[3] = 1;    // 검 획득
                    q.add(new int[] {nx, ny, curr[2] + 1, 1});
                    visited[nx][ny][1] = true;
                    board[nx][ny] = 0;
                } else {
                    q.add(new int[] {nx, ny, curr[2] + 1, curr[3]});
                    visited[nx][ny][curr[3]] = true;
                }
            }
        }
    }
}