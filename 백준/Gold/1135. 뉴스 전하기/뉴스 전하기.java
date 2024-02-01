import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dp;
    static List<List<Integer>> tree;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        if (n == 1) System.out.println(0);
        else {
            tree = new ArrayList<>();
        
            for (int i = 0; i < n; i++) {
                tree.add(new ArrayList<Integer>());
            }
            
            String[] input = br.readLine().split(" ");
            for (int i = 1; i < n; i++) {
                tree.get(Integer.parseInt(input[i])).add(i);
            }
            
            // 자식 노드들까지 걸리는 시간 확인
            dp = new int[n];
            Arrays.fill(dp, -1);
            
            getTime(0);
            
            System.out.println(dp[0]);
        }
    }
    
    private static int getTime(int node) {
        // 리프 노드인 경우 걸리는 시간이 없으므로 0
        if (tree.get(node).size() == 0) return 0;
        
        // 이미 메모이제이션이 되어있는 경우 해당 값을 반환한다.
        if (dp[node] != -1) return dp[node];
        
        // 자식 노드들의 시간 계산
        // 가장 오래 걸리는 자식먼저 전달하면 최소 시간을 구할 수 있다.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // 자식 노드의 시간을 구한다. 
        for (int i = 0; i < tree.get(node).size(); i++) {
            pq.add(getTime(tree.get(node).get(i)));
        }
        
        // 가장 오래 걸리는 시간을 찾는다.
        // count를 더해주는 이유는 민식이는 한번에 한명에게만 전화를 걸 수 있음, 일종의 순번
        int count = 0;
        while (!pq.isEmpty()) {
            count++;
            dp[node] = Math.max(pq.poll() + count, dp[node]);
        }
        
        return dp[node];
    }
}