import java.io.*;
import java.util.*;

class Solution {
    private static int min = Integer.MAX_VALUE;
    private static int[] moveX= {-1, 1, 0, 0};
    private static int[] moveY = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            
            int[][] road = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    road[i][j] = Integer.parseInt(input[j]);
                }
            }
            
            // 세로, 가로, 그때의 합
            int[] current = {0, 0, 0};
            bfs(current, N, road);
            System.out.println("#" + t + " " + min);
            min = Integer.MAX_VALUE;
        }
    }
    
    private static void bfs(int[] current, int N, int[][] road) {
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        boolean[][] visited = new boolean[N][N];
        
        visited[current[0]][current[1]] = true;
        q.add(current);
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            if (curr[0] == N - 1 && curr[1] == N - 1) {
                min = Math.min(min, curr[2]);
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + moveX[i];
                int ny = curr[1] + moveY[i];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny, curr[2] + road[nx][ny]});
                }
            }
        }
	}
}