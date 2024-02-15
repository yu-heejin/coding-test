import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        for (int test = 1; test <= t; test++) {
            int n = Integer.parseInt(br.readLine());
            
            int[][] sticker = new int[2][n];
            int[][] dp = new int[2][n];
            
            for (int i = 0; i < 2; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    sticker[i][j] = Integer.parseInt(input[j]);
                }
            }
            
            if (n == 1) {
                System.out.println(Math.max(sticker[0][0], sticker[1][0]));
                continue;
            }
            
            // 위 스티커를 떼는 경우와 안 떼는 경우 두 가지로 나누어 살펴본다.
            // 맨 앞 칸은 자기 자신을 떼는 경우
            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            // 그 다음 칸은 대각선 수를 더한 값
            dp[0][1] = dp[1][0] + sticker[0][1];
            dp[1][1] = dp[0][0] + sticker[1][1];
            
            for (int i = 2; i < n; i++) {
                // 세번째 칸 부터 이전에 어떤 것을 뜯어야 더 큰 값을 얻을 수 있는지?
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
            }
            
            System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
        }
    }
}