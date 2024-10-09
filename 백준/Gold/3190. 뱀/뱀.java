import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
public class Main {

    private static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] board = new int[N + 1][N + 1];

        // 사과의 위치 저장
        for (int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");

            int x = Integer.parseInt(input[0]);  // 행(세로)
            int y = Integer.parseInt(input[1]);  // 열(가로)

            // 사과인 경우 board 안의 값을 1로 설정
            board[x][y] = 1;
        }

        // 뱀의 방향 변환 정보
        int L = Integer.parseInt(br.readLine());
        String[][] directions = new String[L][2];

        for (int i = 0; i < L; i++) {
            directions[i] = br.readLine().split(" ");
        }

        System.out.println(playGame(board, directions));
    }

    private static int playGame(int[][] board, String[][] directions) {
        // 뱀
        Deque<int[]> dq = new ArrayDeque<>();
        
        int i = 0;
        int time = 1;
        String currentDirection = "R";   // 처음에는 오른쪽을 향한다.
        int[] currentPosition = {1, 1};   // 머리의 위치

        dq.addFirst(currentPosition);

        // 현재 뱀의 위치는 2로 표시한다.
        board[currentPosition[0]][currentPosition[1]] = 2;
        
        while (true) {
            // 0. 게임 시작 시간으로부터 X초가 끝난 뒤 90도 방향으로 회전
            if (i < directions.length && time == Integer.parseInt(directions[i][0]) + 1) {
                currentDirection = getNextDirection(currentDirection, directions[i][1]);
                i++;
                continue;
            }
            
            // 1. 먼저 뱀은 몸 길이를 늘려 머리를 다음 칸에 위치시킨다.
            int[] nextPosition = getNextPosition(currentPosition, currentDirection);

            // 2. 만약 벽이나 자기 자신의 몸과 부딪히면 게임이 끝난다.
            // 2-1. 벽인 경우
            if (nextPosition[0] <= 0 || nextPosition[0] > N || nextPosition[1] <= 0 || nextPosition[1] > N) {
                break;
            }
            // 2-2. 자기 자신인 경우
            if (board[nextPosition[0]][nextPosition[1]] == 2) {
                break;
            }

            if (board[nextPosition[0]][nextPosition[1]] == 1) {
                // 3. 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
                board[nextPosition[0]][nextPosition[1]] = 2;
                dq.addFirst(nextPosition);
            } else {
                // 4. 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다.
                 board[nextPosition[0]][nextPosition[1]] = 2;
                // 머리의 위치 갱신
                dq.addFirst(nextPosition);

                if (dq.size() > 1) {
                    // 사과가 없는데 길이가 길다면 꼬리를 제거한다.
                    int[] currentTailPosition = dq.pollLast();
                    board[currentTailPosition[0]][currentTailPosition[1]] = 0;
                }
            }

            time++;
            currentPosition = dq.getFirst();
        }

        return time;
    }

    private static int[] getNextPosition(int[] currentPosition, String currentDirection) {
        if (currentDirection.equals("L")) {
            // 현재 방향이 왼쪽인 경우
            return new int[] {currentPosition[0], currentPosition[1] - 1};
        } 
        
        if (currentDirection.equals("R")) {
            // 현재 방향이 오른쪽인 경우
            return new int[] {currentPosition[0], currentPosition[1] + 1};
        }

        if (currentDirection.equals("U")) {
            // 현재 방향이 위쪽인 경우
            return new int[] {currentPosition[0] - 1, currentPosition[1]};
        }

        if (currentDirection.equals("D")) {
            // 현재 방향이 아래쪽인 경우
            return new int[] {currentPosition[0] + 1, currentPosition[1]};
        }

        return currentPosition;
    }

    private static String getNextDirection(String currentDirection, String nextDirection) {
        if (nextDirection.equals("D")) {
            // 오른쪽 방향으로 90도 회전하는 경우
            switch (currentDirection) {
                case "L":
                    return "U";
                case "R":
                    return "D";
                case "U":
                    return "R";
                case "D":
                    return "L";
            }
        } else {
            // 왼쪽 방향으로 90도 회전하는 경우
            switch (currentDirection) {
                case "L":
                    return "D";
                case "R":
                    return "U";
                case "U":
                    return "L";
                case "D":
                    return "R";
            }
        }

        return "L";
    }
}