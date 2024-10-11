import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);  // 세로 크기
        int M = Integer.parseInt(input[1]);  // 가로 크기
        int x = Integer.parseInt(input[2]);  // 주사위 좌표(세로)
        int y = Integer.parseInt(input[3]);   // 주사위 좌표(가로)
        int K = Integer.parseInt(input[4]);   // 명령의 개수

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        input = br.readLine().split(" ");

        // 주사위 면
        // 윗면, 앞면, 오른쪽면, 왼쪽면, 뒷면, 밑면 (1, 2, 3, 4, 5, 6)
        // 가장 처음의 주사위는 모든 면이 0
        int[] dice = new int[6];
        int[] current = {x, y};  // 현재 상태
        for (int i = 0; i < input.length; i++) {
            int move = Integer.parseInt(input[i]);

            int[] nextMove = getNextMove(move, current);

            // 지도 바깥으로 이동하는 경우 무시
            if (nextMove[0] < 0 || nextMove[0] >= N || nextMove[1] < 0 || nextMove[1] >= M) continue;

            rollingDice(move, dice);
            
            // 1. 이동한 칸의 수가 0이면 주사위 바닥면의 수가 지도 칸에 복사된다.
            if (map[nextMove[0]][nextMove[1]] == 0) {
                map[nextMove[0]][nextMove[1]] = dice[5];
            } else {
                // 2. 이동한 칸의 수가 0이 아니면 지도 칸의 숫자가 주사위 바닥으로 복사되고 지도 칸 수는 0
                dice[5] = map[nextMove[0]][nextMove[1]];
                map[nextMove[0]][nextMove[1]] = 0;
            }

            // 상단에 쓰인 값 출력하기
            System.out.println(dice[0]);

            // 현재 위치 갱신
            current = nextMove;
        }
    }

    private static int[] getNextMove(int move, int[] current) {
        // 다음 위치와 다음 바닥면 인덱스 반환
        switch (move) {
                case 1:
                    // 동쪽(오른쪽)
                    return new int[] {current[0], current[1] + 1};
                case 2:
                    // 서쪽(왼쪽)
                    return new int[] {current[0], current[1] - 1};

                case 3:
                    // 북쪽(위쪽)
                    return new int[] {current[0] - 1, current[1]};
                case 4:
                    // 남쪽(아래쪽)
                    return new int[] {current[0] + 1, current[1]};
        }

        return new int[] {current[0] + 1, current[1]};
    }
    
    // 윗면, 앞면, 오른쪽면, 왼쪽면, 뒷면, 밑면 (0, 1, 2, 3, 4, 5)
    private static void rollingDice(int nextMove, int[] dice) {
        int temp = dice[0];
        
        switch (nextMove) {
            case 1:
                dice[0] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[2];
                dice[2] = temp;
                break;
            case 2:
                dice[0] = dice[2];
                dice[2] = dice[5];
                dice[5] = dice[3];
                dice[3] = temp;
                break;
            case 3:
                dice[0] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[1];
                dice[1] = temp;
                break;
            case 4:
                dice[0] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[4];
                dice[4] = temp;
                break;
        }
    }
}