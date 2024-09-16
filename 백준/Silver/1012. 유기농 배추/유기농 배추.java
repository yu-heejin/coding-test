import java.util.*;
import java.io.*;

public class Main {
  private static int M, N;
  private static int[][] field;
    
  public static void main(String args[]) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int T = Integer.parseInt(br.readLine());
      
      for (int i = 0; i < T; i++) {
          String[] input = br.readLine().split(" ");
          
          M = Integer.parseInt(input[0]);
          N = Integer.parseInt(input[1]);
          int K = Integer.parseInt(input[2]);
          
          field = new int[N][M];
          
          for (int j = 0; j < K; j++) {
              input = br.readLine().split(" ");
              
              int X = Integer.parseInt(input[0]);
              int Y = Integer.parseInt(input[1]);
              
              field[Y][X] = 1;
          }
          
          boolean[][] visited = new boolean[N][M];
          int count = 0;
          
          for (int j = 0; j < N; j++) {
              for (int k = 0; k < M; k++) {
                  if (field[j][k] == 1 && dfs(j, k, visited)) {
                      count++;
                  }
              }
          }
          
          System.out.println(count);
      }
  }
  
  private static boolean dfs(int y, int x, boolean[][] visited) {
      // 범위를 벗어난 경우 방문할 수 없다.
      if (y < 0 || y >= N || x < 0 || x >= M) return false;
      
      // 이미 방문한 경우 방문할 필요가 없다.
      if (visited[y][x]) return false;
      
      // 0인 경우 방문하지 말 것
      if (field[y][x] == 0) return false;
      
      visited[y][x] = true;
      
      // 상하좌우 탐색
      dfs(y - 1, x, visited);
      dfs(y + 1, x, visited);
      dfs(y, x - 1, visited);
      dfs(y, x + 1, visited);
      
      // 문제없으면 true
      return true;
  }
}