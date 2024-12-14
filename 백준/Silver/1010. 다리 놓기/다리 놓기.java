import java.util.*;
import java.io.*;

class Main {
    static long count = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        // N, M (0 < N ≤ M < 30)이 주어진다.
        int[][] combination = new int[31][31];

        // nCn == nC0 == 1
        for (int i = 1; i <= 30; i++) {
            combination[i][0] = 1;
            combination[i][i] = 1;
        }

        // nCr = n-1Cr-1 + n-1Cr
        for (int i = 2; i <= 30; i++) {
            for (int j = 1; j <= 30; j++) {
                combination[i][j] = combination[i-1][j-1] + combination[i-1][j];
            }
        }

        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");

            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            System.out.println(combination[M][N]);
        }
    }

    // nCr = n-1Cr-1 + n-1Cr - 재귀 시간초과
    // private static long dp(int n, int r, long[][] dp) {
    //     // nC0 == nCn == 1
    //     if(n == r || r == 0) {
    //         dp[n][r] = 1;
    //         return dp[n][r];
    //     }
        
    //     if (dp[n][r] > 0) {
    //         return dp[n][r];
    //     }

    //     return dp(n - 1, r - 1, dp) + dp(n - 1, r, dp);
    // }

    

    // nCr - 시간 초과 코드
    // private static void combination(int[] bucket, int n, int r) {
    //     if (r == 0) {
    //         count++;
    //         return;
    //     }

    //     int lastIndex = bucket.length - r - 1;
    //     int smallest = 0;

    //     // 가장 마지막에 뽑힌 수보다 큰 값을 뽑는다.
    //     if (bucket.length > r) {
    //         smallest = bucket[lastIndex] + 1;
    //     }

    //     for (int i = smallest; i < n; i++) {
    //         bucket[lastIndex + 1] = i;
    //         combination(bucket, n, r - 1);
    //     }
    // }
}