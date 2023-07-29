import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int min = 1000000;
        int max = -1000000;
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            
            if(arr[i] <= min) {
                min = arr[i];
            }
            
            if(arr[i] >= max) {
                max = arr[i];
            }
        }
        
        System.out.println(min + " " + max);
        
        sc.close();
    }
}