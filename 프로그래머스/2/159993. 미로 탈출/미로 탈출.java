import java.util.*;

class Solution {
    private int[] MOVE_X = {-1, 1, 0, 0};
    private int[] MOVE_Y = {0, 0, -1, 1};
    
    public int solution(String[] maps) {
        char[][] splitMaps = new char[maps.length][maps[0].length()];
        int[] lever = new int[2];
        int[] exit = new int[2];
        int[] start = new int[2];
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                splitMaps[i][j] = maps[i].charAt(j);
                
                if (splitMaps[i][j] == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }
                
                if (splitMaps[i][j] == 'E') {
                    exit[0] = i;
                    exit[1] = j;
                }
                
                if (splitMaps[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        
        // 시작 지점에서 레버로 이동 && 레버에서 출구로 이동, 모든 공간은 여러번 지날 수 있다.
        int first = bfs(splitMaps, new boolean[maps.length][maps[0].length()], start, lever);
        
        if (first == -1) {
            return -1;
        }
        
        int second = bfs(splitMaps, new boolean[maps.length][maps[0].length()], lever, exit);
        
        if (second == -1) {
            return -1;
        }
        
        return first + second;
    }
    
    // 최단 거리를 구한다 - bfs
    private int bfs(char[][] maps, boolean[][] visited, int[] start, int[] goal) {
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[] {start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            if (curr[0] == goal[0] && curr[1] == goal[1]) {
                return curr[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + MOVE_X[i];
                int ny = curr[1] + MOVE_Y[i];
                
                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) {
                    continue;
                }
                
                if (!visited[nx][ny] && maps[nx][ny] != 'X') {
                    q.add(new int[] {nx, ny, curr[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
}