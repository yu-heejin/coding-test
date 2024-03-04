import java.io.*;

public class Main {
    static final String[] MOVE = { "R", "L", "U", "D" };    // 상하좌우
    static int[] bucket = new int[5];   // 이동할 방향 다섯개 선택
    static int maxBlock = Integer.MIN_VALUE;
    static int nn;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        nn = Integer.parseInt(br.readLine());
        int[][] board = new int[nn][nn];
        
        for (int i = 0; i < nn; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < nn; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        permutation(4, 5, board);
        System.out.println(maxBlock);
    }
    
    // 중복 순열
    private static void permutation(int n, int r, int[][] board) {
        if (r == 0) {
            // board 복사
            int[][] tempBoard = new int[nn][nn];
            for (int i = 0; i < nn; i++) {
                for (int j = 0; j < nn; j++) {
                    tempBoard[i][j] = board[i][j];
                }
            }
            
            for (int i = 0; i < 5; i++) {
                moveBoard(bucket[i], tempBoard);
            }
            return;
        }
        
        int lastIndex = bucket.length - r - 1;
        int small = 0;
        
        for (int i = small; i < n; i++) {
            bucket[lastIndex + 1] = i;
            permutation(n, r - 1, board);
        }
    }
    
    private static void moveBoard(int index, int[][] board) {
        boolean[][] isCombined = new boolean[nn][nn];
        
        switch(MOVE[index]) {
            case "R":
                for (int i = 0; i < nn; i++) {
                    for (int j = nn - 2; j >= 0; j--) {
                        if (board[i][j] == 0) continue;
                        int zeroIndex = j;
                        // 맨 오른쪽부터 빈칸이 있는 경우를 찾는다.
                        while (zeroIndex < nn - 1 && board[i][zeroIndex + 1] == 0) zeroIndex++;
                        
                        // 만약 빈 칸이 있는 경우
                        if (board[i][zeroIndex] == 0) {
                            // 해당 빈칸 다음칸에 자기랑 같은 수가 있는 경우 합친다.
                            if (zeroIndex < nn - 1 && !isCombined[i][zeroIndex + 1] &&board[i][zeroIndex + 1] == board[i][j]) {
                                board[i][zeroIndex + 1] += board[i][j];
                                board[i][zeroIndex] = 0;
                                isCombined[i][zeroIndex + 1] = true;
                            } else {
                                board[i][zeroIndex] = board[i][j];    
                            }
                            board[i][j] = 0;
                        } else if (zeroIndex < nn - 1 && !isCombined[i][zeroIndex + 1] && board[i][zeroIndex + 1] == board[i][j]) {
                            // 반 칸은 아니지만 그 다음 칸에 자기랑 같은 칸이 존재하는 경우
                            board[i][zeroIndex + 1] += board[i][j];
                            board[i][zeroIndex] = 0;
                            isCombined[i][zeroIndex + 1] = true;
                            board[i][j] = 0;
                        }
                    }
                }
                break;
            case "L":
                for (int i = 0; i < nn; i++) {
                    for (int j = 1; j < nn; j++) {
                        if (board[i][j] == 0) continue;
                        int zeroIndex = j;
                        // 맨 왼쪽부터 빈칸이 있는 경우를 찾는다.
                        while (zeroIndex > 0 && board[i][zeroIndex - 1] == 0) zeroIndex--;
                        
                        // 만약 빈 칸이 있는 경우
                        if (board[i][zeroIndex] == 0) {
                            // 해당 빈칸 다음칸에 자기랑 같은 수가 있는 경우 합친다.
                            if (zeroIndex > 0 && !isCombined[i][zeroIndex - 1] && board[i][zeroIndex - 1] == board[i][j]) {
                                board[i][zeroIndex - 1] += board[i][j];
                                board[i][zeroIndex] = 0;
                                isCombined[i][zeroIndex - 1] = true;
                            } else {
                                board[i][zeroIndex] = board[i][j];    
                            }
                            board[i][j] = 0;
                        } else if (zeroIndex > 0 && !isCombined[i][zeroIndex - 1] && board[i][zeroIndex - 1] == board[i][j]) {
                            // 반 칸은 아니지만 그 다음 칸에 자기랑 같은 칸이 존재하는 경우
                            board[i][zeroIndex - 1] += board[i][j];
                            board[i][zeroIndex] = 0;
                            board[i][j] = 0;
                            isCombined[i][zeroIndex - 1] = true;
                        }
                    }
                }
                break;
            case "U":
                for (int j = 0; j < nn; j++) {
                    for (int i = 1; i < nn; i++) {
                        if (board[i][j] == 0) continue;
                        int zeroIndex = i;
                        // 맨 위쪽부터 빈칸이 있는 경우를 찾는다.
                        while (zeroIndex > 0 && board[zeroIndex - 1][j] == 0) zeroIndex--;
                        
                        // 만약 빈 칸이 있는 경우
                        if (board[zeroIndex][j] == 0) {
                            // 해당 빈칸 다음칸에 자기랑 같은 수가 있는 경우 합친다.
                            if (zeroIndex > 0 && !isCombined[zeroIndex - 1][j] && board[zeroIndex - 1][j] == board[i][j]) {
                                board[zeroIndex - 1][j] += board[i][j];
                                board[zeroIndex][j] = 0;
                                isCombined[zeroIndex - 1][j] = true;
                            } else {
                                board[zeroIndex][j] = board[i][j];    
                            }
                            board[i][j] = 0;
                        } else if (zeroIndex > 0 && !isCombined[zeroIndex - 1][j] && board[zeroIndex - 1][j] == board[i][j]) {
                            // 반 칸은 아니지만 그 다음 칸에 자기랑 같은 칸이 존재하는 경우
                            board[zeroIndex - 1][j] += board[i][j];
                            board[zeroIndex][j] = 0;
                            board[i][j] = 0;
                            isCombined[zeroIndex - 1][j] = true;
                        }
                    }
                }
                break;
            case "D":
                for (int j = 0; j < nn; j++) {
                    for (int i = nn - 2; i >= 0; i--) {
                        if (board[i][j] == 0) continue;
                        int zeroIndex = i;
                        // 맨 위쪽부터 빈칸이 있는 경우를 찾는다.
                        while (zeroIndex < nn - 1 && board[zeroIndex + 1][j] == 0) zeroIndex++;
                        
                        // 만약 빈 칸이 있는 경우
                        if (board[zeroIndex][j] == 0) {
                            // 해당 빈칸 다음칸에 자기랑 같은 수가 있는 경우 합친다.
                            if (zeroIndex < nn - 1 && !isCombined[zeroIndex + 1][j] && board[zeroIndex + 1][j] == board[i][j]) {
                                board[zeroIndex + 1][j] += board[i][j];
                                board[zeroIndex][j] = 0;
                                isCombined[zeroIndex + 1][j] = true;
                            } else {
                                board[zeroIndex][j] = board[i][j];    
                            }
                            board[i][j] = 0;
                        } else if (zeroIndex < nn - 1 && !isCombined[zeroIndex + 1][j] && board[zeroIndex + 1][j] == board[i][j]) {
                            // 반 칸은 아니지만 그 다음 칸에 자기랑 같은 칸이 존재하는 경우
                            board[zeroIndex + 1][j] += board[i][j];
                            board[zeroIndex][j] = 0;
                            board[i][j] = 0;
                            isCombined[zeroIndex + 1][j] = true;
                        }
                    }
                }
                break;
        }
        
        for (int i = 0; i < nn; i++) {
            for (int j = 0; j < nn; j++) {
                maxBlock = Math.max(maxBlock, board[i][j]);
            }
        }
    }
}