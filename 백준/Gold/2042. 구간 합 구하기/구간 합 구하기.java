import java.util.*;
import java.io.*;

class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);  // 수의 개수
        int M = Integer.parseInt(input[1]);  // 수의 변경이 일어나는 횟수
        int K = Integer.parseInt(input[2]);  // 구간의 합

        long[] numbers = new long[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Long.parseLong(br.readLine());
        }

        // 세그먼트 트리 크기를 넉넉히 4 * N으로 설정
        long[] tree = new long[4 * N];

        // 초기 구간합 구하기
        initSegmentTree(1, N, 1, tree, numbers);

        for (int i = 0; i < M + K; i++) {
            input = br.readLine().split(" ");

            long a = Long.parseLong(input[0]);
            int b = Integer.parseInt(input[1]);
            long c = Long.parseLong(input[2]);

            if (a == 1) {
                // a가 1인 경우, b번째 수를 c로 바꾼다.
                long targetNumber = c - numbers[b - 1]; // b를 1-based에서 0-based로 변환
                numbers[b - 1] = c; // numbers 배열 업데이트
                update(1, N, 1, b, targetNumber, tree);
            } else {
                // a가 2인 경우에는 b번째 수부터 c번째 수까지의 합을 구하여 출력한다.
                System.out.println(sum(1, N, 1, b, (int) c, tree));
            }
        }
    }

    private static long initSegmentTree(int start, int end, int index, long[] tree, long[] numbers) {
        if (start == end) {
            // 말단 노드의 합은 numbers[start - 1] (0-based 접근)
            return tree[index] = numbers[start - 1];
        }

        int mid = (start + end) / 2;

        // 왼쪽 자식과 오른쪽 자식의 합
        return tree[index] = initSegmentTree(start, mid, index * 2, tree, numbers)
                           + initSegmentTree(mid + 1, end, index * 2 + 1, tree, numbers);
    }

    /* 해당 구간의 합을 구하는 함수 */
    private static long sum(int start, int end, int index, int left, int right, long[] tree) {
        if (left > end || right < start) {
            // 범위를 벗어난 경우
            return 0;
        }

        // 내가 원하는 구간의 합인 경우
        if (left <= start && end <= right) {
            return tree[index];
        }

        // 이진 탐색
        int mid = (start + end) / 2;
        return sum(start, mid, index * 2, left, right, tree)
             + sum(mid + 1, end, index * 2 + 1, left, right, tree);
    }

    /* 해당 구간의 합을 변경한다 */
    private static void update(int start, int end, int index, int targetIndex, long numberForChange, long[] tree) {
        if (targetIndex > end || targetIndex < start) {
            // 범위를 벗어난 경우
            return;
        }

        tree[index] += numberForChange;

        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, index * 2, targetIndex, numberForChange, tree);
        update(mid + 1, end, index * 2 + 1, targetIndex, numberForChange, tree);
    }
}
