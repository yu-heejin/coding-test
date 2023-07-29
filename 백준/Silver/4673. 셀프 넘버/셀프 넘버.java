import java.util.Arrays;

public class Main {
    public static int d(int n) {
        int sum = 0;
        
        sum += n;
        while(n != 0) {
            sum += n % 10;
            n /= 10;
            //나머지 값을 이용하면 각 자릿수를 역순으로 분리할 수 있다.
        }
        return sum;
    }
    
    public static void main(String[] args) {
        boolean[] check = new boolean[10000];
        int checkNum;
        
        Arrays.fill(check, false);
        for(int i=0; i<10000; i++) {
            checkNum = d(i+1);
            if(checkNum != 0 && checkNum <= 10000) {
                check[checkNum-1] = true;
            }
        }
        
        for(int i=0; i<10000; i++) {
            if(!check[i]) {
                System.out.println(i+1);
            }
        }
    }
}