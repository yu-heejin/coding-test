class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[] {0, 0};
        int maxWidth = board[0] / 2;
        int minWidth = maxWidth * -1;
        int maxHeight = board[1] / 2;
        int minHeight = maxHeight * -1;
        
        for (String key : keyinput) {
            int nx = answer[0];
            int ny = answer[1];
            
            switch (key) {
                case "left":
                    nx = answer[0] - 1;
                    break;
                case "right":
                    nx = answer[0] + 1;
                    break;
                case "up":
                    ny = answer[1] + 1;
                    break;
                case "down":
                    ny = answer[1] - 1;
           }
            
            if (nx < minWidth || nx > maxWidth || ny < minHeight || ny > maxHeight) continue;
            
            answer[0] = nx;
            answer[1] = ny;
        }
        
        return answer;
    }
}