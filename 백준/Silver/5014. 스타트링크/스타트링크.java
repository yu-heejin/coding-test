import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int f = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int g = Integer.parseInt(input[2]);
        int u = Integer.parseInt(input[3]);
        int d = Integer.parseInt(input[4]);
        
        int result = bfs(f, s, g, u, d);
        
        System.out.println(result == -1 ? "use the stairs" : result);
    }
    
    private static int bfs(int f, int start, int goal, int up, int down) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[f + 1];   // 무한루프 방지를 위한 방문 체크
        
        q.offer(new int[] {start, 0});
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int[] p = q.poll();
            
            if (p[0] == goal) return p[1];
            
            for (int i = 0; i < 2; i++) {
                int next = p[0];
                if (i == 0) {
                    // UP
                    next += up;
                } else {
                    // DOWN
                    next -= down;
                }
                
                if (next >= 1 && next <= f && !visited[next]) {
                    visited[next] = true;
                    q.offer(new int[] {next, p[1] + 1});
                }
            }
        }
        
        return -1;
    }
}