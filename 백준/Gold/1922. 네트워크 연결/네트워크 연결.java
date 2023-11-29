import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int a;
    int b;
    int distance;
    
    Node(int a, int b, int distance) {
        this.a = a;
        this.b = b;
        this.distance = distance;
    }
    
    @Override
    public int compareTo(Node o) {
        return this.distance - o.distance;
    }
}

public class Main {
    static int[] parent;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        List<Node> nodes = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            Node node = new Node(
                Integer.parseInt(input[0]),
                Integer.parseInt(input[1]),
                Integer.parseInt(input[2])
            );
            
            nodes.add(node);
        }
        
        // parent 초기화
        parent = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        Collections.sort(nodes);
        
        int total = 0;
        for (int i = 0; i < m; i++) {
            Node node = nodes.get(i);
            if (find(node.a) != find(node.b)) {
                union(node.a, node.b);
                total += node.distance;
            }
        }
        
        System.out.println(total);
    }
    
    private static int find(int x) {
        if (x == parent[x]) return x;
        
        return find(parent[x]);
    }
    
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a == b) return;
        
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}