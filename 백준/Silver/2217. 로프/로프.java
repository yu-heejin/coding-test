import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] ropes = new int[n];
        
        for (int i = 0; i < n; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        Arrays.sort(ropes);

        // 가장 큰 루프 X N
        int w = ropes[n - 1];
        int max = w * 1;

        for (int i = n - 1; i >= 0; i--) {
            w = ropes[i];
            int count = 0;
            
            for (int j = n - 1; j >= 0; j--) {
                if (w > ropes[j]) {
                    break;
                }

                count++;
            }

            max = Math.max(max, w * count);
        }

        System.out.println(max);
    }
}