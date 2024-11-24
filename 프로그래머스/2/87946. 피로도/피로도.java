/* DFS + 백트래킹 (완전탐색) */
class Solution {
    private int maxCount = -1;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        dfs(dungeons, visited, 0, k);
        
        return maxCount;
    }
    
    private void dfs(int[][] dungeons, boolean[] visited, int count, int k) {
        maxCount = Math.max(maxCount, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            // 아직 방문하지 않았고 최소 필요 피로도가 현재 피로도보다 작거나 같은 경우
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(dungeons, visited, count + 1, k - dungeons[i][1]);
                visited[i] = false;
            }
        }
    }
}