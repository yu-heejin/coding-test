import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);    // 스크린
        int m = Integer.parseInt(input[1]);    // 바구니 크기
        
        int[] screen = new int[n + 1];
        
        int start = 1;    // 바구니의 왼쪽
        int end = m;    // 바구니의 오른쪽
        int count = 0;
        
        int j = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < j; i++) {
            int p = Integer.parseInt(br.readLine());
            
            if (p < start) {
                // 사과가 시작 위치보다 이전에 있는 경우
                int move = start - p;
                count += move;
                start = start - move;
                end = end - move;
            } else if (p > end) {
                // 사과가 끝 위치보다 이후에 있는 경우
                int move = p - end;
                count += move;
                end = end + move;
                start = start + move;
            }
        }
        
        System.out.println(count);
    }
}