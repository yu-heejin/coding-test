import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int year = sc.nextInt();
        int flag = 0;
        
        if(year % 4 == 0) {
            if(year % 100 != 0 || year % 400 == 0) {
                flag = 1;
            }
        }
        
        System.out.println(flag);
        
        sc.close();
    }
}