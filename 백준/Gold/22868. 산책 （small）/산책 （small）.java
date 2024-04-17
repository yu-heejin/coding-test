import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] routes;    // 이전 경로 역추적(해당 노드 방문 전 거쳐온 노드)
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        
        graph = new ArrayList<>();
        visited = new boolean[n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        
        // 사전순을 위한 경로 정렬
        for (int i = 0; i <= n; i++) {
            Collections.sort(graph.get(i));
        }
        
        routes = new int[n + 1];
        
        int answer = 0;
        // s -> e까지의 경로 리스트
        answer += bfs(s, e);
        
        Arrays.fill(visited, false);
        
        int goal = routes[e];
        while (goal > 0) {
            visited[goal] = true;
            goal = routes[goal];
        }
        visited[s] = false;
        
        // e -> s 경로
        answer += bfs(e, s);
        
        System.out.println(answer);
    }
    
    private static int bfs(int s, int e) {
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[] {s, 0});
        visited[s] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            if (curr[0] == e) {
                return curr[1];
            }
            
            List<Integer> connected = graph.get(curr[0]);
            
            // 현재 정점과 연결된 정점 탐색
            for (int n : connected) {
                if (visited[n]) continue;
                
                visited[n] = true;
                routes[n] = curr[0];
                q.add(new int[] {n, curr[1] + 1});
            }
        }
        
        return 0;
    }
}