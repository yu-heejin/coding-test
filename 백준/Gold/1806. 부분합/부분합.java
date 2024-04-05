import java.io.*;
import java.util.*;

public class Main {
    
    static int[] board = new int[100001];
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        
        int[] numbers = new int[n];
        input = br.readLine().split(" ");
        
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        
        int start = 0, end = 0;
        int sum = numbers[0];
        int min = Integer.MAX_VALUE;
        
        while (start <= end && end < n) {
            if (sum >= s) {
                sum -= numbers[start];
                min = Math.min(min, end - start + 1);
                start++;
            } else {
                end++;
                if (end < n) {
                    sum += numbers[end];
                }
            }
        }
        
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}