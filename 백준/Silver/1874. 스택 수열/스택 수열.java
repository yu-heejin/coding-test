import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[n];
        int index = 0;
        int number = 1;
        
        List<String> answers = new ArrayList<>();
        boolean isPossible = true;
        while (index < n) {
            if (stack.isEmpty()) {
                answers.add("+");
                stack.push(number);
                number++;
            } else if (stack.peek() == arr[index]) {
                // 스택에 내가 원하는 값이 있는 경우 pop
                answers.add("-");
                int next = stack.pop();
                answer[index] = next;
                index++;
            } else if (stack.peek() > arr[index]) {
                System.out.println("NO");
                isPossible = false;
                break;
            }
            else {
                // 내가 원하는 숫자가 아닌 경우
                answers.add("+");
                stack.push(number);
                number++;
            }
        }
        
        if (isPossible) {
            for (String a : answers) {
                System.out.println(a);
            }
        }
    }
}