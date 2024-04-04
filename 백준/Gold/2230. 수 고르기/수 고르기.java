import java.io.*;
import java.util.*;

public class Main {
    
    static int[] board = new int[100001];
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        int[] numbers = new int[n];
        
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(numbers);
        int start = 0, end = 0;
        int min = Integer.MAX_VALUE;
        
        while (start < n && end < n) {
            int minus = numbers[end] - numbers[start];
            
            if (minus < m) {
                end++;
            } else {
                min = Math.min(minus, min);
                start++;
            }
        }
        
        System.out.println(min);
    }
}