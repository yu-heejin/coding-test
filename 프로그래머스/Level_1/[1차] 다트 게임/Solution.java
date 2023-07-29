import java.util.Stack;
import java.util.List;
import java.util.Arrays;

class Solution {
    private final List<Character> DOMAIN = Arrays.asList('S', 'D', 'T');
    private final List<Integer> POW = Arrays.asList(1, 2, 3);
    private Stack<Integer> bucket;
    private boolean isTen = false;
    
    public int solution(String dartResult) {
        bucket = new Stack<>();
        
        for (int i = 0; i < dartResult.length(); i++) {
            char element = dartResult.charAt(i);
            initBucketByCalculation(dartResult, element, i);
            
            if (isTen) {
                i++;
            }
            isTen = false;
        }
        
        return getAnswer();
    }
    
    private void initBucketByCalculation(String dartResult, char element, int index) {
        if (element >= '0' && element <= '9') {
            initBucketWhenNumber(dartResult, element, index);
        }
        
        if (element >= 'A' && element <= 'Z') {
            initBucketWhenChar(element);
        }
        
        if (element == '*') {
            initBucketWhenStart();
        } 
        
        if (element == '#') {
            initBucketWhenPoundKey();
        }
    }
    
    private void initBucketWhenNumber(String dartResult, char element, int index) {
        if (index < dartResult.length() - 1 && dartResult.charAt(index + 1) == '0') {
            bucket.push(10);
            isTen = true;
        } else {
            bucket.push(element - '0');
        }
    }
    
    private void initBucketWhenChar(char element) {
        int result = (int) Math.pow(bucket.pop(), POW.get(DOMAIN.indexOf(element)));
        bucket.push(result);
    }
    
    private void initBucketWhenStart() {
        if (bucket.size() >= 2) {
            int result1 = bucket.pop() * 2;
            int result2 = bucket.pop() * 2;
            bucket.push(result2);
            bucket.push(result1);
        } else {
            int result = bucket.pop() * 2;
            bucket.push(result);
        }
    }
    
    private void initBucketWhenPoundKey() {
         int result = bucket.pop() * (-1);
        bucket.push(result);
    }
    
    private int getAnswer() {
        int sum = 0;
        
        for (int i = 0; i < bucket.size(); i++) {
            sum += bucket.get(i);
        }
        
        return sum;
    }
}
