import java.util.*;
import java.io.*;

// 위상 정렬 + DP(최소시간)
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String[] input = br.readLine().split(" ");
    
            int N = Integer.parseInt(input[0]);  // 건물의 개수
            int K = Integer.parseInt(input[1]);  // 건물 간의 건설 순서 규칙의 총 개수

            // 진입 차수
            int[] indegree = new int[N + 1];
            
            // 각 건물 당 건설에 걸리는 시간
            int[] times = new int[N + 1];
            input = br.readLine().split(" ");
    
            for (int i = 1; i <= N; i++) {
                times[i] = Integer.parseInt(input[i - 1]);
            }

            // 건설 순서
            List<List<Integer>> graph = new ArrayList<>();

            // 그래프 초기화
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<Integer>());
            }
            
            for (int j = 0; j < K; j++) {
                input = br.readLine().split(" ");

                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);

                graph.get(a).add(b);
                indegree[b]++;
            }

            int W = Integer.parseInt(br.readLine());
            int[] dp = new int[N + 1];

            Queue<Integer> q = new LinkedList<>();

            // 차수가 0인 노드를 먼저 넣는다.
            for (int i = 1; i <= N; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                    dp[i] = times[i];
                }
            }
            
            while (!q.isEmpty()) {
                int node = q.poll();

                if (node == W) {
                    break;
                }

                for (int connected : graph.get(node)) {
                    indegree[connected]--;
                    // 해당 위치에 시간을 계산해야 같은 위상 사이의 최대 시간을 계산할 수 있음
                    dp[connected] = Math.max(dp[connected], dp[node] + times[connected]);

                    if (indegree[connected] == 0) {
                        q.offer(connected);
                    }
                }
            }

            System.out.println(dp[W]);
        }
    }
}