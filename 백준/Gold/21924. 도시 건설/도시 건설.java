import java.io.*;
import java.util.*;

class Distance implements Comparable<Distance> {
    int n1;
    int n2;
    int cost;
    
    public Distance(int n1, int n2, int cost) {
        this.n1 = n1;
        this.n2 = n2;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Distance o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int[] parents;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        parents = new int[n + 1];
        
        /* 부모 원소 초기화 */
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
        
        PriorityQueue<Distance> pq = new PriorityQueue<>();
        long totalCost = 0;
        
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            
            totalCost += c;
            
            pq.add(new Distance(a, b, c));
        }
        
        long answer = 0;
        int connectCount = 0;
        
        while (!pq.isEmpty()) {
            Distance d = pq.poll();
            
            // 사이클이 발생하지 않는 경우에만
            if (find(d.n1) != find(d.n2)) {
                union(d.n1, d.n2);
                answer += d.cost;
                connectCount++;
            }
        }
        
        if (connectCount < n - 1) System.out.println(-1);
        else System.out.println(totalCost - answer);
    }
    
    /* 사이클 확인 함수 */
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x == y) return;
        
        if (x < y) parents[y] = x;
        else parents[x] = y;
    }
    
    private static int find(int x) {
        if (parents[x] == x) return x;
        
        return find(parents[x]);
    }
}