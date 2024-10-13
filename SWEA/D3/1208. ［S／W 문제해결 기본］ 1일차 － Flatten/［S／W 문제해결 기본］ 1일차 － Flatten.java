import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //int T = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= 10; i++) {
        	int dump = Integer.parseInt(br.readLine());  // 덤프 횟수
        	String[] input = br.readLine().split(" ");  // 각 상자의 높이
            
            int[] blocks = new int[input.length];
            
            for (int j = 0; j < input.length; j++) {
                blocks[j] = Integer.parseInt(input[j]);
            }

            
            while (dump > 0) {
                int max = Integer.MIN_VALUE;
                int maxIndex = 0;
                int min = Integer.MAX_VALUE;
                int minIndex = 0;
                
                for (int j = 0; j < input.length; j++) {
                    if (blocks[j] > max) {
                        max = blocks[j];
                        maxIndex = j;
                    }
                    if (blocks[j] < min) {
                        min = blocks[j];
                        minIndex = j;
                    }
            	}
                
                blocks[maxIndex]--;
                blocks[minIndex]++;
                
                dump--;
            }
            
            int max = Integer.MIN_VALUE;
            int maxIndex = 0;
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < input.length; j++) {
                if (blocks[j] > max) {
                    max = blocks[j];
                    maxIndex = j;
                }
                if (blocks[j] < min) {
                    min = blocks[j];
                    minIndex = j;
                }
            }

            System.out.println("#" + i + " " + (max - min));
        }
    }
}