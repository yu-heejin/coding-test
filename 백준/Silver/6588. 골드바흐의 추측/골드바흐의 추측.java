import java.io.*;
import java.util.Arrays;

public class Main {
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 100만에 대한 소수 판별을 미리 해둔다.
        boolean[] isPrime = new boolean[1000001];
            
        Arrays.fill(isPrime, true);
        
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int i = 2; i <= Math.sqrt(1000000); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 1000000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        while (true) {
            int n = Integer.parseInt(br.readLine());
            
            if (n == 0) break;
            
            // 두 수의 차가 가장 작은 수
            int a = 2;
            boolean isWrong = true;
            
            while (a <= n) {
                int b = n - a;
                
                // 두 수가 모두 소수인 경우
                if (isPrime[a] && isPrime[b]) {
                    System.out.println(n + " = " + a + " + " + b);
                    isWrong = false;
                    break;
                }
                
                a++;
            }
            
            if (isWrong) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }
}