import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 여러 테스트 케이스를 요구하는 조건은 hasNextInt() 메소드를 이용하여 입력값이
        // int인 경우에만 테스트가 되도록 작성
        // 나머지 연산 : (A+B) % C = (A%C + B%C) % C
        // (n * 10 + 1) = ((n * 10) % a + 1 % a) % a
        // 모듈러 연산 : 숫자 범위가 계속해서 커지면 long long을 넘어감
        // 따라서 해당 숫자의 크기가 너무 커지지 않도록 mod 연산 필요
        
        int n = 1;
        int count = 1;   //한 자리수
        
        do {
            int a = sc.nextInt();
            
            while(true) {
                n = n % a;    //%C
                if(n == 0) break;
                n = (n * 10) % a + 1 % a;   //(A%C) + (B%C)
                count++;
            }
            
            System.out.println(count);
            n = 1;
            count = 1;
        } while (sc.hasNextInt());
        
        
        sc.close();
    }
}
