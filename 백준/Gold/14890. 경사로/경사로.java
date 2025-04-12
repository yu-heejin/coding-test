import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (isRoadRow(map, i, n, l)) {
                answer++;
            }

            if (isRoadColumn(map, i, n, l)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    /* 행 검사 함수 */
    private static boolean isRoadRow(int[][] map, int order, int n, int l) {
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n - 1; i++) {
            int diff = map[order][i] - map[order][i + 1];

            // 높이 차가 1 이상인 경우
            if (diff > 1 || diff < -1) return false;

            // 위에서 아래로 경사로를 놓아야 한다.
            if (diff == 1) {
                int count = 0;
                for (int j = i + 1; j <= i + l; j++) {
                    if (j >= n) break;
                    // 이미 방문하지 않아야함
                    if (visited[j]) return false;
                    // 길이가 연속되어야 함
                    if (map[order][j] == map[order][i + 1]) count++;
                    else return false;
                }

                if (count >= l) {
                    // 놓을 수 있음
                    for (int j = i + 1; j <= i + l; j++) {
                        if (j >= n) break;
                        visited[j] = true;
                    }
                } else return false;
            }
            // 아래에서 위로 경사로를 놓아야 한다.
            else if (diff == -1) {
                int count = 0;
                for (int j = i; j >= i - l + 1; j--) {
                    if (j < 0) break;
                    // 이미 방문하지 않아야함
                    if (visited[j]) return false;
                    // 길이가 연속되어야 함
                    if (map[order][j] == map[order][i]) count++;
                    else return false;
                }

                if (count >= l) {
                    // 놓을 수 있음
                    for (int j = i; j >= i - l + 1; j--) {
                        if (j < 0) break;
                        visited[j] = true;
                    }
                } else return false;
            }
        }

        return true;
    }

    private static boolean isRoadColumn(int[][] map, int order, int n, int l) {
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n - 1; i++) {
            int diff = map[i][order] - map[i + 1][order];

            // 높이 차가 1 이상인 경우
            if (diff > 1 || diff < -1) return false;

            // 위에서 아래로 경사로를 놓아야 한다.
            if (diff == 1) {
                int count = 0;
                for (int j = i + 1; j <= i + l; j++) {
                    if (j >= n) break;
                    // 이미 방문하지 않아야함
                    if (visited[j]) return false;
                    // 길이가 연속되어야 함
                    if (map[j][order] == map[i + 1][order]) count++;
                    else return false;
                }

                if (count >= l) {
                    // 놓을 수 있음
                    for (int j = i + 1; j <= i + l; j++) {
                        if (j >= n) break;
                        visited[j] = true;
                    }
                } else return false;
            }
            // 아래에서 위로 경사로를 놓아야 한다.
            else if (diff == -1) {
                int count = 0;
                for (int j = i; j >= i - l + 1; j--) {
                    if (j < 0) break;
                    // 이미 방문하지 않아야함
                    if (visited[j]) return false;
                    // 길이가 연속되어야 함
                    if (map[j][order] == map[i][order]) count++;
                    else return false;
                }

                if (count >= l) {
                    // 놓을 수 있음
                    for (int j = i; j >= i - l + 1; j--) {
                        if (j < 0) break;
                        visited[j] = true;
                    }
                } else return false;
            }
        }

        return true;
    }
}