import java.util.*;

class Solution {
    private int[] parent;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < wires.length; i++) {
            parent = new int[n + 1];
            
            for (int j = 0; j <= n; j++) {
                parent[j] = j;
            }
            
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                
                union(wires[j][0], wires[j][1]);
            }
            
            // 가장 작은 수가 parent가 되므로, 끊어진 값을 기준으로 1과 아닌 노드를 비교하면 둘로 나눌 수 있다.
            //System.out.println(Arrays.toString(parent));
            
            int first = 0;
            int second = 0;
            
            // parent 정리
            for (int j = 0; j <= n; j++) {
                parent[j] = find(j);
            }
            
            for (int j = 1; j <= n; j++) {
                if (parent[j] == parent[wires[i][0]]) {
                    first++;
                } else {
                    second++;
                }
            }
            
            answer = Math.min(answer, Math.abs(first - second));
        }
        
        return answer;
    }
    
    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x == y) return;
        
        if (x < y) parent[y] = x;
        else parent[x] = y;
    }
    
    private int find(int a) {
        if (parent[a] == a) return a;
        
        return find(parent[a]);
    }
}