import java.util.*;
import java.io.*;

public class Main {
    
    static String[] input;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][];
        int[][] dp = new int[n][];
        
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            board[i] = new int[input.length];
            dp[i] = new int[input.length];
            for (int j = 0; j < input.length; j++) {
                board[i][j] = Integer.parseInt(input[j]);
                dp[i][j] = board[i][j];
            }
        }
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                dp[i][j] = Math.max(dp[i + 1][j] + dp[i][j], dp[i + 1][j + 1] + dp[i][j]);
            }
        }
        
        System.out.println(dp[0][0]);
    }
}