import java.io.*;
import java.util.*;

public class Main {
    
    static int[][] board;
    static int n;
    static long[][] dp;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dp = new long[n][n];
        
        String[] input;
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        dp(0, 0);
        
        System.out.println(dp[n-1][n-1]);
    }
    
    private static void dp(int x, int y) {
        // 출발 지점으로 가는 방법은 일단 1가지 방법
        dp[x][y] = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 해당 위치로 가는 방법이 아직 없고, 마지막 위치면 넘긴다.
                // 목적지일 경우 건너뛰는 이유는 목적지의 블록 수는 0이기 떄문에 목적지에 도착할 경우 자기 자신 ++을 두번 더 하기 떄문이다.
                if (dp[i][j] == 0 || i == n - 1 && j == n - 1) continue;
                
                // 현재 위치에서 건너 뛸 크기
                int jump = board[i][j];
                // 아래쪽으로 이동하는 경우
                int moveDown = i + jump;
                // 오른쪽으로 이동하는 경우
                int moveRight = j + jump;
                
                // 아래쪽으로 이동 가능한 경우 + 1
                // 해당 위치에서 가는 경우의 수를 더해준다.
                if (moveDown < n) {
                    dp[moveDown][j] += dp[i][j];
                }
                
                // 오른쪽으로 이동 가능한 경우 + 1
                if (moveRight < n) {
                    dp[i][moveRight] += dp[i][j];
                }
            }
        }
    }
}