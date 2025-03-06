import java.util.*;
import java.io.*;

// 모든 경우의 수를 확인해봐야하므로 BFS를 이용해 푼다.

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int s = Integer.parseInt(br.readLine());

        System.out.println(bfs(s));
    }

    private static int bfs(int s) {
        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[1001][1001];
        
        // 클립보드, 화면, 시간
        q.offer(new int[] {0, 1, 0});
        visited[0][1] = true;    // 클립보드 0개, 화면 1개는 이미 방문

        while (!q.isEmpty()) {
            int[] current = q.poll();

            if (current[1] == s) {
                return current[2];
            }

            // 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장
            if (!visited[current[1]][current[1]]) {
                q.offer(new int[] {current[1], current[1], current[2] + 1});
                visited[current[1]][current[1]] = true;
            }

            // 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
            if (current[0] > 0 && current[0] + current[1] <= 1000 && !visited[current[0]][current[0] + current[1]]) {
                q.offer(new int[] {current[0], current[0] + current[1], current[2] + 1});
                visited[current[0]][current[0] + current[1]] = true;
            }

            // 3. 이모티콘 하나 지우기
            if (current[1] > 0 && !visited[current[0]][current[1] - 1]) {
                q.offer(new int[] {current[0], current[1] - 1, current[2] + 1});
                visited[current[0]][current[1] - 1] = true;
            }
        }

        return 0;
    }
}