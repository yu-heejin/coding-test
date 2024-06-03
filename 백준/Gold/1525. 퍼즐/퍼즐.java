import java.io.*;
import java.util.*;

public class Main {
    static final int[] MOVE_X = {-1, 1, 0, 0};
    static final int[] MOVE_Y = {0, 0, -1, 1};
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 3; i++) {
            String input = br.readLine().replaceAll(" ", "");
            sb.append(input);
        }
        
        System.out.println(bfs(sb.toString()));
    }
    
    private static int bfs(String str) {
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> strMap = new HashMap<>();     // 문자열과 이동횟수
        
        q.add(str);    // 처음 출발
        strMap.put(str, 0);
        
        while (!q.isEmpty()) {
            String curr = q.poll();
            
            int move = strMap.get(curr);
            int zeroIndex = curr.indexOf("0");     // 빈 칸의 위치 찾기
            int zeroX = zeroIndex / 3;
            int zeroY = zeroIndex % 3;
            
            // 이미 정리된 경우 반환
            if (curr.equals("123456780")) {
                return move;
            }
            
            // 빈칸 주위 인접한 숫자 확인
            for (int i = 0; i < 4; i++) {
                int nx = zeroX + MOVE_X[i];
                int ny = zeroY + MOVE_Y[i];
                
                if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) continue;
                
                int nIndex = nx * 3 + ny;
                char c = curr.charAt(nIndex);    // 상하좌우에 인접한 숫자
                
                String nextStr = curr;
                nextStr = nextStr.replace(c, 'i');
                nextStr = nextStr.replace('0', c);
                nextStr = nextStr.replace('i', '0');
                
                if (!strMap.containsKey(nextStr)) {
                    q.add(nextStr);
                    strMap.put(nextStr, move + 1);
                }
            }
        }
        
        return -1;    // 이동이 불가능한 경우 -1
    }
}