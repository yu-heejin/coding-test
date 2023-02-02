import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

class Solution {
    private List<List<Integer>> gameBoard;
    private Stack<Integer> bucket;
    
    public int solution(int[][] board, int[] moves) {
        gameBoard = new ArrayList<>();
        bucket = new Stack<>();
        
        initGameBoard(board);
        
        return addBucketAndGetAnswer(moves);
    }
    
    private void initGameBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            List<Integer> tempGameBoard = new ArrayList<>();
            
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] != 0) {
                    tempGameBoard.add(board[j][i]);
                }
            }
            
            gameBoard.add(tempGameBoard);
        }
    }
    
    private int addBucketAndGetAnswer(int[] moves) {
        int count = 0;
        
        for (int i = 0; i < moves.length; i++) {
            if (gameBoard.get(moves[i] - 1).size() != 0) {
                addBucket(moves, i);
            }
            
            if (bucket.size() >= 2) {
                count += getCount();
            }
        }
        
        return count;
    }
    
    private void addBucket(int[] moves, int i) {
        int pick = gameBoard.get(moves[i] - 1).get(0);
        bucket.push(pick);
        gameBoard.get(moves[i] - 1).remove(0);
    }
    
    private int getCount() {
        int maxSize = bucket.size();
        int count = 0;
        
        if (bucket.get(maxSize - 1) == bucket.get(maxSize - 2)) {
            count = 2;
            bucket.pop();
            bucket.pop();
        }
        
        return count;
    }
}
