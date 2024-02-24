import java.io.*;
import java.util.*;

public class Main {
    
    static List<List<Integer>> graph;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int v = Integer.parseInt(input[2]);
        
        graph = new ArrayList<>();
        
        // graph 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        // 그래프에 노드 삽입
        // 입력으로 주어지는 간선은 양방향이다.
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        // dfs
        dfs(n, v);
        
        System.out.println();
        
        // bfs
        bfs(n, v);
    }
    
    // dfs: stack을 이용한 구현
    // 재귀 호출(함수)도 내부적으로 stack을 이용함을 기억할 것
    private static void dfs(int n, int start) {
        boolean[] visited = new boolean[n + 1];
        Stack<Integer> s = new Stack<>();
        
        // stack을 생성하고 시작 정점의 값을 스택에 넣는다.
        s.push(start);
        
        while (!s.isEmpty()) {
            // pop해서 스택 최상단 노드를 꺼낸다
            int v = s.pop();
            
            // 만약 방문한 정점이 아니라면
            if (!visited[v]) {
                visited[v] = true;
                System.out.print(v + " ");     // 이미 방문한 경우 출력하지 않는다.
            
                // 해당 노드의 인접 노드 중 미방문 노드를 전부 push
                // 이 때 스택에 중복 push는 없도록 한다.
                List<Integer> conn = graph.get(v);
                Collections.sort(conn, Collections.reverseOrder());
                for (int c : conn) {
                    if (!visited[c]) {
                        s.push(c);
                    }
                }    
            }
        }
    }
    
    // bfs는 큐를 이용한다.
    private static void bfs(int n, int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int v = q.poll();
            System.out.print(v + " ");
            
            List<Integer> conn = graph.get(v);
            Collections.sort(conn);     // 가장 낮은 수부터 방문
            for (int c : conn) {
                if (!visited[c]) {
                    q.offer(c);
                    visited[c] = true;
                }
            }
        }
    }
}