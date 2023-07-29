import java.util.List;
import java.util.ArrayList;

class Solution {
    private List<Integer> measureCounts;
    private int measureCountIndex;
    private int totalKgSum;
    
    public int solution(int number, int limit, int power) {
        measureCounts = new ArrayList<>();
        measureCountIndex = 0;
        totalKgSum = 0;
        
        int personNumber = 1;
        int numberForDevide = 1;
        int count = 0;
        
        while (personNumber <= number) {
            count = calculateCount(count, personNumber, numberForDevide);
            numberForDevide++;
            
            if (numberForDevide > Math.sqrt(personNumber)) {
                addMeasureCounts(count);
                numberForDevide = 1;
                personNumber++;
                count = 0;
                
                addTotalKgSum(limit, power);
                measureCountIndex++;
            }
        }
        
        return totalKgSum;
    }
    
    private int calculateCount(int count, int personNumber, int numberForDevide) {
        if (personNumber % numberForDevide == 0) {
            count++;
            
            if (personNumber / numberForDevide != numberForDevide) {
                count++;
            }
        }
        
        return count;
    }
    
    private void addMeasureCounts(int count) {
        measureCounts.add(count);
    }
    
    private void addTotalKgSum(int limit, int power) {
        totalKgSum += getKgSum(limit, power);
    }
    
    private int getKgSum(int limit, int power) {
        if (measureCounts.get(measureCountIndex) > limit) {
            return power;
        }
        
        return measureCounts.get(measureCountIndex);
    }
}
