import java.util.*;

class Solution {
    private int[] MOVE_X = {-1, 1, 0, 0};
    private int[] MOVE_Y = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        char[][] splitMaps = new char[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        List<Integer> results = new ArrayList<>();
        
        for (int i = 0; i < splitMaps.length; i++) {
            for (int j = 0; j < splitMaps[i].length; j++) {
                splitMaps[i][j] = maps[i].charAt(j);
            }
        }
        
        for (int i = 0; i < splitMaps.length; i++) {
            for (int j = 0; j < splitMaps[i].length; j++) {
                if (!visited[i][j] && splitMaps[i][j] != 'X') {
                    results.add(bfs(new int[] {i, j}, splitMaps, visited));
                }
            }
        }
        
        if (results.size() == 0) {
            return new int[] {-1};
        }
        
        return results.stream()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    // 상하좌우로 인접한 섬의 합을 구하기 위해 BFS를 사용한다.
    private int bfs(int[] start, char[][] maps, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        int sum = 0;
        
        q.add(new int[] {start[0], start[1]});
        visited[start[0]][start[1]] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            sum += maps[curr[0]][curr[1]] - '0';
            
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + MOVE_X[i];
                int ny = curr[1] + MOVE_Y[i];
                
                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) {
                    continue;
                }
                
                if (maps[nx][ny] == 'X') {
                    continue;
                }
                
                if (!visited[nx][ny]) {
                    q.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return sum;
    }
}