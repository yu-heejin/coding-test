import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    private final int X_COUNT_INDEX = 0;
    private final int NOT_X_COUNT_INDEX = 1;
    private final int FOR_INIT_VALUE = 0;
  
    private int[] counts = {FOR_INIT_VALUE, FOR_INIT_VALUE};
    private int positionForSaveAndStartX = 0;
    private String temp = "";
    private List<String> stringsBySplit = new ArrayList<>();
    
    public int solution(String s) {
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(positionForSaveAndStartX);
            temp = s.substring(positionForSaveAndStartX, i + 1);
            
            getCountResult(x, s.charAt(i));
            
            if (counts[X_COUNT_INDEX] == counts[NOT_X_COUNT_INDEX]) {
                addResultAndinitValues(i);
            }
        }
        
        addResultIfTempNotEmpty();
        
        return stringsBySplit.size();
    }
    
    private void getCountResult(char x, char fromS) {
        if (fromS == x) {
            counts[X_COUNT_INDEX]++;
            return;
        }
        
        counts[NOT_X_COUNT_INDEX]++;
    }
    
    private void addResultAndinitValues(int position) {
        stringsBySplit.add(temp);
        temp = "";
        positionForSaveAndStartX = position + 1;
        Arrays.fill(counts, FOR_INIT_VALUE);
    }
    
    private void addResultIfTempNotEmpty() {
        if (!temp.equals("")) {
            stringsBySplit.add(temp);
        }
    }
}
