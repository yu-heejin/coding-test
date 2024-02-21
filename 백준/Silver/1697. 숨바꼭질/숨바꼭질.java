import java.io.*;
import java.util.*;

public class Main {
    
    static boolean[] visited = new boolean[100001];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        
        if (n == k) System.out.println(0);
        else bfs(n, k);
    }
    
    private static void bfs(int start, int target) {
        Queue<int[]> q = new LinkedList<>();
        // 각 방향으로 움직였을 때의 최소값
        q.add(new int[] {start, 0});
        int max = Integer.MIN_VALUE;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            visited[curr[0]] = true;
            
            // 현재 위치에서 이동 시 동생의 위치인 경우
            if (curr[0] - 1 == target || curr[0] + 1 == target || curr[0] * 2 == target) {
                System.out.println(curr[1] + 1);
                break;
            }
            
            // x - 1로 이동했을 때의 좌표와 그 때의 시간
            if (curr[0] - 1 >= 0 && !visited[curr[0] - 1]) {
                visited[curr[0] - 1] = true;
                q.add(new int[] {curr[0] - 1, curr[1] + 1});
            }
            
            // x + 1로 이동했을 때의 좌표와 그 때의 시간
            if (curr[0] + 1 <= 100000 && !visited[curr[0] + 1]) {
                visited[curr[0] + 1] = true;
                q.add(new int[] {curr[0] + 1, curr[1] + 1});
            }
            
            // 2 * x로 이동했을 때의 좌표와 그 때의 시간
            if (2 * curr[0] <= 100000 && !visited[2 * curr[0]]) {
                visited[curr[0] * 2] = true;
                q.add(new int[] {curr[0] * 2, curr[1] + 1});
            }
        }
    }
}