import java.util.Arrays;

class Solution {
    private final int START = 0;
    private final int END = 1;
    private final int POSITION = 2;
    
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            answer[i] = getResult(array, commands[i]);
        }
        
        return answer;
    }
    
    private int getResult(int[] array, int[] command) {
        int[] subArray = Arrays.copyOfRange(array, command[START] - 1, command[END]);
        Arrays.sort(subArray);
        return subArray[command[POSITION] - 1];
    }
}
