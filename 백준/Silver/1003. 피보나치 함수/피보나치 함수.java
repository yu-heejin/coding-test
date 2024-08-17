import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        // get fibonacci
        int[] fibo = new int[41];
        
        fibo[0] = 0;
        fibo[1] = 1;
        
        for (int i = 2; i <= 40; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
        
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            
            if (N == 0) {
                System.out.println("1 0");
            } else {
                System.out.println(fibo[N-1] + " " + fibo[N]);
            }
        }
    }
    
/* timeout code
    private static int fibo(int n) {
        if (dp[n] != -1) {
            return dp[n];
        }
        
        if (n == 0) {
            count0++;
            return 0;
        }
        
        if (n == 1) {
            count1++;
            return 1;
        }
        
        return fibo(n - 1) + fibo(n - 2);
    }
*/
}