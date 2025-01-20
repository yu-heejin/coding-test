import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] distances = new long[n - 1];
        long[] costs = new long[n];

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n - 1; i++) {
            distances[i] = Long.parseLong(input[i]);
        }

        input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            costs[i] = Long.parseLong(input[i]);
        }

        int position = 0;
        long oil = 0;
        long totalCost = 0;

        while (position < n - 1) {
            long cost = costs[position];
            // 현재 위치보다 비싼 도시가 안나올 때까지 기름을 채운다.
            // 비싼 도시가 나오면 여기서 계속 채우는게 맞다
            // 마지막(n-1) 인덱스까지 가면 그냥 끝까지 넣는다.
            while (position < n - 1 && cost <= costs[position]) {
                oil += distances[position];
                position++;
            }

            // 해당 위치로 갈 때까지 기름을 채움
            totalCost += (oil * cost);
            oil = 0;
        }

        System.out.println(totalCost);
    }
}