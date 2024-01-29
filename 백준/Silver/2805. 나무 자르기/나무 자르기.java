import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        input = br.readLine().split(" ");
        long[] tree = new long[n];
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            tree[i] = Long.parseLong(input[i]);
            max = Math.max(tree[i], max);
        }
        
        // 내가 만들 수 있는 전기톱의 최소 길이와 최대 길이
        long min = 1;
        long mid = (min + max) / 2;
        long maxLength = 0;
        
        while (min <= max) {
            // 해당 길이로 만들 수 있는 나무 길이
            long count = 0;
            for (long t : tree) {
                if (t - mid >= 0) count += (t - mid);
            }
            
            if (count >= m) {
                // 내가 원하는 길이보다 더 길게 만들 수 있는 경우
                // 길이를 늘린다.
                // 이분탐색에서 길이의 최댓값을 구하고 싶은 경우 조건을 count >= m으로 설정한다.
                maxLength = Math.max(mid, maxLength);
                min = mid + 1;
            } else {
                max = mid - 1;
            }
            
            mid = (min + max) / 2;
        }
        
        System.out.println(maxLength);
    }
}