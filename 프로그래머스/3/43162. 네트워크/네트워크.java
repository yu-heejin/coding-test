class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            // 이미 방문한 곳은 어딘가 연결되어 있다는 의미이므로 탐색할 필요 없다.
            if (!visited[i]) {
                dfs(computers, visited, i);   // 해당 지점부터 방문 시작, 연결고리 확인
                count++;
            }
        }
        
        return count;
    }
    
    // 인접행렬 dfs
    private void dfs(int[][] computers, boolean[] visited, int start) {
        visited[start] = true;
        
        for (int i = 0; i < computers.length; i++) {
            if (computers[start][i] == 1 && !visited[i]) {
                dfs(computers, visited, i);
            }
        }
    }
}