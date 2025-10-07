import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][3];   // 사자가 없는 경우/왼쪽에 있는 경우/오른쪽에 있는 경우

        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;    // 사자가 어느 행이든 위치할 수 있다.
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;   // 사자가 왼쪽에 있으면 전 행에는 오른쪽에 있어야 함
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;   // 사자가 오른쪽에 있으면 전 행에는 왼쪽에 있어야 함
        }

        System.out.println((dp[n-1][0] + dp[n-1][1] + dp[n-1][2]) % 9901);
    }
}