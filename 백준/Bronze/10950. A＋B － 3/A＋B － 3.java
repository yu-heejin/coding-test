import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int x = sc.nextInt();
        int[] num = new int[x * 2];
        
        for(int i=0; i<x * 2; i++) {
            num[i] = sc.nextInt();
        }
        
        for(int i=0; i<x*2; i+=2) {
            System.out.println(num[i] + num[i+1]);
        }
    }
}