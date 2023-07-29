import java.util.List;
import java.util.ArrayList;

class Solution {
    private final char WALL = '#';
    private final char BLANK = ' ';
    private final char WALL_NUMBER = '1';
    private final char BLANK_NUMBER = '0';
    private final String ZERO = "0";
    private List<String> decodeArr1Results;
    private List<String> decodeArr2Results;
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        decodeArr1Results = new ArrayList<>();
        decodeArr2Results = new ArrayList<>();
        
        initDecodeResults(n, arr1, arr2);

        return getAnswer(n);
    }
    
    private void initDecodeResults(int n, int[] arr1, int[] arr2) {
        for (int i = 0; i < n; i++) {
            String decodeArr1Result = Integer.toBinaryString(arr1[i]);
            String decodeArr2Result = Integer.toBinaryString(arr2[i]);
            
            if (decodeArr1Result.length() < n) {
                decodeArr1Result = addZero(n, decodeArr1Result) + decodeArr1Result;
            }
            
            if (decodeArr2Result.length() < n) {
                decodeArr2Result = addZero(n, decodeArr2Result) + decodeArr2Result;
            }
            
            decodeArr1Results.add(decodeArr1Result);
            decodeArr2Results.add(decodeArr2Result);
        }
    }
    
    private String addZero(int n, String decodeResult) {
        StringBuilder temp = new StringBuilder();
        
        for (int j = 1; j <= n - decodeResult.length(); j++) {
            temp.append(ZERO);
        }
        
        return temp.toString();
    }
    
    private String[] getAnswer(int n) {
        String[] answers = new String[n];
        
        for (int i = 0; i < n; i++) {
            StringBuilder result = new StringBuilder();
            
            for (int j = 0; j < n; j++) {
                char room1 = decodeArr1Results.get(i).charAt(j);
                char room2 = decodeArr2Results.get(i).charAt(j);
                
                if (room1 == BLANK_NUMBER && room2 == BLANK_NUMBER) {
                    result.append(BLANK);
                } 
        
                if (room1 == WALL_NUMBER || room2 == WALL_NUMBER) {
                    result.append(WALL);
                }
            }
            
            answers[i] = result.toString();
        }
        
        return answers;
    }
}
