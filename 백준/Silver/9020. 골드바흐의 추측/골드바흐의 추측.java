import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            
            // 해당 수를 반으로 나눈다. (두 소수의 차이가 가장 작은 것을 출력)
            int a = n / 2;
            
            while (a >= 2) {
                int b = n - a;
                
                // 두 수가 소수인 경우
                if (isPrime(a) && isPrime(b)) {
                    System.out.println(a + " " + b);
                    break;
                }
                
                a--;
            }
        }
    }
    
    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}