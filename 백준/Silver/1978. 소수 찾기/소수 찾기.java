import java.util.Scanner;

public class Main {
    public static boolean isCheck(int a) {
        for(int i=2; i<a; i++) {
            if(a % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int count = 0;
        
        //소수 : 약수가 1과 자기 자신밖에 없는 경우
        for(int i=1; i<=n; i++) {
            int k = sc.nextInt();
            if(k != 1 && isCheck(k) == true) {
                count++;
            }
        }
        
        System.out.println(count);
        sc.close();
        
        //총 시간복잡도 O(n^2)
        //시간제한 2초라 이렇게 풀었지만 더 괜찮은 방법을 찾을 필요가 있음
        //참고로 1은 소수가 아니다.
    }
}