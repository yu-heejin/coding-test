import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        String[] input;
        
        for (int test = 0; test < t; test++) {
            // 맥주를 파는 편의점 개수
            int n = Integer.parseInt(br.readLine());
            
            input = br.readLine().split(" ");
            
            // 상근이네 집 좌표
            int[] s = new int[2];
            s[0] = Integer.parseInt(input[0]);
            s[1] = Integer.parseInt(input[1]);
            
            // 편의점 좌표
            int[][] p = new int[n][2];
            for (int i = 0; i < n; i++) {
                input = br.readLine().split(" ");
                
                p[i][0] = Integer.parseInt(input[0]);
                p[i][1] = Integer.parseInt(input[1]);
            }
            
            // 펜타포트 락 페스티벌 좌표
            int[] f = new int[2];
            input = br.readLine().split(" ");
            f[0] = Integer.parseInt(input[0]);
            f[1] = Integer.parseInt(input[1]);
            
            // bfs
            bfs(s, f, p, n);
        }
    }
    
    // bfs
    private static void bfs(int[] start, int[] f, int[][] p, int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n];   // 편의점 방문 여부
        
        q.add(start);
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            // 페스티벌과의 거리
            int dist = manhattan(curr, f);
            
            if (dist <= 1000) {
                System.out.println("happy");
                return;
            }
            
            // 편의점이 1000m 내에 있는지 확인
            for (int i = 0; i < n; i++) {
                if (!visited[i] && manhattan(curr, p[i]) <= 1000) {
                    q.add(p[i]);
                    visited[i] = true;
                }
            }
        }
        
        System.out.println("sad");
    }
    
    // 맨해튼 거리 함수
    private static int manhattan(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}