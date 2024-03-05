import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        int[][] board = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        int[][][] dp = new int[n][m][3];
        // dp 첫 시작 줄을 초기화한다.
        for (int i = 0; i < m; i++) {
            dp[0][i][0] = board[0][i];
            dp[0][i][1] = board[0][i];
            dp[0][i][2] = board[0][i];
        }
        
        // 나머지 줄은 최댓값으로 채운다.
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j][0] = Integer.MAX_VALUE;
                dp[i][j][1] = Integer.MAX_VALUE;
                dp[i][j][2] = Integer.MAX_VALUE;
            }
        }
        
        // dp
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    dp[i][j][1] = board[i][j] + Math.min(dp[i - 1][j][0], dp[i - 1][j][2]);
                    dp[i][j][2] = board[i][j] + Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]);
                } else if (j == m - 1) {
                    dp[i][j][0] = board[i][j] + Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]);
                    dp[i][j][1] = board[i][j] + Math.min(dp[i - 1][j][0], dp[i - 1][j][2]);
                } else {
                    dp[i][j][0] = board[i][j] + Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]);
                    dp[i][j][1] = board[i][j] + Math.min(dp[i - 1][j][0], dp[i - 1][j][2]);
                    dp[i][j][2] = board[i][j] + Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]);
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                min = Math.min(dp[n - 1][i][j], min);
            }
        }
        
        System.out.println(min);
    }
}