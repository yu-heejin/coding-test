import java.io.*;
import java.util.*;

public class Main {
    
    static List<List<Integer>> tree;
    static int[] parents;
    static boolean[] visited;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        tree = new ArrayList<>();
        
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        parents = new int[n + 1];
        
        Arrays.fill(parents, -1);
        
        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<Integer>());
        }
        
        // 노드 연결 정보 저장
        for (int i = 1; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        
        dfs(1);
        
        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }
    
    private static void dfs(int x) {
        visited[x] = true;
        
        for (int i = 0; i < tree.get(x).size(); i++) {
            int y = tree.get(x).get(i);
            if (parents[y] == -1) parents[y] = x;
            if (!visited[y]) dfs(y);
        }
    }
}