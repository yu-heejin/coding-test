class Solution {
    private int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        dfs(new boolean[dungeons.length], dungeons, k, 0);
        
        return answer;
    }
    
    // 이전 인덱스도 방문해야 하기 때문에 시작 인덱스를 주지 말고 반복문은 0부터 시작해야 한다.
    private void dfs(boolean[] visited, int[][] dungeons, int power, int count) {
        for (int i = 0; i < dungeons.length; i++) {
            // 아직 방문하지 않았고, 최소 필요 피로도가 현재 힘보다 작거나 같을 때
            if (!visited[i] && dungeons[i][0] <= power) {
                visited[i] = true;
                dfs(visited, dungeons, power - dungeons[i][1], count + 1);
                visited[i] = false;
            }
        }
        
        // 던전 방문 순서는 첫번째 -> 세번째 -> 두번째 순으로도 방문 가능한 것으로 보아 모든 던전을 방문해야한다.
        answer = Math.max(answer, count);
    }
}