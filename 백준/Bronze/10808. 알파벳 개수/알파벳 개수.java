import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] alphabets = new int[26];
        String input = br.readLine();
        
        for (int i = 0; i < input.length(); i++) {
            char alphabet = input.charAt(i);
            alphabets[alphabet - 97]++;
        }
        
        for (int i = 0; i < 26; i++) {
            System.out.print(alphabets[i] + " ");
        }
    }
}