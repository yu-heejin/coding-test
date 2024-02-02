import java.util.*;
import java.io.*;

public class Main {
    
    static boolean[][] visited;
    static int n;
    static int[][] village;
    static int houses = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        String[] input;
        village = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                village[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        visited = new boolean[n][n];
        List<Integer> answers = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && village[i][j] == 1) {
                    dfs(i, j);
                    answers.add(houses);
                } else {
                    houses = 0;
                }
            }
        }
        
        Collections.sort(answers);
        
        System.out.println(answers.size());
        for (int house : answers) {
            System.out.println(house);
        }
    }
    
    private static void dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return;
        }
        
        if (village[x][y] == 1 && !visited[x][y]) {
            visited[x][y] = true;
            houses++;
            
            // 상하좌우 탐색
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            
            return;
        }
    }
}