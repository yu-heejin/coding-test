import java.io.*;
import java.util.*;

class Tomato {
    int x;
    int y;
    int day;
    
    public Tomato(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
}

public class Main {
    
    static final int[] MOVE_X = { -1, 1, 0, 0 };
    static final int[] MOVE_Y = { 0, 0, -1, 1 };
    
    static int n, m;
    static int min = Integer.MAX_VALUE;
    static int result = 0;
    
    // 해당 문제를 BFS로 풀어야 하는 이유: 1인 경우 사방에 전파되기 때문!
    // 출발지를 따로 설정할 필요도 없음. 익은 토마토가 있으면 어찌되었든 전파되기 때문
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        
        int[][] box = new int[n][m];
        Queue<Tomato> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(input[j]);
                if (box[i][j] == 1) {
                    q.add(new Tomato(i, j, 0));
                }
            }
        }
        
        // 1. 모든 토마토가 익은 경우 정답 출력 / 아니라면 탐색 시작
        if (isAllRipened(box)) {
            System.out.println(0);
        } else {
            int day = -1;
            
            while (!q.isEmpty()) {
                Tomato t = q.poll();
                day = t.day;   // 큐가 다 비워질 때 쯤이 최종 날짜
                
                for (int i = 0; i < 4; i++) {
                    int nx = t.x + MOVE_X[i];
                    int ny = t.y + MOVE_Y[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    
                    if (box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        q.add(new Tomato(nx, ny, t.day + 1));
                    }
                }
            }
            
            if (isAllRipened(box)) {
                System.out.println(day);
            } else {
                System.out.println(-1);
            }
        }
    }
    
    private static boolean isAllRipened(int[][] box) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) return false;
            }
        }
        
        return true;
    }
}