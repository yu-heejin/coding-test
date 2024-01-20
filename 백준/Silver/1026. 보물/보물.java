import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        
        // a 저장
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }
        
        // b 저장
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(input[i]);
        }
        
        // a를 작은 순서대로 배치한다.
        Arrays.sort(a);
        
        boolean[] visited = new boolean[n];   // b 방문 여부
        int answer = 0;
        for(int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            int maxIndex = 0;
            
            for (int j = 0; j < n; j++) {
                if (!visited[j] && max < b[j]) {
                    max = b[j];
                    maxIndex = j;
                }
            }
            
            answer += (a[i] * max);
            visited[maxIndex] = true;
        }
        
        System.out.println(answer);
    }
}