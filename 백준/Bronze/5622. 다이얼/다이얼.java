//숫자 1을 걸려면 총 2초가 필요하다
//한 칸 옆에 있는 숫자를 걸기 위해선 1초씩 더 걸린다
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] al = {"ABC", "DEF", "GHI", "JKL", "MNO", 
                       "PQRS", "TUV", "WXYZ"};
        int[] t = {3, 4, 5, 6, 7, 8, 9, 10};
        
        String str = sc.nextLine();
        int time = 0;
        
        for(int i=0; i<str.length(); i++) {
            String a = "" + str.charAt(i);
            for(int j=0; j<al.length; j++) {
                if(al[j].contains(a)) {
                    time += t[j];
                    break;
                }
            }
        }
        
        System.out.println(time);
    }
}