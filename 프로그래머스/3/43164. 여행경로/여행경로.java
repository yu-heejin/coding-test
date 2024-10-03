import java.util.*;

class Solution {
    private boolean[] visited;
    private List<String> results = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        // 모든 티켓을 다 사용했는지 확인
        visited = new boolean[tickets.length];
        
        dfs("ICN", tickets, "ICN");
        
        Collections.sort(results);
        
        return results.get(0).split(" ");
    }
    
    private void dfs(String route, String[][] tickets, String start) {
        if (isAllVisited()) {
            results.add(route);
            return;
        }
        
        // 모든 티켓 경로를 방문하기 위한 백트래킹
        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            
            // 현재 시작 지점에서 출발하는 티켓이고 아직 방문하지 않았다면
            if (ticket[0].equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(route + " " + ticket[1], tickets, ticket[1]);
                visited[i] = false;
            }
        }
    }
    
    private boolean isAllVisited() {
        for (boolean v : visited) {
            if (!v) return false;
        }
        
        return true;
    }
}