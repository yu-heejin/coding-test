import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    private static final int[] MOVE_R = {1, 0, 1};
    private static final int[] MOVE_C = {0, 1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] maze = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] dp = new int[n][m];
        dp[0][0] = maze[0][0];
        
        for (int i = 1; i < m; i++) {
            dp[0][i] += (dp[0][i-1] + maze[0][i]);
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] += (dp[i-1][0] + maze[i][0]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i][j-1], dp[i-1][j-1])) + maze[i][j];
            }
        }

        System.out.println(dp[n-1][m-1]);
    }
/**
    BFS와 DP 문제 구분법 : BFS는 그래프에서 간선의 가중치가 모두 같을 때의 최단 경로를 
    구하는 알고리즘 / DP는 부분 문제를 해결하는것으로 더 큰 문제를 해결할 수 있을 때 
    사용하는 알고리즘 / 위 문제는 정점 사이의 거리는 1이지만, 
    구하려는 답은 최단 경로가 아니므로 BFS를 적용하기 좋은 문제는 아닙니다.
    **/
    // private static void bfs(int n, int m, int[][] maze) {
    //     boolean[][] visited = new boolean[n][m];
    //     Queue<int[]> q = new LinkedList<>();

    //     // 출발지점 추가
    //     q.add(new int[] {0, 0, maze[0][0]});
    //     visited[0][0] = true;

    //     while (!q.isEmpty()) {
    //         int[] current = q.poll();

    //         System.out.println(Arrays.toString(current));

    //         if (current[0] == n - 1 && current[1] == m - 1) {
    //             // 최댓값 계산
    //             max = Math.max(current[2], max);
    //         }

    //         for (int i = 0; i < 3; i++) {
    //             int nr = current[0] + MOVE_R[i];
    //             int nc = current[1] + MOVE_C[i];

    //             if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
    //             if (visited[nr][nc]) continue;

    //             q.add(new int[] {nr, nc, current[2] + maze[nr][nc]});
    //             visited[nr][nc] = true;
    //         }
    //     }
    // }
}