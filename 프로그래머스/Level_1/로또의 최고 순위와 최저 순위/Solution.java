import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    List<Integer> win_nums_boxed;
    Map<Integer, Integer> results;
    
    public int[] solution(int[] lottos, int[] win_nums) {
        int lowCount = 0;
        int highCount = 0;
        
        addResults();
        addWinNumsBoxed(win_nums);
        
        for (int i = 0; i < lottos.length; i++) {
            if (win_nums_boxed.contains(lottos[i])) {
                lowCount++;
                highCount++;
            } else if (lottos[i] == 0) {
                highCount++;
            }
        }
        
        return new int[] { results.get(highCount), results.get(lowCount) };
    }
    
    private void addResults() {
        results = new HashMap<>();
        
        results.put(6, 1);
        results.put(5, 2);
        results.put(4, 3);
        results.put(3, 4);
        results.put(2, 5);
        results.put(1, 6);
        results.put(0, 6);
    }
    
    private void addWinNumsBoxed(int[] win_nums) {
        win_nums_boxed = new ArrayList<>();
        
        // 길이가 작기 때문에 stream 대신 반복문 사용
        for (int i = 0; i < win_nums.length; i++) {
            win_nums_boxed.add(win_nums[i]);
        }
    }
}
