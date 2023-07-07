import java.io.*;
import java.util.*;

class Solution {
    private Map<String, int[]> move;
    private char[][] map;
    private int x, y;
    
    private void getMoveResult(int[] nextMove, int multiple) {
        // 가다가 중간에 장애물이 존재하면 명령을 따르지 않음
        int nextX = x;
        int nextY = y;
        
        for (int i = 0; i < multiple; i++) {
            nextX += nextMove[0];
            nextY += nextMove[1];
            
            // 경계에 걸리는지 체크하기
            if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[0].length) {
                return;
            }
            
            // X 장애물인지 체크하기
            if (map[nextX][nextY] == 'X') {
                return;
            }
        }
        
        x = nextX;
        y = nextY;
    }
    
    public int[] solution(String[] park, String[] routes) {
        // park 초기화
        map = new char[park.length][park[0].length()];
        
        for (int i = 0; i < map.length; i++) {
            String line = park[i];
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        
        // move 초기화
        move = new HashMap<>();
        
        move.put("W", new int[] {0, -1});
        move.put("N", new int[] {-1, 0});
        move.put("E", new int[] {0, 1});
        move.put("S", new int[] {1, 0});
        
        // 시작 지점 찾기
        x = -1;
        y = -1;
        
        for (int i = 0; i < park.length; i++) {
            y = park[i].indexOf("S");
            
            if (y != -1) {
                x = i;
                break;
            }
        }
        
        // 이동 수행
        for (int i = 0; i < routes.length; i++) {
            String[] commend = routes[i].split(" ");
            
            int[] nextMove = move.get(commend[0]);
            int multiple = Integer.parseInt(commend[1]);
            
            getMoveResult(nextMove, multiple);
        }
        
        return new int[] {x, y};
    }
}