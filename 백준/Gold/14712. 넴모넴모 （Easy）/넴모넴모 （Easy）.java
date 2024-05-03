import java.io.*;

public class Main {
    static boolean[][] isNemmo;
    static int n, m;
    static int answer = 0;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        
        isNemmo = new boolean[n + 1][m + 1];    // +1을 하면 1일때에도 탐색이 가능하다.
        
        dfs(1, 1);
        
        System.out.println(answer);
    }
    
    /* 탐색하는 함수 */
    private static void dfs(int x, int y) {
        if (x == n && y == m) {
            answer++;
            
            // 현재 위치에 넴모를 두었을 때 2x2가 안생기는 경우에만 answer++
            isNemmo[x][y] = true;
            
            if (canPlaceNemmo(x, y)) {
                answer++;
            }
            
            isNemmo[x][y] = false;
            return;
        }
        
        int[] nextMove = getNextMove(x, y);
        
        // 넴모를 두지 않고 탐색
        dfs(nextMove[0], nextMove[1]);
        
        // 넴모를 두고 탐색
        isNemmo[x][y] = true;
        // 넴모를 놓았을 때 없어지는 사각형이 생기지 않는 경우
        if (canPlaceNemmo(x, y)) {
            dfs(nextMove[0], nextMove[1]);
        }
        isNemmo[x][y] = false;
    }
    
    /* 다음 위치를 반환하는 함수 */
    private static int[] getNextMove(int x, int y) {
        if (y == m) {
            // 끝까지 모두 탐색한 경우
            x = x + 1;
            y = 1;
        } else {
            y = y + 1;
        }
        
        return new int[] {x, y};
    }
    
    /* 해당 위치에 넴모를 둘 수 있는지 확인하는 함수 */
    private static boolean canPlaceNemmo(int x, int y) {
        // 위쪽, 좌상향 대각선, 왼쪽에 하나라도 없으면 넴모를 놓을 수 있음
        if (!isNemmo[x - 1][y] || !isNemmo[x - 1][y - 1] || !isNemmo[x][y - 1]) {
            return true;
        }
        
        return false;
    }
}