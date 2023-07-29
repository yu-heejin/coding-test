import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] numbers) {
        int sum = 0;
        List<Integer> numberCollections = Arrays.stream(numbers)
            .boxed()
            .collect(Collectors.toList());
        
        for (int i = 0; i <= 9; i++) {
            if (!numberCollections.contains(i)) {
                sum += i;
            }
        }
        
        return sum;
    }
}
