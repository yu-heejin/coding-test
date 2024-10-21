class Solution {
    public boolean solution(int x) {
        // 모든 자리수의 합
        int result = 0;
        int number = x;
        
        while (number > 0) {
            result += (number % 10);
            number /= 10;
        }
        
        System.out.println(result);
        
        // 나누어 떨어지면 하샤드 수
        if (x % result == 0) {
            return true;
        }
        
        return false;
    }
}