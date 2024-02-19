import java.io.*;
import java.util.*;

// 트리의 최소 지배 집합, 루트 없는 트리
public class Main {
    
    static List<List<Integer>> tree;
    static int n;
    static int[][] dp;
    static boolean[] visited;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        tree = new ArrayList<>();
        
        n = Integer.parseInt(br.readLine());
        
        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<Integer>());
        }
        
        // 값 입력
        String[] input;
        String line = br.readLine();
        while (line != null) {
            input = line.split(" ");
            
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            tree.get(a).add(b);
            tree.get(b).add(a);
            
            line = br.readLine();
        }
        
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];
        
        dp(1);   // 루트 노드는 1부터 시작한다.
        
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    
    private static void dp(int node) {
        visited[node] = true;
        dp[node][0] = 1;   // 자기 자신이 얼리어답터인 경우 일단 얼리어답터 개수는 1
        List<Integer> subTree = tree.get(node);
        
        for (int subNode : subTree) {
            if (visited[subNode]) continue;
            // 연결된 노드의 값을 먼저 구한다.
            dp(subNode);
            // 자식이 얼리어답터이거나 아닌 경우 최소값
            dp[node][0] += Math.min(dp[subNode][0], dp[subNode][1]);
            // 내가 얼리어답터가 아닌 경우 자식이 모두 얼리어답터여야함
            dp[node][1] += dp[subNode][0];
        }
    }
}