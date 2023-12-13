import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        // 알파벳은 26자
        int[] result = new int[26];
        
        for (int i = 0; i < n; i++) {
            char[] alpha = br.readLine().toCharArray();
            
            for (int j = 0; j < alpha.length; j++) {
                result[alpha[j] - 65] += Math.pow(10, alpha.length - 1 - j);
            }
        }
        
        // 큰 순서대로 정렬
        Arrays.sort(result);
        
        long sum = 0;
        int start = 9;
        for (int i = 25; i >= 0; i--) {
            sum += (start * result[i]);
            start--;
        }
        
        System.out.println(sum);
    }
}