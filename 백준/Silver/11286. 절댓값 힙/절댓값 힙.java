import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                // 절대값이 가장 작은 값이 여러개일때는 가장 작은 수를 출력하고 그 값을 배열에서 제거한다.
                return o1 - o2;
            }
            return Math.abs(o1) - Math.abs(o2);
        });

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                // 배열에서 절댓값이 가장 작은 값을 출력한다.
                if (pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            } else {
                pq.add(x);
            }
        }
    }
}