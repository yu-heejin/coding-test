import java.io.*;
import java.util.*;

public class Main {
    
    static final int[] MOVE_X = {-1, 1, 0, 0};
    static final int[] MOVE_Y = {0, 0, -1, 1};
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        
        String[][] board = new String[r][c];
        
        int[] jihun = new int[2];
        List<int[]> fires = new ArrayList<>();
        
        for (int i = 0; i < r; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                board[i][j] = input[j];
                
                if (board[i][j].equals("J")) {
                    jihun[0] = i;
                    jihun[1] = j;
                } else if (board[i][j].equals("F")) {
                    int[] f = new int[2];
                    f[0] = i;
                    f[1] = j;
                    fires.add(f);
                }
            }
        }
        
        int[][] fireTime = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                fireTime[i][j] = -1;
            }
        }
        
        // 불에 대한 bfs
        Queue<int[]> fq = new LinkedList<>();
        
        for (int[] f : fires) {
            fq.add(f);
            fireTime[f[0]][f[1]] = 0;
        }
        
        while (!fq.isEmpty()) {
            int[] fc = fq.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = fc[0] + MOVE_X[i];
                int ny = fc[1] + MOVE_Y[i];
                
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (board[nx][ny].equals("#")) continue;
                
                if (fireTime[nx][ny] == -1) {
                    fireTime[nx][ny] = fireTime[fc[0]][fc[1]] + 1;
                    fq.add(new int[] {nx, ny});
                }
            }
        }
        
        // 지훈에 대한 bfs
        Queue<int[]> jq = new LinkedList<>();
        
        int[][] jihunTime = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                jihunTime[i][j] = -1;
            }
        }
        
        jq.add(jihun);
        jihunTime[jihun[0]][jihun[1]] = 0;
        
        while (!jq.isEmpty()) {
            int[] jc = jq.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = jc[0] + MOVE_X[i];
                int ny = jc[1] + MOVE_Y[i];
                
                // 범위를 벗어난 경우 탈출
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    System.out.println(jihunTime[jc[0]][jc[1]] + 1);
                    return;
                }
                // 벽인 경우 갈 수 없음
                if (board[nx][ny].equals("#")) continue;
                
                // 처음 방문하는 곳인 경우
                if (jihunTime[nx][ny] == -1) {
                    // 불 전파 시간이 내 이동 시간보다 빠르면 갈 수 없음
                    if (fireTime[nx][ny] == -1 || jihunTime[jc[0]][jc[1]] + 1 < fireTime[nx][ny]) {
                        jq.add(new int[] {nx, ny});
                        jihunTime[nx][ny] = jihunTime[jc[0]][jc[1]] + 1;
                    }
                }
            }
        }
        
        System.out.println("IMPOSSIBLE");
    }
}