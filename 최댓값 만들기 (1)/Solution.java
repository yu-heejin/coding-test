import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        // 원소의 범위는 양수이기 때문에 양수 중 가장 큰 수 두개를 곱하면 된다.
        Arrays.sort(numbers);
        
        int answer = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        
        return answer;
    }
}
