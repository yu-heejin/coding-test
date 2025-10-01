class Solution {
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        visitedDungeons(new boolean[dungeons.length], dungeons, k, 0);
        
        return answer;
    }
    
    // 모든 던전을 방문해보는 경우의 수
    private void visitedDungeons(boolean[] visited, int[][] dungeons, int k, int count) {
        for (int i = 0; i < dungeons.length; i++) {
            // 최소 피로도는 항상 소모 피로도보다 크다
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                k -= dungeons[i][1];
                visitedDungeons(visited, dungeons, k, count + 1);
                k += dungeons[i][1];
                visited[i] = false;
            }
        }
        
        answer = Math.max(answer, count);
    }
}