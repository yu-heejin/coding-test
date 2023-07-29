import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int x = sc.nextInt();   //case는 예약어이기 때문에 변수명으로 사용하면 안됨
        for(int i=0; i<x; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            System.out.println(a + b);
        }
    }
}
