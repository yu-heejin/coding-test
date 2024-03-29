import java.io.*;
import java.util.*;

public class Main {
    static int[] visited;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        
        if (n == k) System.out.println(0);
        else bfs(n, k);
    }
    
    private static void bfs(int n, int k) {
        Deque<Integer> q = new ArrayDeque<>();   // deque
        visited = new int[100001];
        
        Arrays.fill(visited, -1);
        
        q.add(n);
        visited[n] = 0;      // 가중치 == 시간
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            if (curr == k) {
                System.out.println(visited[curr]);
                break;
            }
            
            // 2 * x, 해당 부분을 먼저 놔야 우선으로 들어간다.
            if (curr * 2 <= 100000 && visited[curr * 2] == -1) {
                visited[curr * 2] = visited[curr];      // 0초 후
                q.addFirst(curr * 2);
            }
            
            // x - 1로 이동했을 때 아직 방문하지 않은 곳인 경우
            if (curr - 1 >= 0 && visited[curr - 1] == -1) {
                visited[curr - 1] = visited[curr] + 1;   // 1초 후
                q.addLast(curr - 1);
            }
            
            // x + 1
            if (curr + 1 <= 100000 && visited[curr + 1] == -1) {
                visited[curr + 1] = visited[curr] + 1;
                q.addLast(curr + 1);
            }
        }
    }
}