import java.util.*;
import java.io.*;

public class Main {
    private static List<List<int[]>> graph = new ArrayList<>();
    private static int n, e;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        e = Integer.parseInt(input[1]);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<int[]>());
        }

        for (int i = 0; i < e; i++) {
            input = br.readLine().split(" ");

            // a번 정점에서 b번 정점까지 양방향, 그 거리는 c
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            graph.get(a).add(new int[] {b, c});
            graph.get(b).add(new int[] {a, c});
        }

        input = br.readLine().split(" ");

        int v1 = Integer.parseInt(input[0]);
        int v2 = Integer.parseInt(input[1]);

        // 1. 1 -> v1 -> v2 -> N
        int case1 = 0;
        case1 += dijkstra(1, v1);
        case1 += dijkstra(v1, v2);
        case1 += dijkstra(v2, n);

        // 2. 1 -> v2 -> v1 -> N
        int case2 = 0;
        case2 += dijkstra(1, v2);
        case2 += dijkstra(v2, v1);
        case2 += dijkstra(v1, n);

        if (case1 >= 200000 * 1001 && case2 >= 200000 * 1001)
            System.out.println(-1);
        else
            System.out.println(Math.min(case1, case2));
    }

    // 시작 지점에서 종료 지점까지의 최단 거리
    private static int dijkstra(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });

        boolean[] visited = new boolean[n + 1];
        int[] shortDistances = new int[n + 1];

        // 간선의 개수 x 간선의 최대 크기 이상 (간선의 최대크기 이상만큼 더해지면 거리가 없음을 의미)
        Arrays.fill(shortDistances, 200000 * 1001);
        
        pq.offer(new int[] {start, 0});
        shortDistances[start] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            List<int[]> conn = graph.get(curr[0]);

            // 현재 노드의 최단 거리가 dist보다 작으면 보지 않아도 된다. (불필요한 갱신)
            if (shortDistances[curr[0]] < curr[1]) {
                continue;
            }

            for (int i = 0; i < conn.size(); i++) {
                // 비용 = 현재 노드까지의 거리 + 해당 노드와 연결된 거리
                int cost = shortDistances[curr[0]] + conn.get(i)[1];

                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우 (갱신 필요)
                if (cost < shortDistances[conn.get(i)[0]]) {
                    shortDistances[conn.get(i)[0]] = cost;
                    pq.offer(new int[] {conn.get(i)[0], cost});
                }
            }
        }

        // start -> end까지 가는 경로의 최단 거리
        return shortDistances[end];
    }
}