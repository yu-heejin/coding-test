import java.util.Scanner;
import java.util.ArrayList;

//n == a * k, a != 1 || a != n
// 들어오는 값 중 최대 값과 최소 값만 받아서 곱하면 해당 수가 나온다 (천재들인가..)
// 어짜피 약수니까 곱해서 같은 값 나오면 끝남
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0;
        int min = 1000000;
        int max = 2;
        
        int n = sc.nextInt();
        do {
            int a = sc.nextInt();
            arr.add(a);
            //System.out.println(arr.get(i));
            i++;
            
            if(min >= a) min = a;
            if(max <= a) max = a;
        } while(sc.hasNextInt());
        
        System.out.println(min * max);
    }
}