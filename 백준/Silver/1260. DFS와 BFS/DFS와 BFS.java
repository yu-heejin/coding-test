import java.io.*;
import java.util.*;

public class Main {
    
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int V = Integer.parseInt(input[2]);
        
        visited = new boolean[N + 1];
            
        // 1. init graph
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        // 2. 간선 정보 저장
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        // 3. 간선 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }
        
        // result dfs
        dfs(V);
        
        Arrays.fill(visited, false);
        
        System.out.println();
        
        bfs(V);
    }
    
    /* BFS */
    private static void bfs(int start) {
        // 정점 번호가 가장 작은 것을 먼저 방문
        Queue<Integer> q = new LinkedList<>();
        
        visited[start] = true;
        q.add(start);
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");
            
            List<Integer> connections = graph.get(curr);
            
            // 꺼낸 노드와 연결된 모든 노드들만큼 반복
            for (int connection : connections) {
                // 해당 노드를 방문하지 않은 경우 큐에 추가
                if (!visited[connection]) {
                    q.add(connection);
                    visited[connection] = true;
                }
            }
        }
    }
    
    
    /* DFS */
    private static void dfs(int start) {
        visited[start] = true;
        
        System.out.print(start + " ");
        
        // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
        List<Integer> connections = graph.get(start);
        
        for (int connection : connections) {
            // 만약 해당 노드를 방문하지 않은 경우 재귀
            if (!visited[connection]) {
                dfs(connection);
            }
        }
    }
}