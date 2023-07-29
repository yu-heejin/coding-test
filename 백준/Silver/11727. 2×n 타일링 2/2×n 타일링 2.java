import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    // 다시 풀어볼 문제
    public static int returnDPValue(int index) {
        if (index == 1) {
            return 1;
        }
        
        if (index == 2) {
            return 3;
        }
        
        if (index == 3) {
            return 5;
        }
        
        return 0;
    }
    
    public static int[] initDPArray(int[] dp, int width) {
        for (int i = 0; i <= width; i++) {
            dp[i] = returnDPValue(i);
        }
        
        return dp;
    }
    
    public static int countCalculationResult(int[] dp, int width) {
        for (int i = 4; i <= width; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
            // 2x2 정사각형이 추가된 경우
        }
        
        return dp[width];
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int width = Integer.parseInt(reader.readLine());
        int[] dp = new int[width + 1];
        
        dp = initDPArray(dp, width);
        
        System.out.println(countCalculationResult(dp, width));
    }
}