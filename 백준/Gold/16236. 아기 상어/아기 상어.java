import java.util.*;
import java.io.*;

class Position {
    int x;
    int y;
    int dist;  // 현재 상어와의 거리
    
    public Position(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class Main {
    
    static final int[] MOVE_X = {-1, 1, 0, 0};
    static final int[] MOVE_Y = {0, 0, -1, 1};
    static int[][] board;
    static int n;
    static int mySize = 2;
    static int[] start = new int[2];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(input[j]);
                if (board[i][j] == 9) {
                    start[0] = i;
                    start[1] = j;
                    board[i][j] = 0;
                }
            }
        }
        
        dfs(start[0], start[1]);
    }
    
    private static void dfs(int x, int y) {
        PriorityQueue<Position> q = new PriorityQueue<>((o1, o2) -> {
            if (o1.dist == o2.dist) {   // 거리가 가까운 물고기가 많은 경우
                if (o1.x == o2.x) {  // 가장 위쪽에 있는 물고기가 여러개인 경우
                    return Integer.compare(o1.y, o2.y);  // 가장 왼쪽에 있는 물고기
                }
                return Integer.compare(o1.x, o2.x);   // 가장 위에 있는 물고기
            }
            
            return Integer.compare(o1.dist, o2.dist);
        });
        int getFishCount = 0;
        int answer = 0;
        boolean[][] visited = new boolean[n][n];
        
        q.offer(new Position(x, y, 0));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Position p = q.poll();  // 상어의 현재 위치
            
            for (int i = 0; i < 4; i++) {
                int nextX = p.x + MOVE_X[i];
                int nextY = p.y + MOVE_Y[i];
                
                // 현재 위치에서 가까운 상허좌우를 큐에 삽입
                if (!isBoundary(nextX, nextY) && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    // 상하좌우는 현재 상어와의 거리 + 1
                    q.offer(new Position(nextX, nextY, p.dist + 1));
                }
            }
            
            if (q.peek() != null) {  // 가장 가까운 거리가 있는 경우
                Position peek = q.peek();
                
                if (board[peek.x][peek.y] < mySize && board[peek.x][peek.y] > 0) {  // 그 거리에 있는 물고기가 나보다 작고 0이 아닌 경우
                    getFishCount++;  // 물고기를 먹음
                    if (getFishCount == mySize) {   // 먹은 물고기 크기가 나랑 같은 경우 크기 증가
                        mySize++;
                        getFishCount = 0;
                    }
                    board[peek.x][peek.y] = 0;    // 이미 먹어버렸으므로 0
                    
                    q.clear();   // 새 위치에서 시작
                    q.add(new Position(peek.x, peek.y, 0));   // 현재 위치를 넣어준다. (시작 위치) -> 시작 위치에서 새로 시작하기 때문
                    answer += peek.dist;   // 시작 위치에서 새로 방문한 위치이므로 +
                    visited = new boolean[n][n];
                    visited[peek.x][peek.y] = true;
                }
            }
        }
        
        System.out.println(answer);
    }
    
    private static boolean isBoundary(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return true;
        }
        
        if (board[x][y] > mySize) {
            return true;
        }
        
        return false;
    }
}
