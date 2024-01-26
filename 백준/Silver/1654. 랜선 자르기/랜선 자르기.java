import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        long[] length = new long[k];
        long max = -1;
        
        for (int i = 0; i < k; i++) {
            length[i] = Long.parseLong(br.readLine());
            max = Math.max(max, length[i]);
        }
        
        long low = 1;
        long high = max;
        
        long mid = (low + high) / 2;
        while (low <= high) {
            // 해당 길이로 만들 수 있는 랜선의 길이
            long count = 0;
            for (long l : length) {
                count += (l / mid);
            }
            
            if (count >= n) {
                // 내가 원하는 길이보다 더 만들 수 있는 경우
                // 너무 작게 잘라졌음을 의미하므로 길이의 범위 증가
                low = mid + 1;
            } else {
                // 내가 원하는 길이만큼 만들 수 없는 경우
                // 너무 크게 잘렸기 때문에 길이를 줄인다.
                high = mid - 1;
            }
            
            mid = (low + high) / 2;
        }
        
        System.out.println(mid);
    }
}