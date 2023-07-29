//문제 잘못 읽어서 2단만 출력하는 줄 알았다..
//n을 입력받아야한다.
//Scanner import를 빼먹었다

import java.util.Scanner;

public class Main {
    //Scanner sc = new Scanner(System.in);
    //int n = sc.nextInt();
    //non-static variable n cannot be referenced from a static context
    //메인 메소드에다가 써라 좀!!!!!!!!!!!!!!!!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i=1; i<=9; i++) {   //i를 2부터 써서 틀린듯
          System.out.println(n + " * " + i + " = " + n * i);
            //i를 왜 j로 써 ㅠㅠㅠㅠ
            //진짜 마지막..ln빼먹음..
        }
        
        sc.close();
    }
    
    //sc.close();
    //메인 메소드가 아닌 일반 클래스 내에서 실행하려고 하니 오류가 발생함
}