import java.util.*;

class Solution {
    
    int[][] visited;
    int[] moveX = {0, 0, -1, 1};
    int[] moveY = {-1, 1, 0, 0};
    
    public int solution(int[][] maps) {
        visited = new int[maps.length][maps[0].length];
        
        bfs(maps);
        return visited[maps.length - 1][maps[0].length - 1] == 0
            ? -1
            : visited[maps.length - 1][maps[0].length - 1];
    }
    
    private void bfs(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = 1;
        q.add(new int[] {0, 0});
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = curr[0] + moveX[i];
                int nextY = curr[1] + moveY[i];
                
                if (nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps[0].length) {
                    continue;
                }
            
                if (visited[nextX][nextY] == 0 && maps[nextX][nextY] == 1) {
                    visited[nextX][nextY] = visited[curr[0]][curr[1]] + 1;
                    q.add(new int[] {nextX, nextY});
                }
            }
        }
        
    }
}