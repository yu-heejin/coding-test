import java.io.*;
import java.util.*;

public class Main {
    private static final int[] nextX = {-1, 1, 0, 0};
    private static final int[] nextY = {0, 0, -1, 1};
    
    private static int N, M;
    private static int max = Integer.MIN_VALUE;
    
  public static void main(String args[]) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      String[] input = br.readLine().split(" ");
      
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
      
      int[][] board = new int[N][M];
      
      for (int i = 0; i < N; i++) {
          input = br.readLine().split(" ");
          for (int j = 0; j < M; j++) {
              board[i][j] = Integer.parseInt(input[j]);
          }
      }
      
      dfs(board, 0);
      
      System.out.println(max);
  }
  
  /* Backtracking: 모든 경우의 수에서 벽을 세움 */
  private static void dfs(int[][] board, int depth) {
      if (depth == 3) {
          // 3개의 벽을 모두 놓은 경우 BFS
          int[][] temp = new int[N][M];
          
          for (int i = 0; i < N; i++) {
              for (int j = 0; j < M; j++) {
                  temp[i][j] = board[i][j];
              }
          }
          
          bfs(temp);
          return;
      }
      
      for (int i = 0; i < N; i++) {
          for (int j = 0; j < M; j++) {
              if (board[i][j] == 0) {
                  board[i][j] = 1;
                  dfs(board, depth + 1);
                  board[i][j] = 0;
              }
          }
      }
  }
  
  /* BFS: 바이러스가 퍼지는 위치 확인 */
  private static void bfs(int[][] board) {
      Queue<int[]> q = new LinkedList<>();
      boolean[][] visited = new boolean[N][M];
      
      // 바이러스가 있는 모든 위치를 저장
      for (int i = 0; i < N; i++) {
          for (int j = 0; j < M; j++) {
              if (board[i][j] == 2) {
                  q.add(new int[] { i, j });
                  visited[i][j] = true;
              }
          }
      }
      
      while (!q.isEmpty()) {
          int[] curr = q.poll();
          
          // 상하좌우로 돌면서 빈칸이면 전염
          for (int i = 0; i < 4; i++) {
              int nx = curr[0] + nextX[i];
              int ny = curr[1] + nextY[i];

              if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
              
              if (!visited[nx][ny] && board[nx][ny] == 0) {
                  board[nx][ny] = 2;
                  q.add(new int[] { nx, ny });
                  visited[nx][ny] = true;
              }
          }
      }
      
      // 안전 구역이 몇개나 있는지 확인 후 갱신
      int sum = 0;
      for (int i = 0; i < N; i++) {
          for (int j = 0; j < M; j++) {
              if (board[i][j] == 0) {
                  sum++;
              }
          }
      }
      
      max = Math.max(max, sum);
  }
}