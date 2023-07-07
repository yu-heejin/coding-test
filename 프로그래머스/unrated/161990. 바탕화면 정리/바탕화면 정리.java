import java.util.*;

class Solution {
    
    public int[] solution(String[] wallpaper) {
        // 파일의 위치 저장
        List<int[]> position = new ArrayList<>();
        
        for (int i = 0; i < wallpaper.length; i++) {
            String paperLine = wallpaper[i];
            
            for (int j = 0; j < paperLine.length(); j++) {
                if (paperLine.charAt(j) == '#') {
                    position.add(new int[] {i, j});
                }
            }
        }
        
        // 파일의 위치에서 가장 외곽에 있는 위치 선정
        // 가장 위, 아래, 왼쪽, 오른쪽
        // 배열의 순서는 row, col
        // 배열이 아니라 좌표를 생각해야할 것 같다.
        int up = 51;
        int down = -1;
        int left = 51;
        int right = -1;
        
        for (int[] p : position) {
            up = Math.min(up, p[0]);
            down = Math.max(down, p[0] + 1);
            left = Math.min(left, p[1]);
            right = Math.max(right, p[1] + 1);
        }
        
        return new int[] {up, left, down, right};
    }
}