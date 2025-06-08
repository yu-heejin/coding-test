import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] step = new int[n];
        int[] dp = new int[n];   // 각 리스트에서 최대값을 담을 배열

        for (int i = 0; i < n; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = step[0];
        // 예외처리 - 계단의 개수는 300 이하의 자연수
        if (n == 2) {
            dp[1] = step[0] + step[1];
        } else if (n > 2) {
            dp[1] = step[0] + step[1];
            // 전칸 밟는 경우, 전전칸 밟는 경우
            // 마지막 계단은 꼭 밟아야하는 조건이 있어 마지막 계단은 필수로 밟아야한다.
            dp[2] = Math.max(step[2] + step[0], step[1] + step[2]);
    
            for (int i = 3; i < n; i++) {
                // 마지막 계단은 필수로 밟아야한다.
                dp[i] = Math.max(dp[i-2] + step[i], dp[i-3] + step[i-1] + step[i]);
            }
        }

        System.out.println(dp[n-1]);
    }
}