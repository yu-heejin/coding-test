import java.io.*;
import java.util.*;

public class Main {
    
    static final int[] MOVE_X = {-1, 1, 0, 0};
    static final int[] MOVE_Y = {0, 0, -1, 1};
    static int n, m;
    static int max = 0;  // 그림이 하나도 없는 경우 가장 넓은 그림의 넓이는 0
    static boolean[][] visited;
    static int[][] board;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        
        board = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        int paintCount = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    paintCount++;
                }
            }
        }
        
        System.out.println(paintCount);
        System.out.println(max);
    }
    
    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[] {x, y});
        visited[x][y] = true;
        int area = 1;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + MOVE_X[i];
                int ny = curr[1] + MOVE_Y[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                
                if (!visited[nx][ny] && board[nx][ny] == 1) {
                    q.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    area++;
                }
            }
        }
        
        max = Math.max(area, max);
    }
}