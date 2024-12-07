import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] houses = new int[N][3];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < 3; j++) {
                houses[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 해당 색으로 칠했을 때의 최소값의 합
        int[][] dp = new int[N][3];

        // 첫번째 집의 최소값
        for (int i = 0; i < 3; i++) {
            dp[0][i] = houses[0][i];
        }

        // 이후 집의 최소값
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i-1][1] + houses[i][j], dp[i-1][2] + houses[i][j]);
                } else if (j == 1) {
                    dp[i][j] = Math.min(dp[i-1][0] + houses[i][j], dp[i-1][2] + houses[i][j]);
                } else if (j == 2) {
                    dp[i][j] = Math.min(dp[i-1][0] + houses[i][j], dp[i-1][1] + houses[i][j]);
                }
            }
        }

        // 최종 최솟값
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            result = Math.min(result, dp[N-1][i]);
        }

        System.out.println(result);
    }
}