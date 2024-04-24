import java.io.*;
import java.util.*;

public class Main {
    
    static List<List<Integer>> graph;
    static boolean[] isCycle;
    static boolean[] visited;
    static boolean cycle = false;
    static int[] answers;
    static int n;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        graph = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        String[] input;
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        isCycle = new boolean[n + 1];
        visited = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            Arrays.fill(visited, false);
            cycle = false;
            
            findCycle(i, i, 0);
            
            if (cycle) {
                isCycle[i] = true;
            }
        }
        
        answers = new int[n + 1];
        
        bfs();
        
        for (int i = 1; i <= n; i++) {
            System.out.print(answers[i] + " ");
        }
    }
    
    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        
        // 순환에 속하는 경우 거리가 0이다
        for (int i = 1; i <= n; i++) {
            if (isCycle[i]) {
                answers[i] = 0;
                q.add(new int[] {i, 0});
            } else {
                answers[i] = -1;    // 순환선에 포함되지 않는 경우
            }
        }
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            List<Integer> conn = graph.get(curr[0]);
            
            for (int c : conn) {
                // 해당 역이 순환선에 포함되지 않는 경우
                if (answers[c] == -1) {
                    q.add(new int[] {c, curr[1] + 1});
                    answers[c] = curr[1] + 1;
                }
            }
        }
    }
    
    private static void findCycle(int start, int current, int depth) {
        if (start == current && depth >= 2) {
            cycle = true;
            return;
        }
        
        visited[current] = true;
        List<Integer> connections = graph.get(current);
        
        for (int c : connections) {
            if (!visited[c]) {     // 방문하지 않은 경우 탐색
                findCycle(start, c, depth + 1);
            } else if (c == start && depth >= 2) {
                findCycle(start, c, depth);     // 다음 방문점이 시작점이고 depth가 2 이상인 경우
            }
        }
    }
}