import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        long sum = 0;
        /*
            n == 9
            f(1) = 1
            f(2) = 1, 2
            f(3) = 1, 3
            f(4) = 1, 2, 4
            f(5) = 1, 5
            f(6) = 1, 2, 3, 6
            f(7) = 1, 7
            f(8) = 1, 2, 4, 8
            f(9) = 1, 3, 9
            
            -> 1=9, 2=4, 3=3, 4=2, 5=1, 6=1, 7=1, 8=1, 9=1
            -> a를 i로 나누었을 때의 몫이 약수의 갯수가 됨
            -> sum은 갯수 * 약수 값을 더해주면 됨
        */
        for(int i=1; i<=a; i++) {
            sum += (a/i) * i;
        }
        
        System.out.println(sum);
    }
}