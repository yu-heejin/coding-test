import java.util.*;

class Solution {
    public int solution(String name) {
        return getMinMoveCount(name);
    }
    
    private int getMinMoveCount(String name) {
        int result = 0;
        int move = name.length() - 1;  // 기본 좌우이동 횟수(정방향/역방향)
        
        // 상하로 이동해 알파벳을 변경하는 횟수
        for (int i = 0; i < name.length(); i++) {
            char nameChar = name.charAt(i);
            // +1을 하는 이유는 첫 글자가 Z가 아니라 A이기 때문이다.
            result += Math.min(nameChar - 'A', 'Z' - nameChar + 1);
            
            // 내 다음 알파벳부터 탐색
            int next = i + 1;
            
            // A가 안나올 때까지 이동 (정방향)
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            
            // 1. 오른쪽 -> 왼쪽: 오른쪽으로 이동하는 경우, A를 만나면 방향을 틀어 왼쪽으로 이동
            // 2. 왼쪽 -> 오른쪽: 왼쪽으로 이동하는 경우, A를 만나면 방향을 틀어 오른쪽으로 이동
            // i * 2 == 해당 부분까지 오른쪽으로 이동했다가 다시 원점으로 돌아가는 횟수
            // name.length() - next == 해당 부분까지 왼쪽으로 이동하는 횟수
            move = Math.min(move, (i * 2) + name.length() - next);
            move = Math.min(move, (name.length() - next) * 2 + i);
        }
        
        // 이동 횟수의 최소는 마지막에 더해주어야 한다.
        result += move;
        
        return result;
    }
}