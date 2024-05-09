import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        int h = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);
        
        int[] blocks = new int[w];
        
        input = br.readLine().split(" ");
        for (int i = 0; i < w; i++) {
            blocks[i] = Integer.parseInt(input[i]);
        }
        
        int answer = 0;
        for (int i = 1; i < w - 1; i++) {
            // 나 기준 왼쪽 최댓값
            int left = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                left = Math.max(left, blocks[j]);
            }
            
            // 나 기준 오른쪽 최댓값
            int right = Integer.MIN_VALUE;
            for (int j = i; j < w; j++) {
                right = Math.max(right, blocks[j]);
            }
            
            // 양 옆 블록이 나보다 커야함
            if (left > blocks[i] && right > blocks[i]) {
                // 둘 중 더 작은 값을 기준으로 물이 쌓인다.
                int realWater = Math.min(left, right);
            
                // 나의 높이를 빼주면 진짜 물의 양이 나온다.
                realWater -= blocks[i];
                
                answer += realWater;
            }
        }
        
        System.out.println(answer);
    }
}