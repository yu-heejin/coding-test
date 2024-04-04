import java.io.*;
import java.util.*;

public class Main {
    
    static int[] board = new int[100001];
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        
        Arrays.fill(board, -1);
        
        bfs(n, k);
    }
    
    private static void bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        
        q.add(n);     // 현재 위치
        board[n] = 0;   // 그 때의 시간
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            // 도착한 경우
            if (curr == k) {
                System.out.println(board[curr]);
                return;
            }
            
            // 범위를 벗어나지 않았고 방문하지 않은 경우
            if (curr - 1 >= 0 && board[curr - 1] == -1) {
                q.add(curr - 1);
                board[curr - 1] = board[curr] + 1;
            }
            
            // 범위를 벗어나지 않았고 방문하지 않은 경우
            if (curr + 1 <= 100000 && board[curr + 1] == -1) {
                q.add(curr + 1);
                board[curr + 1] = board[curr] + 1;
            }
            
            // 범위를 벗어나지 않았고 방문하지 않은 경우
            if (curr * 2 <= 100000 && board[curr * 2] == -1) {
                q.add(curr * 2);
                board[curr * 2] = board[curr] + 1;
            }
        }
    }
}