import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }

            return o1[0] - o2[0];
        });

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            
            pq.add(new int[] {x, y});
        }

        while (!pq.isEmpty()) {
            int[] point = pq.poll();
            
            System.out.println(point[0] + " " + point[1]);
        }
    }
}