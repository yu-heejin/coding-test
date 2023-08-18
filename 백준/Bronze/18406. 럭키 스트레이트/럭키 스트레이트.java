import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        int numberSize = input.length();
        
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < numberSize / 2; i++) {
            int front = input.charAt(i);
            int back = input.charAt(numberSize - 1 - i);
            
            leftSum += front;
            rightSum += back;
        }
        
        if (leftSum == rightSum) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}