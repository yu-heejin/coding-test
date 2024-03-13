import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        long[][] villages = new long[n][2];     // 각 마을 인구수는 최대 10억명
        String[] input;
        long totalPeople = 0;
        
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            
            long index = Integer.parseInt(input[0]);
            long people = Integer.parseInt(input[1]);
            
            villages[i][0] = index;
            villages[i][1] = people;
            // 전체 인구수 저장
            totalPeople += people;
        }
        
        // x값을 기준으로 오름차순 정렬
        Arrays.sort(villages, (o1, o2) -> {
            return Long.compare(o1[0], o2[0]);
        });
        
        long left = 0;
        
        // 우체국이 마을 위치에 정확히 있어야 거리가 최소가 된다.
        for (int i = 0; i < n; i++) {
            left += villages[i][1];
            // 누적 값의 합이 중간값보다 크거나 같은 경우
            // sum이 홀수일 때의 중앙값은 sum / 2 + 1, 짝수일 경우 sum / 2
            long mid = (totalPeople % 2 == 0) ? totalPeople / 2 : totalPeople / 2 + 1;
            if (mid <= left) {
                System.out.println(villages[i][0]);
                break;
            }
        }
    }
}