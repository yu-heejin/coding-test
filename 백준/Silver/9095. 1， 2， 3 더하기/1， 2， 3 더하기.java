import java.util.Scanner;

public class Main {
    // 다시 풀어볼 문제...
    final static int MAX_LENGTH = 11;
    static Scanner sc = new Scanner(System.in);
    
    public static int returnDPValue(int index) {
        if (index == 1) {
            return 1;
        }
        
        if (index == 2) {
            return 2;
        }
        
        if (index == 3) {
            return 4;
        }
        
        return 0;
    }
    
    public static int[] initDPArray(int[] dp) {
        for (int i = 0; i <= MAX_LENGTH; i++) {
            dp[i] = returnDPValue(i);
        }
        
        return dp;
    }
    
    public static void initNValue(int t, int[] dp) {
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            printCalculationResult(n, dp);
        }
    }
    
    public static int[] calculationResult(int[] dp) {
        for (int i = 4; i <= MAX_LENGTH; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
            // 패턴을 보면 해당 점화식을 도출할 수 있음
        }
        
        return dp;
    }
    
    public static void printCalculationResult(int n, int[] dp) {
        System.out.println(dp[n]);
    }
    
    public static void main(String[] args) {
        int t = sc.nextInt();
        int[] dp = new int[MAX_LENGTH + 1];
        
        dp = initDPArray(dp);
        dp = calculationResult(dp);
        
        initNValue(t, dp);
        
        sc.close();
    }
}