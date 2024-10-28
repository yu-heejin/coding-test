import java.util.*;
import java.io.*;

public class Main {
    
    private static final int[] MOVE_X = {-1, 1, 0, 0};
    private static final int[] MOVE_Y = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(board, N, M));
    }

    private static int bfs(int[][] board, int N, int M) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        q.add(new int[] {0, 0, 1});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] == N - 1 && curr[1] == M - 1) {
                return curr[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + MOVE_X[i];
                int ny = curr[1] + MOVE_Y[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] == 0) continue;

                q.add(new int[] {nx, ny, curr[2] + 1});
                visited[nx][ny] = true;
            }
        }

        return -1;
    }
}