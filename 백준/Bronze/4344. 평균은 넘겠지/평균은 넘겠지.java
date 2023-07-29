import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int c = sc.nextInt();
        int n, count = 0;
        double sum = 0;
        int[] scores;
        
        for(int i=0; i<c; i++) {
            n = sc.nextInt();
            scores = new int[n];
            for(int j=0; j<n; j++) {
                scores[j] = sc.nextInt();
                sum += scores[j];
            }
            
            double av = sum / n;
            //System.out.println(av);
            
            for(int j=0; j<n; j++) {
                if(av < scores[j]) {
                    count++;
                }
            }
            
            double percent = (double)count / (double)n * 100;
            System.out.println(String.format("%.3f", percent) + "%");
            sum = 0;
            count = 0;
        }
    }
}