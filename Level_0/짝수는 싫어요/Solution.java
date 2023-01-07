import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> solution(int n) {
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 1; i <= n; i += 2) {
            answer.add(i);
        }
        
        return answer;
    }
}
