import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    private static final int[] mx = {-1, 1, 0, 0};
    private static final int[] my = {0, 0, -1, 1};

    private static int sheeps = 0;
    private static int wolfs = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        char[][] arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                arr[i][j] = input[j].charAt(0);
            }
        }

        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j]) {
                    isWinSheep(arr, visited, i, j, r, c);
                }
            }
        }

        System.out.println(sheeps + " " + wolfs);
    }

    // 살아있는 양의 수 판단
    private static void isWinSheep(char[][] arr, boolean[][] visited, int cr, int cc, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        int sheep = 0;
        int wolf = 0;

        q.add(new int[] {cr, cc});
        visited[cr][cc] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (arr[curr[0]][curr[1]] == 'o') {
                sheep++;
            }

            if (arr[curr[0]][curr[1]] == 'v') {
                wolf++;
            } 

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + mx[i];
                int ny = curr[1] + my[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (visited[nx][ny]) continue;
                if (arr[nx][ny] == '#') continue;

                q.add(new int[] {nx, ny});
                visited[nx][ny] = true;
            }
        }

        
        if (sheep > wolf) {
            sheeps += sheep;
        } else {
            wolfs += wolf;
        }
    }
}