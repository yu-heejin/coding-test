import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0;    //정수 말고 실수
        int max = -1;
        
        int n = sc.nextInt();
        int[] scores = new int[n];
        
        for(int i=0; i<n; i++) {
            scores[i] = sc.nextInt();
            
            if(scores[i] > max) {
                max = scores[i];
            }
        }
        
        for(int i=0; i<n; i++) {
            sum += (double)scores[i] / max * 100;
        }
        
        System.out.println(sum / n);
        sc.close();
    }
}