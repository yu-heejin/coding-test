import java.io.*;
import java.util.*;

class Bus implements Comparable<Bus> {
    int end;
    int cost;
    
    public Bus(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Bus o) {
        return this.cost - o.cost;    // 비용이 더 작은 버스를 우선적으로 탐색한다.
    }
}

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        List<List<Bus>> buses = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            buses.add(new ArrayList<Bus>());
        }
        
        String[] input;
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            
            buses.get(a).add(new Bus(b, c));
        }
        
        int[] cost = new int[n + 1];
        
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.add(new Bus(s, 0));
        cost[s] = 0;
        
        while (!pq.isEmpty()) {
            Bus b = pq.poll();
            int c = b.cost;
            int now = b.end;
            
            if (cost[now] < c) continue;     // 현재 노드의 최단 거리가 cost보다 크면 갱신하지 않는다.
            
            // 연결된 간선 확인
            for (int i = 0; i < buses.get(now).size(); i++) {
                int currCost = cost[now] + buses.get(now).get(i).cost;   // 현재 비용 + 해당 목적지까지 가는데 드는 비용
                
                if (currCost < cost[buses.get(now).get(i).end]) {
                    // 새로운 비용이 현재 비용보다 작은 경우 갱신한다.
                    cost[buses.get(now).get(i).end] = currCost;
                    pq.offer(new Bus(buses.get(now).get(i).end, currCost));
                }
            }
        }
        
        System.out.println(cost[e]);
    }
}