import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static boolean[] arr = new boolean[1000001];
    
    public static void eratosthenes() {
        Arrays.fill(arr, true);
        
        arr[1] = false;
        
        for(int i=2; i<=1000000; i++) {
            for(int j=i*2; j<=1000000; j+=i) {
                arr[j] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        // 4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.
        Scanner sc = new Scanner(System.in);
        eratosthenes();
        
        boolean flag = false;
        //입력은 하나 또는 그 이상의 테스트 케이스로 이루어져 있다.
        //b-a의 값이 가장 커야한다. -> 가장 큰 수에서 감소시켜가면서 구한다.
        do {
            int n = sc.nextInt();
            
            for(int i=1; i<=n; i++) {
                if((arr[n-i] == true) && (arr[i] == true)) {
                    //System.out.println(n-i);
                    System.out.println(n + " = " + i + " + " + (n-i));
                    flag = true;
                    break;
                }
            }
        } while(sc.hasNextInt());
        
        if(!flag) System.out.println("Goldbach's conjecture is wrong.");
    }
}