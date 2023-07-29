import java.util.Scanner;

public class Main {
    public static int[] initDPArray(int[] dp, int n) {
        for (int i = 0; i <= n; i++) {
            if (i == 2 || i == 3) {
                dp[i] = 1;
            } else {
                dp[i] = 0;
            }
        }
        
        return dp;
    }
    
    public static int countCalculationResult(int[] dp, int n) {
        // +1을 하는이유는 현재 연산 결과를 반영하기 위함
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i-1] + 1;  // 1을 뺀 경우
            
            if (i % 3 == 0) {   // 3으로 나눠지는 경우
                dp[i] = Math.min(dp[i/3] + 1, dp[i]);
            }
            
            if (i % 2 == 0) {   // 2로 나눠지는 경우
                dp[i] = Math.min(dp[i/2] + 1, dp[i]);
            }
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        
        // 연산 결과 0으로 모두 초기화
        dp = initDPArray(dp, n);

        // 연산 횟수 리턴
        System.out.println(countCalculationResult(dp, n));
        
        sc.close();
    }
}
