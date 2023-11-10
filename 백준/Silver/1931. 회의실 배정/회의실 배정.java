import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] meeting = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            meeting[i][0] = Integer.parseInt(input[0]);
            meeting[i][1] = Integer.parseInt(input[1]);
        }
        
        Arrays.sort(meeting, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            }
            
            return o1[0] - o2[0];
        });
        
        int end = meeting[0][1];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (end <= meeting[i][0]) {
                end = meeting[i][1];
                count++;
            }
        }
        
        System.out.println(count);
    }
}