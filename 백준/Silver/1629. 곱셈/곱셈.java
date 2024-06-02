import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        
        System.out.println(pow(a, b, c));
    }
    
    /* y의 거듭제곱에 대한 x의 값을 계산 */
    private static long pow(long number, long exponent, int divisor) {
        // 지수가 1인 경우 거듭제곱하지 않는다.
        if (exponent == 1) {
            return number % divisor;
        }
        
        long halfNumber = pow(number, exponent / 2, divisor);
        
        // 현재 지수가 홀수라면 number를 한 번 더 곱해준다.
        if (exponent % 2 == 1) {
            return (halfNumber * halfNumber % divisor) * number % divisor;
        }
        
        return halfNumber * halfNumber % divisor;
    }
}