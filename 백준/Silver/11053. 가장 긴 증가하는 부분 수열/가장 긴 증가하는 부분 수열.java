import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        
        int max = 0;
        int[] dp = new int[n];   // 해당 위치가 마지막일 때의 길이
        Arrays.fill(dp, 1);   // 각 수는 자기 자신을 가지는 부분 수열
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 해당 수를 마지막으로 가지는 수열 중 가장 길이가 긴 수열
                // 시작점을 기준으로 수열을 잡으면 중간에 감소하는 값까지 체크해야함
                // do[i] <= dp[j]를 넣어 최대값일 때만 갱신
                // 즉, 중간에 감소하는 값이 없을 때만 갱신한다,
                if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i]++;
                }
            }
            
            max = Math.max(max, dp[i]);
        }
        
        System.out.println(max);
    }
}