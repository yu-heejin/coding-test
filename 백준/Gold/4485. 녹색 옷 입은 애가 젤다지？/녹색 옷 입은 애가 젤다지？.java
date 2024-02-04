import java.io.*;
import java.util.*;

// 최단거리 다익스트라 알고리즘
class Node {
    int x;
    int y;
    
    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    
    static final int[] MOVE_X = { -1, 1, 0, 0 };
    static final int[] MOVE_Y = { 0, 0, -1, 1 };
    static int n;
    static int[][] cave;
    static int[][] cost;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        String[] input;
        int problem = 1;
        
        do {
            cave = new int[n][n];
            cost = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                input = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    cave[i][j] = Integer.parseInt(input[j]);
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }
            
            // 출발 위치는 (0, 0), 도착지는 (n-1, n-1)
            System.out.println("Problem " + problem + ": " + dijkstra());

            n = Integer.parseInt(br.readLine());
            problem++;
        } while (n != 0);
    }
    
    private static int dijkstra() {
        Queue<Node> q = new LinkedList<>();

        // 자기 자신의 거리
        q.offer(new Node(0, 0, cave[0][0]));
        cost[0][0] = cave[0][0];
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = node.x + MOVE_X[i];
                int ny = node.y + MOVE_Y[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                
                // 더 작은 경우에만 삽입
                int expected = cost[node.x][node.y] + cave[nx][ny];
                if (expected < cost[nx][ny]) {
                    q.offer(new Node(nx, ny, cave[nx][ny]));
                    cost[nx][ny] = Math.min(cost[nx][ny], cost[node.x][node.y] + cave[nx][ny]);
                }
            }
        }
        
        return cost[n - 1][n - 1];
    }
}