import java.util.Scanner;

//1->1 (1)
//2~7->2 (6)
//8~19->3 (12)
//20~37->4 (18)
//38~61->5 (24)
//6개씩 증가하는 모습을 볼 수 있음

//13 -> 3칸, 58 -> 5칸
//시작값 2, 끝값 7부터 시작해서 6의 배수를 더해주면 범위를 찾을 수 있다

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        if(n == 1) System.out.println(n);
        else {
            int count = 2;   //2칸부터 시작
            int start = 2;
            int end = 7;
            
            while(start > n || end < n) {
                //System.out.println(count);
                //if(start <= n && end >= n) break;
                start += 6 * (count-1);
                end += 6 * count;
                
                count++;
            }
            
            System.out.println(count);
        }
        
        sc.close();
    
    }
}