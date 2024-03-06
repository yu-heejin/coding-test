import java.io.*;
import java.util.*;

public class Main {
    
    static int[] parent;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        parent = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        List<List<Integer>> computers = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            computers.add(new ArrayList<Integer>());
        }
        
        String[] input;
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            computers.get(a).add(b);
            computers.get(b).add(a);
        }
        
        for (int i = 1; i <= n; i++) {
            for (int e : computers.get(i)) {
                union(i, e);
            }
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            parent[i] = find(i);
            if (parent[i] == parent[1]) count++;
        }
        
        System.out.println(count - 1);
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