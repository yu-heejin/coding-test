import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    // 상하좌우 이동
    private static final int[] NX = {-1, 1, 0, 0};
    private static final int[] NY = {0, 0, -1, 1};
    
    private static int max = Integer.MIN_VALUE;
    private static int[][] board;
    private static int N, M;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(1, board[i][j], i, j, visited);
                dfsForHShape(i, j);
                visited[i][j] = false;
            }
        }
        
        System.out.println(max);
    }

    // ㅗ 모양을 제외한 나머지 모양을 탐색할 수 있다.
    private static void dfs(int depth, int sum, int i, int j, boolean[][] visited) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        visited[i][j] = true;
        // 상하좌우 DFS 이동
        for (int k = 0; k < 4; k++) {
            int nx = i + NX[k];
            int ny = j + NY[k];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            
            if (!visited[nx][ny]) {
                dfs(depth + 1, sum + board[nx][ny], nx, ny, visited);
            }
        }
        visited[i][j] = false;
    }

    // "ㅗ" 모양의 테트로미노 탐색
    // 가운데 점을 기준으로 상하좌우 탐색
    private static void dfsForHShape(int x, int y) {
        // "ㅗ" 모양
        if (x >= 1 && y >= 1 && y < M - 1) {
            int sum = board[x][y] + board[x-1][y] + board[x][y-1] + board[x][y+1];
            max = Math.max(max, sum);
        }
        // "ㅜ" 모양
        if (x < N - 1 && y >= 1 && y < M - 1) {
            int sum = board[x][y] + board[x+1][y] + board[x][y-1] + board[x][y+1];
            max = Math.max(max, sum);
        }
        // "ㅓ" 모양
        if (x >= 1 && x < N - 1 && y < M - 1) {
            int sum = board[x][y] + board[x][y+1] + board[x-1][y] + board[x+1][y];
            max = Math.max(max, sum);
        }
        // "ㅏ" 모양
        if (x >= 1 && x < N - 1 && y >= 1) {
            int sum = board[x][y] + board[x][y-1] + board[x-1][y] + board[x+1][y];
            max = Math.max(max, sum);
        }
    }
}