import java.io.*;
import java.util.*;

public class Main {
    
    private static int isSuccess = 0;
    private static List<List<Integer>> numbers = new ArrayList<>();
    private static boolean[] visited;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            numbers.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            numbers.get(a).add(b);
            numbers.get(b).add(a);
        }
        
        for (int i = 0; i < n; i++) {
            if (numbers.get(i).size() == 0) continue;
            if (isSuccess == 1) continue;
            
            // 특정 노드에서부터 시작한다.
            dfs(1, i);
        }
        
        System.out.println(isSuccess);
    }
    
    private static void dfs(int depth, int friend) {
        // 일직선 5명의 관계를 이루므로 정답
        if (depth == 5) {
            isSuccess = 1;
            return;
        }
        
        visited[friend] = true;
        List<Integer> friends = numbers.get(friend);
        
        for (int f : friends) {
            if (!visited[f]) {
                visited[f] = true;
                dfs(depth + 1, f);
                visited[f] = false;
            }
        }
        
        // 다음 탐색 시 영향을 주지 않기 위해 false
        visited[friend] = false;
    }
}