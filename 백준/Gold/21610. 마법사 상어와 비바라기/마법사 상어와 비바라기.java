import java.util.*;
import java.io.*;

class Cloud {
    int x;
    int y;
    
    public Cloud(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    
    static final int[][] MOVE = {
        {0, -1},
        {-1, -1},
        {-1, 0},
        {-1, 1},
        {0, 1},
        {1, 1},
        {1, 0},
        {1, -1}
    };
    static String[] input;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        int[][] room = new int[n][n];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                room[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        // 비구름이 생기는 위치
        Queue<Cloud> clouds = new LinkedList<>();
        clouds.add(new Cloud(n-1, 0));
        clouds.add(new Cloud(n-1, 1));
        clouds.add(new Cloud(n-2, 0));
        clouds.add(new Cloud(n-2, 1));
        
        for (int i = 0; i < m; i++) {
            // 구름 이동
            input = br.readLine().split(" ");
            int d = Integer.parseInt(input[0]) - 1;
            int s = Integer.parseInt(input[1]);
            boolean[][] isDisappear = new boolean[n][n];
            
            for (Cloud cloud : clouds) {
                cloud.x = (n + cloud.x + MOVE[d][0] * (s % n)) % n;
                cloud.y = (n + cloud.y + MOVE[d][1] * (s % n)) % n;
                // 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
                room[cloud.x][cloud.y]++;
            }
            
            // 구름이 모두 사라진다
            while (!clouds.isEmpty()) {
                Cloud cloud = clouds.poll();
                isDisappear[cloud.x][cloud.y] = true;
                
                // 물복사버그 시전
                int count = 0;
                for (int j = 1; j < 8; j += 2) {
                    int nextX = cloud.x + MOVE[j][0];
                    int nextY = cloud.y + MOVE[j][1];
                    
                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                        continue;
                    }
                    
                    // 물이 있는 경우만 증가
                    if (room[nextX][nextY] > 0) {
                        count++;
                    }
                }
                
                room[cloud.x][cloud.y] += count;
            }
            
            // 구름 있던 칸 빼고 물 양이 2인 경우 구름이 생김, 생긴 경우 물의 양이 2만큼 줄어듬
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!isDisappear[j][k] && room[j][k] >= 2) {
                        Cloud cloud = new Cloud(j, k);
                        clouds.add(cloud);
                        room[j][k] -= 2;
                    }
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer += room[i][j];
            }
        }
        
        System.out.println(answer);
    }
}
