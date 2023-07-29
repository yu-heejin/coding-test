import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int x = sc.nextInt();
        int deno = 2;   //분모
        int nu = 1;   //분자
        int line = 2;   //라인
        int count = 1;  //이동 횟수
        int sum = 4;  //누적합
        int s = 3;

        if(x == 1) System.out.println("1/1");
        else {
            for(int i=2; i<x; i++) {
                count++;
                if(count == sum-1) {
                    line++;
                    if(line % 2 == 0) {
                        deno++;
                    } else {
                        nu++;
                    }
                    sum += s;
                    s++;
                } else if(line % 2 == 0) {
                    deno--;
                    nu++;
                } else {
                    deno++;
                    nu--;
                }
                
            }
            
            System.out.println(nu + "/" + deno);
        }
        
    }
}