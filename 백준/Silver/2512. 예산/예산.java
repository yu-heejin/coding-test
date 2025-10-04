import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] regions = new int[n];
        String[] input = br.readLine().split(" ");
        int requests = 0;
        int maxRequest = -1;

        for (int i = 0; i < input.length; i++) {
            regions[i] = Integer.parseInt(input[i]);
            requests += regions[i];
            maxRequest = Math.max(regions[i], maxRequest);
        }

        int total = Integer.parseInt(br.readLine());

        // 모든 요청이 배정될 수 있는지 확인
        if (requests <= total) {
            System.out.println(maxRequest);
        } else {
            // 상한액 계산 - 가장 예산 요청이 높은 곳을 기준으로
            int minRequest = 1;
            int answer = 0;
            while (minRequest <= maxRequest) {
                int midRequest = (maxRequest + minRequest) / 2;
                int sum = 0;
                int maxResponse = 0;

                for (int i = 0; i < regions.length; i++) {
                    if (midRequest <= regions[i]) {
                        sum += midRequest;
                        maxResponse = Math.max(maxResponse, midRequest);
                    } else {
                        sum += regions[i];
                        maxResponse = Math.max(maxResponse, regions[i]);
                    }
                }

                if (sum <= total) {
                    answer = Math.max(maxResponse, answer);
                    minRequest = midRequest + 1;
                } else {
                    maxRequest = midRequest - 1;
                }
            }

            System.out.println(answer);
        }
    }
}