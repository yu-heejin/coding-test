import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> myPhoneketmon = new HashSet<>();
        int pickCount = nums.length / 2;
        
        for (int n : nums) {
            myPhoneketmon.add(n);
        }
        
        if (myPhoneketmon.size() > pickCount) {
            return pickCount;
        }
        
        return myPhoneketmon.size();
    }
}