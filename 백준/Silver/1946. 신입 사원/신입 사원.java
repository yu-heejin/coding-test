import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            int people = Integer.parseInt(br.readLine());
            int[][] results = new int[people][2];
            int count = 1;
            
            for (int j = 0; j < people; j++) {
                String[] scores = br.readLine().split(" ");
                results[j][0] = Integer.parseInt(scores[0]);
                results[j][1] = Integer.parseInt(scores[1]);
            }
            
            Arrays.sort(results, (o1, o2) -> {
                return o1[0] - o2[0];
            });
            
            int min = results[0][1];
            for (int j = 1; j < people; j++) {
                if (min > results[j][1]) {
                    count++;
                    min = results[j][1];
                }
            }
            
            System.out.println(count);
        }
    }
}