import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] people = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            
            people[i][0] = Integer.parseInt(input[0]);
            people[i][1] = Integer.parseInt(input[1]);
        }
        
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                
                if (people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    result[i]++;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print((result[i] + 1) + " ");
        }
    }
}