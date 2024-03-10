import java.io.*;
import java.util.*;

public class Main {
    
    static final int[] MOVE_X = { -1, 1, 0, 0 };
    static final int[] MOVE_Y = { 0, 0, -1, 1 };
    static int n, m;
    static int[][] board;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        
        if (n == 1 && m == 1) {
            System.out.println(1);
        } else {
            board = new int[n][m];
            
            for (int i = 0; i < n; i++) {
                input = br.readLine().split("");
                for (int j = 0; j < m; j++) {
                    board[i][j] = Integer.parseInt(input[j]);
                }
            }
            
            int answer = bfs();
            System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        }
    }
    
    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        
        // dist[][][0] : 벽을 부수지 않은 최단 거리
        // dist[][][1] : 벽을 부순 경우 최단 거리
        // 벽을 한 번도 안 뚫은 경우는 0, 한번이라도 뚫으면 1
        int[][][] dist = new int[n][m][2];     // 최단 경로를 저장할 배열(벽을 부순 경우와 부수지 않은 경우)
        int isBreak = 0;
        
        // 시작점 (x, y, 이전에 벽을 부쉈는지 확인 - 처음 시작시에는 이전에 벽을 부순적이 없음)
        q.add(new int[] {0, 0, 0});
        dist[0][0][0] = 1;
        // 최소값을 구하기 위한 초기 설정
        dist[n-1][m-1][0] = Integer.MAX_VALUE;
        dist[n-1][m-1][1] = Integer.MAX_VALUE;
        
        while (!q.isEmpty()) {
            // 현재 위치
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            isBreak = curr[2];
            
            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + MOVE_X[i];
                int ny = y + MOVE_Y[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                
                // 다음 위치가 목적지인 경우 최소값을 저장한다.
                if (nx == n - 1 && ny == m - 1) {
                    // 마지막 칸도 세어줘야한다.
                    dist[nx][ny][isBreak] = Math.min(dist[x][y][isBreak] + 1, dist[nx][ny][isBreak]);
                    continue;
                }
                
                // bfs: 갈 수 있는 경우에만 큐에 넣어야한다.
                if (board[nx][ny] == 0) {
                    // 인접한 곳이 지나갈 수 있는 경우 (벽이 아닌 경우)
                    if (isBreak == 0 && dist[nx][ny][0] == 0) {
                        // 이전에 벽을 부순적이 없고, 해당 공간을 지난적이 없는 경우
                        q.add(new int[] {nx, ny, 0});
                        dist[nx][ny][0] += dist[x][y][0] + 1;
                    } else if (isBreak == 1 && dist[nx][ny][1] == 0) {
                        // 이전에 벽을 부순적이 있고, 해당 공간을 지난적이 없는 경우
                        q.add(new int[] {nx, ny, 1});
                        dist[nx][ny][1] += dist[x][y][1] + 1;
                    }
                    
                } else {
                    // 인접한 곳이 지나갈 수 없는 경우 (벽인 경우)
                    // 기존에 벽을 부수지 않은 경우에만 지나갈 수 있음
                    if (isBreak == 0) {
                        q.add(new int[] {nx, ny, 1});
                        dist[nx][ny][1] += dist[x][y][0] + 1;
                    }
                }
            }
        }
        
        return dist[n-1][m-1][isBreak];
    }
}