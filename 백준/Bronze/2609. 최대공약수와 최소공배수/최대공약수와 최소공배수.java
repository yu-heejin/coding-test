import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int min = a;
        //int result = 0;   -> by zero
        int result = 1;
        
        if(min > b) min = b;   //더 작은 수까지 반복
        
        for(int i=2; i<=min; i++) {
            if(a % i == 0 && b % i == 0) {
                result = i;
            }
        }   //시간 복잡도 O(n)
        
        System.out.println(result);
        
        //두 수 a, b의 최소 공배수는 a와 b의 곱을 a와 b의 최대 공약수로 나눈 것과 같다
        System.out.println((a * b) / result);
        
        sc.close();
    }
}