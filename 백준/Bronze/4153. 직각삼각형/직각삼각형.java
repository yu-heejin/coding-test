import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      /* 작은 두 변들의 제곱은 가장 긴 변의 제곱과 같다. */
      while (true) {
          String[] input = br.readLine().split(" ");
          
          if (stopWhile(input)) break;
          
          int[] numbers = new int[3];
          
          for (int i = 0; i < 3; i++) {
              numbers[i] = Integer.parseInt(input[i]);
          }
          
          Arrays.sort(numbers);
          
          if (isRightTriangle(numbers)) {
              System.out.println("right");
          } else {
              System.out.println("wrong");
          }
      }
  }
  
  private static boolean stopWhile(String[] input) {
      for (int i = 0; i < 3; i++) {
          if (!input[i].equals("0")) return false;
      }
      
      return true;
  }
  
  private static boolean isRightTriangle(int[] numbers) {
      return Math.pow(numbers[2], 2) == (Math.pow(numbers[1], 2) + Math.pow(numbers[0], 2))
        ? true
        : false;
  }
}