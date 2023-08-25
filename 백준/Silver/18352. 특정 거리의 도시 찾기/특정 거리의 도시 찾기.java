import java.util.*;
import java.io.*;

public class Main {
    
    private static String[] input;
    private static int[] dist;
    private static List<ArrayList<Integer>> graph;
    
    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        dist[start] = 0;
        
        q.offer(start);
        while (!q.isEmpty()) {
            int x = q.poll();
            
            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (dist[y] == -1) {
                    dist[y] = dist[x] + 1;
                    q.offer(y);
                }
            }
        }
    }
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new ArrayList<>();
        
        input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int x = Integer.parseInt(input[3]);
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        dist = new int[n + 1];
        
        Arrays.fill(dist, -1);
        
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            graph.get(a).add(b);
        }
        
        bfs(x);
        
        boolean is = false;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == k) {
                System.out.println(i);
                is = true;
            }
        }
        
        if (!is)
            System.out.println(-1);
    }
}