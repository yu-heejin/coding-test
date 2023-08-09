import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int[] area = { 0, 0 };
        String numbers = reader.readLine();
        int start = numbers.charAt(0) - '0';
        
        area[start]++;
        
        for (int i = 1; i < numbers.length(); i++) {
            int current = numbers.charAt(i) - '0';
            
            if (start != current) {
                area[current]++;
                start = current;
            }
        }
        
        System.out.println(Math.min(area[0], area[1]));
    }
}