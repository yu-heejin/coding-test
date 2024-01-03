import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] indegree = new int[n + 1];
        int[] dp = new int[n + 1];
        int[] times = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>(); 
        
        // 정점 별 그래프 초기화
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            dp[i] = Integer.parseInt(input[0]);
            times[i] = dp[i];
            
            int preCount = Integer.parseInt(input[1]);
            
            for (int j = 0; j < preCount; j++) {
                int a = Integer.parseInt(input[j + 2]);  // 선행 테스크
                graph.get(a - 1).add(i);
                indegree[i] += 1;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        // 시작 시 진입 차수 0인 노드 큐에 삽입
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        
        while (!q.isEmpty()) {
            int now = q.poll();
            now--;
            
            for (int i = 0; i < graph.get(now).size(); i++) {
                indegree[graph.get(now).get(i)] -= 1;
                dp[graph.get(now).get(i)] = Math.max(dp[graph.get(now).get(i)], times[graph.get(now).get(i)] + dp[now + 1]);
                if (indegree[graph.get(now).get(i)] == 0) {
                    q.offer(graph.get(now).get(i));
                }
            }
        }
        
        // 최대 시간 구하기
        int time = -1;
        for (int i = 1; i <= n; i++) {
            time = Math.max(dp[i], time);
        }
        
        System.out.println(time);
    }
}