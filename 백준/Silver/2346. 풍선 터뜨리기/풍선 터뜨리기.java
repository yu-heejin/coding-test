import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n];

        String[] input = br.readLine().split(" ");
        // 풍선이 원형으로 놓여있다 - 덱 사용(회전)
        Deque<int[]> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int[] balloon = new int[] {i + 1, Integer.parseInt(input[i])};
            dq.addLast(balloon);
        }

        for (int i = 0; i < n; i++) {
            int[] balloon = dq.pollFirst();
            System.out.print(balloon[0] + " ");
            if (dq.isEmpty()) break;
            
            if (balloon[1] > 0) {
                // 양수인 경우, 앞 -> 뒤
                balloon[1]--;
                while (balloon[1]-- > 0) {
                    int[] temp = dq.pollFirst();
                    dq.addLast(temp);
                }
            } else {
                //음수인 경우, 뒤 -> 앞
                while (balloon[1]++ < 0) {
                    int[] temp = dq.pollLast();
                    dq.addFirst(temp);
                }
            }
        }
    }
}