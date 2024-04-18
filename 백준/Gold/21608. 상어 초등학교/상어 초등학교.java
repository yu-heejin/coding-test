import java.io.*;
import java.util.*;

public class Main {
    static final int[] MOVE_X = {-1, 1, 0, 0};
    static final int[] MOVE_Y = {0, 0, -1, 1};
    
    static int[][] classes;
    static int n;
    static int[][] likeFriends;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        classes = new int[n][n];    // (1,1) ~ (n,n)
        likeFriends = new int[n * n][5];
        
        String[] input;
        for (int i = 0; i < n * n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j <= 4; j++) {
                likeFriends[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        for (int i = 0; i < n * n; i++) {
            List<int[]> results = bfs(i);
            
            Collections.sort(results, (o1, o2) -> {
                if (o1[2] == o2[2]) {
                    if (o1[3] == o2[3]) {
                        if (o1[0] == o2[0]) {
                            return o1[1] - o2[1];    // 열의 번호가 가장 작은 칸
                        }
                        
                        return o1[0] - o2[0];    // 행의 번호가 가장 작은 칸
                    }
                    
                    return o2[3] - o1[3];   // 비어있는 칸이 가장 많은 칸
                }
                
                return o2[2] - o1[2];   // 좋아하는 학생이 가장 많은 칸
            });
            
            int[] position = results.get(0);
            
            classes[position[0]][position[1]] = likeFriends[i][0];
        }
        
        // 만족도 계산
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 해당 학생 인덱스 구하기
                int studentIndex = 0;
                for (int k = 0; k < n*n; k++) {
                    if (classes[i][j] == likeFriends[k][0]) {
                        studentIndex = k;
                        break;
                    }
                }
                
                // 상하좌우 확인
                int likes = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + MOVE_X[k];
                    int ny = j + MOVE_Y[k];
                    
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    
                    for (int l = 1; l < 5; l++) {
                        if (likeFriends[studentIndex][l] == classes[nx][ny]) {
                            likes++;
                            break;
                        }
                    }
                }
                
                if (likes == 2) {
                    sum += 10;
                } else if (likes == 3) {
                    sum += 100;
                } else if (likes == 4) {
                    sum += 1000;
                } else {
                    sum += likes;
                }
            }
        }
        
        System.out.println(sum);
    }
    
    private static List<int[]> bfs(int studentIndex) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n + 1][n + 1];
        List<int[]> spots = new ArrayList<>();
        
        q.add(new int[] {0, 0});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int count = 0;
            int emptyCount = 0;

            // 맨해튼 거리 1은 상하좌우를 의미한다.
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + MOVE_X[i];
                int ny = curr[1] + MOVE_Y[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                
                // 내가 좋아하는 학생이 있는지 확인
                for (int j = 1; j < 5; j++) {
                    if (classes[nx][ny] == likeFriends[studentIndex][j]) {
                        count++;
                    }
                }
                
                if (!visited[nx][ny]) {
                    q.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
                
                if (classes[nx][ny] == 0) {
                    emptyCount++;
                }
            }
            
            if (classes[curr[0]][curr[1]] == 0)
                spots.add(new int[] {curr[0], curr[1], count, emptyCount});
        }
        
        return spots;
    }
}