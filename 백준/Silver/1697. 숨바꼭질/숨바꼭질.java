import java.io.*;
import java.util.*;

public class Main {
    
    static boolean[] visited = new boolean[100003];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        
        System.out.println(bfs(N, K));
    }
    
    public static int bfs(int N, int K) {
        Queue<int[]> q = new LinkedList<>();
        visited[N] = true;
        
        q.add(new int[] {N, 0});
        int min = Integer.MAX_VALUE;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            //System.out.println(Arrays.toString(curr));
            
            // 현재 위치가 K와 같으면 최소값 갱신
            if (curr[0] == K) {
                min = Math.min(min, curr[1]);
                break;
            }
            
            // 걷는 경우
            int nextWork1 = curr[0] - 1;
            int nextWork2 = curr[0] + 1;
            // 순간 이동하는 경우
            int move = curr[0] * 2;
            
            if (nextWork1 <= 100000 && nextWork1 >= 0 && !visited[nextWork1]) {
                q.add(new int[] {nextWork1, curr[1] + 1});
                visited[nextWork1] = true;
            }
            
            if (nextWork2 <= 100000 && nextWork2 >= 0 && !visited[nextWork2]) {
                q.add(new int[] {nextWork2, curr[1] + 1});
                visited[nextWork2] = true;
            }
            
            if (move <= 100000 && move >= 0 && !visited[move]) {
                q.add(new int[] {move, curr[1] + 1});
                visited[move] = true;
            }
        }
        
        return min;
    }
}