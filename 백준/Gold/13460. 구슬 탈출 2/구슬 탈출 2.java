import java.io.*;
import java.util.*;

public class Main {
    
    static final int[] MOVE_X = {-1, 1, 0, 0};
    static final int[] MOVE_Y = {0, 0, -1, 1};
    
    static String[][] board;
    static int[] redStart, blueStart;
    static int n, m;
    static int[] bucket = new int[10];
    static boolean isSuccess, isFailure;
    static int minCount = Integer.MAX_VALUE;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        
        redStart = new int[2];
        blueStart = new int[2];
        
        board = new String[n][m];
        
        for (int i = 0; i < n; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = input[j];
                
                if (board[i][j].equals("B")) {
                    blueStart[0] = i;
                    blueStart[1] = j;
                }
                
                if (board[i][j].equals("R")) {
                    redStart[0] = i;
                    redStart[1] = j;
                }
            }
        }
        
        permutation(4, 10);
        
        System.out.println(minCount > 10 ? -1 : minCount);
    }
    
    private static void permutation(int n, int r) {
        if (r == 0) {
            // 시작 지점 복사 (깊은 복사)
            int[] tempBlue = blueStart.clone();
            int[] tempRed = redStart.clone();
            
            // 10번 반복
            isSuccess = false;
            isFailure = false;
            int count = 0;
            for (int i = 0; i < 10; i++) {
                move(tempBlue, tempRed, bucket[i]);
                count++;
                
                if (isSuccess) {
                    // 성공한 경우
                    minCount = Math.min(minCount, count);
                    break;
                }
                
                if (isFailure) {
                    // 실패한 경우
                    break;
                }
            }
            
            return;
        }
        
        int lastIndex = bucket.length - r - 1;
        
        for (int i = 0; i < n; i++) {
            bucket[lastIndex + 1] = i;
            permutation(n, r - 1);
        }
    }
    
    private static void move(int[] blue, int[] red, int index) {
        boolean blueBlock = false, redBlock = false, isSame = false;
        boolean blueExit = false, redExit = false;
        
        while (true) {
            int nbx = blue[0] + MOVE_X[index];
            int nby = blue[1] + MOVE_Y[index];
            
            int nrx = red[0] + MOVE_X[index];
            int nry = red[1] + MOVE_Y[index];
            
            // 벽인 경우 움직이지 않음
            if (board[nbx][nby].equals("#")) {
                nbx = blue[0];
                nby = blue[1];
                blueBlock = true;
            }
            
            if (board[nrx][nry].equals("#")) {
                nrx = red[0];
                nry = red[1];
                redBlock = true;
            }
            
            // 둘이 같은 위치인 경우 더 뒤에 있는 구슬의 위치를 빼준다.
            if (!redExit && !blueExit && nbx == nrx && nby == nry) {
                switch (index) {
                    case 0:
                        if (red[0] < blue[0]) {
                            // x값이 더 작은쪽이 앞선다.
                            nbx = blue[0];
                            blueBlock = false;
                        } else {
                            nrx = red[0];
                            redBlock = false;
                        }
                        break;
                    
                    case 1:
                        if (red[0] < blue[0]) {
                            // x값이 더 큰쪽이 앞선다.
                            nrx = red[0];
                            redBlock = false;
                        } else {
                            nbx = blue[0];
                            blueBlock = false;
                        }
                        break;
                    
                    case 2:
                        if (red[1] < blue[1]) {
                            // y값이 더 작은쪽이 앞선다.
                            nby = blue[1];
                            blueBlock = false;
                        } else {
                            nry = red[1];
                            redBlock = false;
                        }
                        break;
                    
                    case 3:
                        if (red[1] < blue[1]) {
                            // y값이 더 큰쪽이 앞선다.
                            nry = red[1];
                            redBlock = false;
                        } else {
                            nby = blue[1];
                            blueBlock = false;
                        }
                        break;
                }
                
                isSame = true;
            }
            
            if (isSame && (blueBlock || redBlock)) {
                break;
            }
            
            if (blueBlock && redBlock) {
                break;
            }
            
            // 빨강이 구멍 밖에 나간 경우
            if (board[nrx][nry].equals("O")) {
                redExit = true;
            }
            
            // 파랑이 구멍 밖에 나간 경우
            if (board[nbx][nby].equals("O")) {
                // 파란색이 구멍에 들어가면 실패
                blueExit = true;
            }
            
            // 빨강 구슬만 나간 경우 성공
            if (redExit && !blueExit) {
                isFailure = false;
                isSuccess = true;
            }
            
            // 파란 구슬이 나간 경우 실패
            if (!redExit && blueExit) {
                isFailure = true;
                isSuccess = false;
                break;
            }
            
            // 두 구슬 모두 나간 경우 fail
            if (blueExit && redExit) {
                isFailure = true;
                isSuccess = false;
                break;
            }
            
            blue[0] = nbx;
            blue[1] = nby;
            red[0] = nrx;
            red[1] = nry;
            isSame = false;
        }
    }
}