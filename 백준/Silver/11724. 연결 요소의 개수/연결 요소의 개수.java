import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);    // 정점의 개수 n
        int m = Integer.parseInt(input[1]);    // 간선의 개수 m
        
        // parent 배열 초기화
        parent = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        
        // edge list
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<Integer>());
        }
        
        // 방향 없는 그래프 - 양방향
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            edges.get(a).add(b);
            edges.get(b).add(a);
        }
        
        for (int i = 1; i <= n; i++) {
            for (Integer e : edges.get(i)) {
                union(i, e);
            }
        }
        
        Set<Integer> conn = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            parent[i] = find(i);
            conn.add(parent[i]);
        }
        
        System.out.println(conn.size());
    }
    
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x == y) return;
        
        if (x < y) parent[y] = x;
        else parent[x] = y;
    }
    
    private static int find(int x) {
        if (parent[x] == x) return x;
        
        return find(parent[x]);
    }
}