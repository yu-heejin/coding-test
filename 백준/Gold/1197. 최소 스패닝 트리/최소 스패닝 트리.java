import java.util.*;
import java.io.*;

/** 크루스칼 풀이 - 간선에 대한 정렬 수행 후 가장 거리가 짧은 간선부터 집합에 포함**/

class Edge implements Comparable<Edge> {
    int a;
    int b;
    int cost;
    
    public Edge(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }
    
    // 간선의 비용이 가장 작은 순서대로
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

/* 최소 스패닝 트리(최소 신장 트리)는 Prim, Kruskal 등이 있다. */
public class Main {
    static List<Edge> edges = new ArrayList<>();
    static int[] parents;
    static int[] rank;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
        String[] input = br.readLine().split(" ");
        
        int V = Integer.parseInt(input[0]);   // 정점의 개수
        int E = Integer.parseInt(input[1]);   // 간선의 개수
        
        parents = new int[V + 1];
        rank = new int[V + 1];   // rank 기반 압축 (초기값 0)
        
        // 부모 초기화
        for (int i = 0; i <= V; i++) {
            parents[i] = i;
        }
        
        for (int i = 0; i < E; i++) {
          input = br.readLine().split(" ");
          
          int a = Integer.parseInt(input[0]);
          int b = Integer.parseInt(input[1]);
          int cost = Integer.parseInt(input[2]);
          
          edges.add(new Edge(a, b, cost));
        }
        
        // 간선의 비용이 가장 작은 순서대로 정렬
        Collections.sort(edges);
        
        int result = 0;
        // 간선을 하나씩 확인, 사이클이 발생하지 않는 경우 해당 간선 선택
        for (Edge edge : edges) {
            if (find(edge.a) != find(edge.b)) {
                union(edge.a, edge.b);
                result += edge.cost;
            }
        }
        
        System.out.println(result);
    }
    
    // 사이클을 찾기 위한 union-find
    // 두 집합이 서로 연결되어 있지 않은 경우 하나의 집합으로 만든다.
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x == y) return;
        
        // if (x < y) parents[y] = x;
        // else parents[x] = y;
        
        if (rank[x] < rank[y]) {
            parents[x] = y;
        } else if (rank[x] > rank[y]) {
            parents[y] = x;
        } else {
            // 랭크가 같은 경우 한쪽을 다른쪽에 병합하고 랭크 증가
            parents[y] = x;
            rank[x]++;
        }
    }
    
    // x가 속한 부모 노드를 찾는다.
    private static int find(int x) {
        if (parents[x] == x) return x;
        
        return find(parents[x]);
    }
}