import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

class Solution {
    private final int PICK_NUMBER = 2;
    private Set<Integer> results;
    private int[] bucket;
    
    public int[] solution(int[] numbers) {
        results = new TreeSet<>();
        bucket = new int[PICK_NUMBER];
        
        combination(numbers, numbers.length, PICK_NUMBER);
        
        return getAnswer();
    }
    
    private void combination(int[] numbers, int n, int r) {
        if (r == 0) {
            results.add(numbers[bucket[0]] + numbers[bucket[1]]);
            return;
        }
        
        int lastIndex = bucket.length - r - 1;
        int smallest = getSmallest(r, lastIndex);
        
        for (int i = smallest; i < n; i++) {
            bucket[lastIndex + 1] = i;
            combination(numbers, n, r - 1);
        }
    }
    
    private int getSmallest(int r, int lastIndex) {
        if (bucket.length > r) {
            return bucket[lastIndex] + 1;
        }
        
        return 0;
    }
    
    private int[] getAnswer() {
        int[] answers = new int[results.size()];
        Iterator<Integer> iterator = results.iterator();
        int answerIndex = 0;
        
        while (iterator.hasNext()) {
            answers[answerIndex] = iterator.next();
            answerIndex++;
        }
        
        return answers;
    }
}
