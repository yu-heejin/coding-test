class Solution {
    
    private boolean[] visited;
    private int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        getMaxCount(0, k, dungeons);
        return max;
    }
    
    private void getMaxCount(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            // 방문 가능한지 확인
            // 최소 피로도는 항상 소모 피로도보다 크기 때문에 별도로 체크할 필요 없음
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                getMaxCount(depth + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        
        if (max < depth) {
            max = depth;
        }
    }
}