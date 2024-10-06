import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      String input = "";
      
      do {
          input = br.readLine();
          
          if (input.equals(".")) break;
          
          Stack<Character> s = new Stack<>();
          boolean isBalanced = true;
          
          for (int i = 0; i < input.length(); i++) {
              char c = input.charAt(i);
              
              if (c == '(' || c == '[') {
                  s.push(c);
              } else if (c == ']' || c == ')') {
                  if (s.size() == 0) {
                      isBalanced = false;
                      break;
                  }
                  
                  char before = s.peek();
                  
                  if ((c == ')' && before == '(') || (c == ']' && before == '[')) {
                      // 짝이 맞는 경우 꺼내기
                      s.pop();
                  } else {
                      isBalanced = false;
                      break;
                  }
              }
          }
          
          // 스택이 비어있지 않은 경우 균형이 맞지 않음
          if (!s.isEmpty()) isBalanced = false;
          
          if (isBalanced) System.out.println("yes");
          else System.out.println("no");
          
      } while (!input.equals("."));
  }
}