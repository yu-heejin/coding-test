class Solution {
    public int solution(int[] arr) {
        int answer = (arr[0] * arr[1]) / getGCD(arr[0], arr[1]);
        
        // 이전 최소 공배수 * 다음 수 / GCD(이전 최소 공배수, 다음 수)
        // 최소 공배수 : (a x b) / (최대 공약수)
        for (int i = 2; i < arr.length; i++) {
            answer = (answer * arr[i]) / getGCD(answer, arr[i]);
        }
        
        return answer;
    }
    
    // 최대 공약수 구하기
    private int getGCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        
        return getGCD(b, a % b);
    }
}