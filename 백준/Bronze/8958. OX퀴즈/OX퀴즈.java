import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        String[] ox = new String[n];
        int score = 0;
        int o = 1;
        sc.nextLine();
        for(int i=0; i<n; i++) {
            ox[i] = sc.nextLine();
            
            for(int j=0; j<ox[i].length(); j++) {
                if(ox[i].charAt(j) == 'O') {
                    if(j == 0) {
                        score += o;
                    } else if(ox[i].charAt(j-1) == 'O') {
                        o++;
                        score += o;
                    } else {
                        o = 1;
                        score += o;
                    }
                }
            }
            
            System.out.println(score);
            o = 1;
            score = 0;
        }
        sc.close();
    }
}