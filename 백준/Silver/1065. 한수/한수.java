//입력값 보다 작거나 같은 수까지의 한수를 모두 구한다
//ex) 110 -> 1~110까지의 숫자 중에서 등차수열이 가능한 수의 개수
import java.util.Scanner;

public class Main {
    public static int han(int n) {
        int count = 0;
        int[] arr = new int[3];
        int j = 0;
       
        for(int i=1; i<=n; i++) {
            j=0;
            if(i == 1000) break;
            if(i>=1 && i<=99) {
                count++;
                //01~09 : d가 1~9
                //10~99 : d가 10의 자리 - 1의 자리
            } else {
                int tmp = i;   //n이 아니라 i!!!!!!!!!!
                while(tmp != 0) {
                    arr[j] = tmp % 10;
                    j++;
                    tmp /= 10;
                }
               
                //1000은 한수가 될 수 없다
                if(arr[2]-arr[1] == arr[1]-arr[0]) count++;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        System.out.println(han(n));
    }
}