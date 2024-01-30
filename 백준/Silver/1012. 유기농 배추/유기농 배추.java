import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] field;
    static int n, m;
    static boolean[][] visited;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        String[] input;
        
        for (int test = 0; test < t; test++) {
            input = br.readLine().split(" ");
            m = Integer.parseInt(input[0]);
            n = Integer.parseInt(input[1]);
            int k = Integer.parseInt(input[2]);
            
            field = new int[n][m];
            visited = new boolean[n][m];
            
            for (int i = 0; i < k; i++) {
                input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                field[y][x] = 1;
            }
            
            int bugs = 0;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dfs(i, j)) bugs++;
                }
            }
            
            System.out.println(bugs);
        }
    }
    
    private static boolean dfs(int y, int x) {
        if (x < 0 || x >= m || y < 0 || y >= n) return false;
        
        if (field[y][x] == 1 && !visited[y][x]) {  // 배추가 존재하는 경우
            visited[y][x] = true;
            dfs(y - 1, x);   // 상
            dfs(y + 1, x);   // 하
            dfs(y, x - 1);   // 좌
            dfs(y, x + 1);   // 우
            
            return true;
        }
        
        return false;
    }
}