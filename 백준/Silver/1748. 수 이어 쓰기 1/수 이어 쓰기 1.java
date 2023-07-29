import java.util.Scanner;
// **다시 풀어봐야 할 문제
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int count = 0;
        //단순히 문자열만 이어붙였더니 메모리 초과가 났다
        //효율적으로 자리수만 생각하여 구하면 좋다
        //n이 주어졌을 때, n까지의 숫자가 몇자리 수인지 구하면 된다.
        //N-1+1
        //ex) 15가 주어졌을 때
        //15-1+1 = 15
        //15-10+1 = 6
        
        for(int i=1; i<=n; i*=10) {
            count += n - i + 1;
        }
        
        System.out.println(count);
    }
}