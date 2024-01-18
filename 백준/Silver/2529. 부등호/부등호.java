import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    static List<String> answers = new ArrayList<>();
    static int[] numbers;  // 숫자의 개수는 부등호의 개수 + 1
    static boolean[] visited = new boolean[10];
    static String[] inequalities;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        inequalities = br.readLine().split(" ");
        numbers = new int[n + 1];   // 숫자의 개수는 부등호의 개수 + 1
        
        Arrays.fill(numbers, -1);
        
        dfs(0);
        
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        int maxLength = -1;
        
        for (String answer : answers) {
            max = Math.max(max, Long.parseLong(answer));
            min = Math.min(min, Long.parseLong(answer));
            maxLength = Math.max(maxLength, answer.length());
        }
        
        System.out.println(String.format("%0" + maxLength + "d", max));
        System.out.println(String.format("%0" + maxLength + "d", min));
    }
    
    private static void dfs(int numberIndex) {
        if (numberIndex == n + 1) {
            answers.add(numberToString());
            return;
        }
        
        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                if (numberIndex == 0) {
                    // 첫번째의 경우 일단 넣고 본다.
                    numbers[numberIndex] = i;
                    visited[i] = true;
                    dfs(numberIndex + 1);
                    visited[i] = false;
                } else {
                    // 마지막 인덱스의 경우 자기 자신 위치  - 1
                    if (inequalities[numberIndex - 1].equals("<") && numbers[numberIndex - 1] < i) {
                        numbers[numberIndex] = i;
                        visited[i] = true;
                        dfs(numberIndex + 1);
                        visited[i] = false;
                    } else if (inequalities[numberIndex - 1].equals(">") && numbers[numberIndex - 1] > i) {
                        numbers[numberIndex] = i;
                        visited[i] = true;
                        dfs(numberIndex + 1);
                        visited[i] = false;
                    }
                }
            }
        }
    }
    
    private static String numberToString() {
        StringBuilder number = new StringBuilder();
        
        for (int num : numbers) {
            number.append(num);
        }
        
        return number.toString();
    }
}