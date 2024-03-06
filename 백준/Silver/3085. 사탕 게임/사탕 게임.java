import java.io.*;
import java.util.*;

public class Main {
    
    static int maxCandy = Integer.MIN_VALUE;
    static int n;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        String[][] board = new String[n][n];
        
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = input[j];
            }
        }
        
        swap(board);
        
        System.out.println(maxCandy);
    }
    
    private static void swap(String[][] board) {
        // 가로선 swap
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (!board[i][j].equals(board[i][j + 1])) {
                    String temp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = temp;
                    
                    countCandy(board);
                    
                    temp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = temp;
                }
            }
        }
        
        // 세로선 swap
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n - 1; i++) {
                if (!board[i][j].equals(board[i + 1][j])) {
                    String temp = board[i][j];
                    board[i][j] = board[i + 1][j];
                    board[i + 1][j] = temp;
                    
                    countCandy(board);
                    
                    temp = board[i][j];
                    board[i][j] = board[i + 1][j];
                    board[i + 1][j] = temp;
                }
            }
        }
    }
    
    private static void countCandy(String[][] board) {
        // 가로선 최대
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (board[i][j].equals(board[i][j + 1])) count++;
                else count = 1;
                maxCandy = Math.max(maxCandy, count);
            }
        }
        
        // 세로선 최대
        for (int j = 0; j < n; j++) {
            int count = 1;
            for (int i = 0; i < n - 1; i++) {
                if (board[i][j].equals(board[i + 1][j])) count++;
                else count = 1;
                maxCandy = Math.max(maxCandy, count);  // count가 증가할 때마다 갱신
            }
        }
    }
}