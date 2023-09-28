import java.util.*;

class Solution {
    
    private int[] parent;
    
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        // 연결되었는지 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        
        int size = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                size++;
            }
        }
        
        return size;
    }
    
    private boolean union(int x, int y) {
        x = find(x); // x의 부모노드 찾기
        y = find(y); // y의 부모노드 찾기

        if(x == y) return false;

        if(x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }
    
    private int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
}