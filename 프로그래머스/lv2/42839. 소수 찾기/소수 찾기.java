import java.util.*;

class Solution {
    
    private int[] bucket;
    private int[] pickNumber;
    private int count = 0;
    private Set<Integer> temp = new HashSet<>();
    
    public int solution(String numbers) {
        pickNumber = new int[numbers.length()];
        
        for (int i = 0; i < numbers.length(); i++) {
            pickNumber[i] = numbers.charAt(i) - '0';
        }
        
        for (int i = 1; i <= numbers.length(); i++) {
            bucket = new int[i];
            combination(pickNumber, numbers.length(), i);
        }
        
        Iterator<Integer> iter = temp.iterator();

        while(iter.hasNext()) {
            int result = iter.next();
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(result); i++) {
                if (result % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;
            }
        }
        
        return count;
    }
    
    private void combination(int[] numbers, int n, int r) {
        if (r == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bucket.length; i++) {
                sb.append(numbers[bucket[i]]);
            }
            
            int result = Integer.parseInt(sb.toString());
            if (result > 1) {
                temp.add(result);
            }
            
            return;
        }

        int lastIndex = bucket.length - r - 1;
        int smallest = 0;

        for (int i = smallest; i < n; i++) {
            boolean isPick = false;

            for (int j = 0; j < lastIndex + 1; j++) {
                if (i == bucket[j]) {
                    isPick = true;
                    break;
                }
            }

            if (!isPick) {
                bucket[lastIndex + 1] = i;
                combination(numbers, n, r - 1);
            }
        }
    }
}