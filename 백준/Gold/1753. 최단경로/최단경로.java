import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int end;
    int weight;
    
    public Node(int e, int w) {
        this.end = e;
        this.weight = w;
    }
    
    // 거리가 짧은 경우 높은 우선순위를 가진다.
    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class Main {
    
    static int[] dist;
    static List<List<Node>> graph;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        // 모든 정점에는 1부터 v까지 번호가 매겨져 있다.
        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        
        // 시작 정점의 번호
        int k = Integer.parseInt(br.readLine());
        
        dist = new int[v + 1];
        
        Arrays.fill(dist, 999999);    // 간선은 10 이하의 자연수
        
        graph = new ArrayList<>();
        
        // 그래프 초기화
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<Node>());
        }
        
        // 간선의 개수만큼 반복
        for (int i = 0; i < e; i++) {
            input = br.readLine().split(" ");
            Node n = new Node(Integer.parseInt(input[1]),Integer.parseInt(input[2]));
            
            graph.get(Integer.parseInt(input[0])).add(n);
        }
        
        // 자기 자신은 0
        dist[k] = 0;
        
        dijkstra(k);
        
        for (int i = 1; i <= v; i++) {
            System.out.println(dist[i] >= 999999 ? "INF" : dist[i]);
        }
    }
    
    private static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        
        q.offer(new Node(start, 0));
        
        while (!q.isEmpty()) {
            Node n = q.poll();
            
            int weight = n.weight;
            int index = n.end;   // 연결된 거리
            
            if (weight > dist[index]) continue;   // 현재 연결된 간선의 가중치가 최소값보다 크면 의미 없으므로 넘김
            
            List<Node> conn = graph.get(index);
            for (Node node : conn) {
                int cost = dist[index] + node.weight;   // 현재 노드를 거쳐서 가는 경우의 가중치
                
                if (cost < dist[node.end]) {
                    // 현재 비용보다 최소값이 더 큰 경우
                    dist[node.end] = cost;
                    q.offer(new Node(node.end, cost));
                }
            }
        }
    }
}