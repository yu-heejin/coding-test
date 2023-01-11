import java.util.List;
import java.util.ArrayList;

class Solution {
    private List<Integer> measureCounts;
    private int totalKgSum;
    
    public int solution(int number, int limit, int power) {
        measureCounts = new ArrayList<>();
        totalKgSum = 0;
        
        int personNumber = 1;
        int numberForDevide = 1;
        int count = 0;
        int measureCountIndex = 0;
        
        while (personNumber <= number) {
            if (personNumber % numberForDevide == 0) {
                count++;
                
                if (personNumber / numberForDevide != numberForDevide) {
                    count++;
                }
            }
            
            numberForDevide++;
            
            if (numberForDevide > Math.sqrt(personNumber)) {
                measureCounts.add(count);
                numberForDevide = 1;
                personNumber++;
                count = 0;
                
                totalKgSum += getKgSum(limit, power, measureCountIndex);
                measureCountIndex++;
            }
        }
        
        return totalKgSum;
    }
    
    private int getKgSum(int limit, int power, int index) {
        if (measureCounts.get(index) > limit) {
            return power;
        }
        
        return measureCounts.get(index);
    }
}
