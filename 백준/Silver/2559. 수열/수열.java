import java.util.*;
import java.io.*;

/* 고정 길이 슬라이딩 윈도우 */
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);   // 온도를 측정한 전체 날짜의 수
        int K = Integer.parseInt(input[1]);   // 합을 구하기 위한 연속적인 날짜의 수

        input = br.readLine().split(" ");
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        int maxSum = Integer.MIN_VALUE;

        for (int start = 0; start <= N - K; start++) {
            int end = start + K - 1;
            int sum = 0;

            for (int j = start; j <= end; j++) {
                sum += numbers[j];
            }

            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}