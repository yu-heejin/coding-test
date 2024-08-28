import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] numbers = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            numbers[i][0] = Integer.parseInt(input[0]);
            numbers[i][1] = Integer.parseInt(input[1]);
        }
        
        // 시작점 기준으로 정렬
        Arrays.sort(numbers, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        
        int min = numbers[0][0];   // 첫 번째 선분의 시작점
        int max = numbers[0][1];   // 첫 번째 선분의 종료점
        int length = max - min;    // 첫 번째 선분의 길이
        
        for (int i = 1; i < N; i++) {
            if (numbers[i][0] <= max) {
                // 선분이 겹치는 경우, 최대 종료점만 업데이트
                if (numbers[i][1] > max) {
                    length += numbers[i][1] - max;
                    max = numbers[i][1];
                }
            } else {
                // 선분이 겹치지 않는 경우, 새로운 선분의 길이를 더함
                min = numbers[i][0];
                max = numbers[i][1];
                length += max - min;
            }
        }
        
        System.out.println(length);
    }
}
