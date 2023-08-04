import java.util.*;

class Solution {
    
    private Set<Integer> answers;
    
    public int solution(int[] elements) {
        answers = new HashSet<>();
        
        int size = elements.length;
        int start = 0;
        
        // 배열에서 시작점을 정하고 n칸씩 이동한다.
        // 배열이 끝에서 시작할 경우 다시 처음으로 돌아가야한다.
        for (int len = 1; len <= size; len++) {
            for (int i = 0; i < size; i++) {
                int sum = 0;
                int count = 0;
                
                while (count < len) {
                    sum += elements[(i + count) % size];
                    count++;
                }
                
                answers.add(sum);
            }
        }
        
        return answers.size();
    }
}