import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());
    Stack<Integer> s = new Stack<>();
    
    for (int i = 0; i < n; i++) {
        String[] input = br.readLine().split(" ");
        
        switch (input[0]) {
            case "push":
                int value = Integer.parseInt(input[1]);
                s.push(value);
                break;
            case "pop":
                if (s.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(s.pop());
                break;
            case "size":
                System.out.println(s.size());
                break;
            case "empty":
                if (s.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
                break;
            case "top":
                if (s.isEmpty())
                    System.out.println(-1);
                else 
                    System.out.println(s.peek());
        }
    }
  }
}