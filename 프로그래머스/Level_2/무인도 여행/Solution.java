// code reference from: https://123okk2.tistory.com/422
import java.util.*;

class Solution {
    private final int[] NO_ANSWER = { -1 };
    private List<Integer> tempAnswers;
    private int[][] matrix;
    private boolean[][] visited;
    
    public int[] solution(String[] maps) {
        tempAnswers = new ArrayList<>();
        
        initMatrix(maps);
        initAnswers();
        
        return getAnswers();
    }
    
    private void initMatrix(String[] maps) {
        matrix = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                matrix[i][j] = getMatrixValue(maps, i, j);
                visited[i][j] = false;
            }
        }
    }
    
    private int getMatrixValue(String[] maps, int row, int col) {
        if (maps[row].charAt(col) >= '1' && maps[row].charAt(col) <= '9') {
            return maps[row].charAt(col) - '0';
        } 
        
        return -1;
    }
    
    private void initAnswers() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int sum = dfs(i, j);
                
                if (sum > 0) {
                    tempAnswers.add(sum);
                }
            }
        }
    }
    
    private int dfs(int row, int col) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) {
            return 0;
        }
        
        if (visited[row][col]) {
            return 0;
        }
        
        visited[row][col] = true;
        
        if (matrix[row][col] == -1) {
            return 0;
        }
        
        // DFS: 상하좌우로 탐색하여 값을 더해준다.
        return matrix[row][col] + dfs(row-1, col) + dfs(row+1, col) + dfs(row, col-1) + dfs(row, col+1);
    }
    
    private int[] getAnswers() {
        if (tempAnswers.size() == 0) {
            return NO_ANSWER;
        }
        
        Collections.sort(tempAnswers);
        
        int[] answers = new int[tempAnswers.size()];
        
        for (int i = 0; i < tempAnswers.size(); i++) {
            answers[i] = tempAnswers.get(i);
        }
        
        return answers;
    }
}
