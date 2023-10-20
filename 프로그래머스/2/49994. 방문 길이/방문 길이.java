import java.util.*;

class Solution {
    
    public int solution(String dirs) {
        boolean[][][] visited = new boolean[11][11][4];
        Map<Character, Integer> direction = new HashMap<>();
        int count = 0;
        
        // Map 초기화
        direction.put('U', 0);
        direction.put('D', 2);
        direction.put('R', 3);
        direction.put('L', 1);
        
        // 현재 위치
        int[] curr = {5, 5};
        
        // 방향 탐색
        for (int i = 0; i < dirs.length(); i++) {
            char command = dirs.charAt(i);
            int nextX = curr[0];
            int nextY = curr[1];
            
            switch (command) {
                case 'U':
                    nextX--;
                    break;
                case 'D':
                    nextX++;
                    break;
                case 'L':
                    nextY--;
                    break;
                case 'R':
                    nextY++;
                    break;
            }
            
            if (nextX < 0 || nextX > 10 || nextY < 0 || nextY > 10) {
                continue;
            }
            
            int d = direction.get(command);
            if (!visited[nextX][nextY][d]) {
                visited[nextX][nextY][d] = true;
                d = (d % 2 == 0) ? Math.abs(2 - d) : Math.abs(4 - d);
                visited[curr[0]][curr[1]][d] = true;
                count++;
            }
            curr[0] = nextX;
            curr[1] = nextY;
        }
        
        return count;
    }
}