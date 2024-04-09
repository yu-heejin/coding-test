import java.io.*;
import java.util.*;

public class Main {
    
    static final char[] op = {'+', '-', '*', '/'};
    
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[] bucket;
    static int[] numbers;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        
        int[] operators = new int[4];
        input = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(input[i]);
        }
        
        bucket = new int[n - 1];
        combination(n - 1, 4, operators);
        
        System.out.println(max);
        System.out.println(min);
    }
    
    private static void combination(int r, int n, int[] opCounts) {
        if (r == 0) {
            // 연산
            int result = numbers[0];
            int numberIndex = 1;
            for (int i = 0; i < bucket.length; i++) {
                if (op[bucket[i]] == '+') {
                    result = result + numbers[numberIndex];
                } else if (op[bucket[i]] == '-') {
                    result = result - numbers[numberIndex];
                } else if (op[bucket[i]] == '*') {
                    result = result * numbers[numberIndex];
                } else {
                    if (result < 0) {
                        result = Math.abs(result);
                        result = -(result / numbers[numberIndex]);
                    } else {
                        result = result / numbers[numberIndex];
                    }
                }
                
                numberIndex++;
            }
            
            min = Math.min(result, min);
            max = Math.max(result, max);
        }
        
        int lastIndex = bucket.length - r - 1;
        int smallest = 0;
        
        for (int i = smallest; i < n; i++) {
            if (opCounts[i] == 0) continue;
            bucket[lastIndex + 1] = i;
            opCounts[i]--;
            combination(r - 1, n, opCounts);
            opCounts[i]++;
        }
    }
}