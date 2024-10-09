import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
public class Main {

    private static final int[] NX = {-1, 1, 0, 0};
    private static final int[] NY = {0, 0, -1, 1};
    
    private static int doltanism = 0;
    private static int notDoltanism = 0;
    private static int N;
    private static String[][] picture;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        picture = new String[N][N];

        for (int i = 0; i < N; i++) {
            picture[i] = br.readLine().split("");
        }

        // 적록색약이 아닌 사람이 보는 구역
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(picture[i][j], visited, new int[] {i, j});
                    notDoltanism++;
                }
            }
        }

        // 적록색약인 사람이 보는 구역
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (picture[i][j].equals("G")) {
                    picture[i][j] = "R";
                }
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(picture[i][j], visited, new int[] {i, j});
                    doltanism++;
                }
            }
        }

        System.out.println(notDoltanism + " " + doltanism);
    }

    private static void bfs(String color, boolean[][] visited, int[] start) {
        Queue<int[]> q = new LinkedList<>();

        visited[start[0]][start[1]] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int[] current = q.poll();

            // 인접한 구간 탐색
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + NX[i];
                int ny = current[1] + NY[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny] || !picture[nx][ny].equals(color)) continue;

                q.add(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
}