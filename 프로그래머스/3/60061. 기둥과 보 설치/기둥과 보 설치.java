import java.util.*;

class Solution {
    int[][] pillarBoard;
    int[][] paperBoard;
    
    public int[][] solution(int n, int[][] build_frame) {
        pillarBoard = new int[n + 1][n + 1];
        paperBoard = new int[n + 1][n + 1];
        
        // 각 보드 초기화
        for (int i = 0; i <= n; i++) {
            Arrays.fill(pillarBoard[i], -1);
            Arrays.fill(paperBoard[i], -1);
        }
        
        for (int[] build : build_frame) {
            int x = build[0];   // 가로(열)
            int y = build[1];   // 세로(행)
            int a = build[2];   // 기둥/보
            int b = build[3];   // 삭제/설치
            
            if (b == 1) {
                // 설치
                if (a == 0) {
                    pillarBoard[y][x] = a;
                    if (!isInstall(y, x, a, n)) {
                        pillarBoard[y][x] = -1;
                    }
                } else {
                    paperBoard[y][x] = a;
                    if (!isInstall(y, x, a, n)) {
                        paperBoard[y][x] = -1;
                    }
                }
            } else {
                // 삭제
                if (a == 0) {
                    pillarBoard[y][x] = -1;
                    if (!isUninstall(n)) {
                        pillarBoard[y][x] = a;
                    }
                } else {
                    paperBoard[y][x] = -1;
                    if (!isUninstall(n)) {
                        paperBoard[y][x] = a;
                    }
                }
            }
        }
        
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (pillarBoard[i][j] != -1) {
                    arr.add(new int[] {j, i, pillarBoard[i][j]});
                }
                
                if (paperBoard[i][j] != -1) {
                    arr.add(new int[] {j, i, paperBoard[i][j]});
                }
            }
        }
        
        Collections.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) {
                    return o1[2] - o2[2];
                }
                return o1[1] - o2[1];
            }
            
            return o1[0] - o2[0];
        });
        
        int[][] answer = new int[arr.size()][3];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
    
    private boolean isUninstall(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (pillarBoard[i][j] != -1 && !isInstall(i, j, pillarBoard[i][j], n)) return false;
                if (paperBoard[i][j] != -1 && !isInstall(i, j, paperBoard[i][j], n)) return false;
            }
        }
        
        return true;
    }
    
    private boolean isInstall(int y, int x, int build, int n) {
        // 기둥인 경우
        if (build == 0) {
            if (y == 0) {
                return true;
            }
            // 보의 한쪽 끝에 있는 경우
            if ((x > 0 && paperBoard[y][x - 1] == 1) || paperBoard[y][x] == 1) {
                return true;
            }
            // 다른 기둥 위에 있는 경우
            if (pillarBoard[y - 1][x] == 0) {
                return true;
            }
        }
        
        // 보
        if (build == 1) {
            // 한쪽 끝부분이 기둥 위에 있는 경우
            if ((y > 0 && x < n && pillarBoard[y - 1][x + 1] == 0) || (y > 0 && pillarBoard[y - 1][x] == 0)) {
                return true;
            }
            
            // 양쪽 끝부분이 다른 보와 연결된 경우
            if (x > 0 && x < n && paperBoard[y][x - 1] == 1 && paperBoard[y][x + 1] == 1) {
                return true;
            }
        }
        
        return false;
    }
}