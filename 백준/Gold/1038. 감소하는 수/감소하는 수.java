import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    private static List<Long> numbers = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < 10; i++) {
            dfs(i);
        }

        Collections.sort(numbers);

        // 0번째가 있기 때문에 더 커야한다.
        System.out.println(numbers.size() > n ? numbers.get(n) : -1);
    }

    private static void dfs(long number) {
        numbers.add(number);

        long lastNumber = number % 10;

        for (int i = 0; i < lastNumber; i++) {
            dfs(number * 10 + i);
        }
    }
}