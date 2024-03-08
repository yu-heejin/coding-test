import java.io.*;
import java.util.*;

public class Main {
    
    static List<List<Integer>> tree;
    static int[] person;
    static int n;
    static int[][] dp;
    static boolean[] visited;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        person = new int[n + 1];
        tree = new ArrayList<>();
        
        // 주민 수 저장
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            person[i] = Integer.parseInt(input[i - 1]);
        }
        
        // 인접한 마을 정보 저장
        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            input = br.readLine().split(" ");
            
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];
        
        dp(1);
        
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
    
    private static void dp(int town) {
        // 0은 자신이 우수 마을인 경우, 1은 자신이 일반 마을인 경우
        visited[town] = true;
        dp[town][0] = person[town];   // 자기 자신이 우수 마을인 경우 일단 해당 마을의 인구수 저장
        dp[town][1] = 0;      // 해당 마을이 우수마을이 아닌 경우 일단 0으로 초기화
        List<Integer> subTree = tree.get(town);         // 해당 트리랑 연결된 마을 리스트
        
        for (int connectedTown : subTree) {
            if (visited[connectedTown]) continue;     // 이미 방문된 위치는 패스한다.
            
            dp(connectedTown);
            
            // 자기 자신이 우수마을인 경우 인접한 마을 모두 우수마을이면 안됨
            dp[town][0] += dp[connectedTown][1];
            
            // 자신이 우수마을이 아닌 경우 적어도 하나는 우수마을이어야 한다.
            dp[town][1] += Math.max(dp[connectedTown][0], dp[connectedTown][1]);
        }
    }
}