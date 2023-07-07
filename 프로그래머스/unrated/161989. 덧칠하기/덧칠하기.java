class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 0;
        int range = 0;
        
        for (int i = 0; i < section.length; i++) {
            // 빈 벽 시작점부터 하나씩 차례대로 칠해본다.
            // 만약 다음으로 칠해야하는 벽이 이미 칠해져있다면 pass
            if (section[i] <= range) continue;
            
            count++;
            range = (section[i] + m) - 1;
        }
        
        return count;
    }
}