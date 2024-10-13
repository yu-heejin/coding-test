import java.util.*;
import java.io.*;

public class Main {

    private static int N, M;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        for (int i = 1; i <= N; i++) {
            int[] numbers = new int[M];
            boolean[] visited = new boolean[N];

            numbers[0] = i;
            visited[i-1] = true;
            getNumber(1, 1, numbers, visited);
            numbers[0] = 0;
            visited[i-1] = false;
        }
    }

    private static void getNumber(int depth, int number, int[] numbers, boolean[] visited) {
        if (depth == M) {
            for (int i = 0; i < numbers.length; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            if (!visited[i - 1]) {
                visited[i - 1] = true;
                numbers[depth] = i;
                getNumber(depth + 1, i, numbers, visited);
                numbers[depth] = 0;
                visited[i - 1] = false;
            }
        }
    }
}