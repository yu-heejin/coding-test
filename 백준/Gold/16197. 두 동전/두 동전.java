import java.io.*;
import java.util.*;

public class Main {
    
    static final int[] MOVE_X = {-1, 1, 0, 0};
    static final int[] MOVE_Y = {0, 0, -1, 1};
    static String[] input;
    static int min = Integer.MAX_VALUE;
    static int n, m;
    static String[][] board;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        
        board = new String[n][m];
        int[][] coinPositions = new int[2][2];
        int coinIndex = 0;
        
        for (int i = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = input[j];
                
                if (input[j].equals("o")) {
                    coinPositions[coinIndex][0] = i;
                    coinPositions[coinIndex][1] = j;
                    coinIndex++;
                }
            }
        }
        
        for (int i = 0; i < 4; i++) {
            move(coinPositions[0][0], coinPositions[0][1], coinPositions[1][0], coinPositions[1][1], 1, i);
        }
        
        System.out.println(min > 10 ? -1 : min);
    }
    
    private static void move(int x1, int y1, int x2, int y2, int count, int index) {
        // count
        if (count > 10) {
            min = Math.min(count, min);
            return;
        }
        
        if (count > min) {
            return;
        }
        
        // 다음에 이동할 방향
        int nx1 = x1 + MOVE_X[index];
        int ny1 = y1 + MOVE_Y[index];
        int nx2 = x2 + MOVE_X[index];
        int ny2 = y2 + MOVE_Y[index];
            
        // 두 동전 모두 떨어지는 경우
        if (isOut(nx1, ny1) && isOut(nx2, ny2)) {
            return;
        }
        
        // 두 동전 중 하나만 떨어지는 경우
        if (isOut(nx1, ny1) && !isOut(nx2, ny2)) {
            min = Math.min(min, count);
            return;
        }
        
        if (!isOut(nx1, ny1) && isOut(nx2, ny2)) {
            min = Math.min(min, count);
            return;
        }
        
        // 만약 해당 위치가 벽인 경우 움직이지 않음
        if (board[nx1][ny1].equals("#")) {
            nx1 = x1;
            ny1 = y1;
        }
        
        // 만약 해당 위치가 벽인 경우 움직이지 않음
        if (board[nx2][ny2].equals("#")) {
            nx2 = x2;
            ny2 = y2;
        }
        
        // 계속 진행
        for (int i = 0; i < 4; i++) {
            move(nx1, ny1, nx2, ny2, count + 1, i);
        }
    }
    
    private static boolean isOut(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) return true;
        return false;
    }
}