import java.io.*;
import java.util.*;

public class Main {
    
    static final int[] MOVE_X = {-1, 1, 0, 0};
    static final int[] MOVE_Y = {0, 0, -1, 1};
    static final char[] MOVE = {'U', 'R', 'D', 'L'};
    static int m, n;
    static int[][] board;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        
        board = new int[n][m];
        
        input = br.readLine().split(" ");
        int[] curr = {
            Integer.parseInt(input[0]), // x
            Integer.parseInt(input[1]),  // y
            Integer.parseInt(input[2])  // 방향
        };
        
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        System.out.println(bfs(curr));
    }
    
    private static int bfs(int[] start) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        q.add(start);
        visited[start[0]][start[1]] = true;
        int count = 1;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            boolean isNeedClean = false;   // 청소할 공간이 있는가?
            
            // 4칸 중 빈 칸이 있는지 확인
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + MOVE_X[i];
                int ny = curr[1] + MOVE_Y[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == 1) continue;
                
                if (board[nx][ny] == 0 && !visited[nx][ny]) {
                    isNeedClean = true;
                    break;
                }
            }
            
            if (isNeedClean) {
                int nd = curr[2] == 0 ? 3 : curr[2] - 1;
                // 현재 칸 주변 4칸 중 청소가 필요한 칸이 있는 경우
                // 반시계 방향 회전
                for (int i = 0; i < 4; i++) {
                    int nx = curr[0], ny = curr[1];
                    // 앞으로 전진
                    switch (MOVE[nd]) {
                        case 'U':
                            nx = nx - 1;
                            break;
                        case 'D':
                            nx = nx + 1;
                            break;
                        case 'L':
                            ny = ny - 1;
                            break;
                        case 'R':
                            ny = ny + 1;
                            break;
                        default:
                            break;
                    }
                    
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    
                    // 앞에 청소 안된 경우 전진
                    if (board[nx][ny] == 0 && !visited[nx][ny]) {
                        q.add(new int[] {nx, ny, nd});
                        visited[nx][ny] = true;
                        count++;
                        break;
                    }
                    
                    nd = (nd == 0 ? 3 : nd - 1);   // 반시계 회전
                }
            } else {
                // 현재 칸 주변 4칸 중 청소되지 않은 빈칸이 없는 경우
                int nx = curr[0], ny = curr[1];
                
                // 후진
                switch (MOVE[curr[2]]) {
                    case 'U':
                        nx = nx + 1;
                        break;
                    case 'D':
                        nx = nx - 1;
                        break;
                    case 'L':
                        ny = ny + 1;
                        break;
                    case 'R':
                        ny = ny - 1;
                        break;
                    default:
                        break;
                }
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                
                // 후진 가능하면 후진한다.
                if (board[nx][ny] == 0) {
                    q.add(new int[] {nx, ny, curr[2]});
                } else {
                    return count;
                }
            }
        }
        
        return count;
    }
}