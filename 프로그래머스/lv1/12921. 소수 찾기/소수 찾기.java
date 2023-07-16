// 에라토스테네스의 체: 1의자리 소수인 수의 배수를 모두 지운다.
// 소수의 배수는 소수를 약수로 가지므로 제외한다.
class Solution {
    public int solution(int n) {
        boolean[] checkPrime = new boolean[n + 1];
        int count = 0;
        
        checkPrime[0] = false;
        checkPrime[1] = false;   // 1은 소수가 아니다.
        
        for (int i = 2; i <= n; i++) {
            checkPrime[i] = true;
        }
        
        for (int i = 2; i * i <= n; i++) {
            if (checkPrime[i]) {
                for (int j = 2 * i; j <= n; j += i) checkPrime[j] = false;
            }
        }
        
        for (boolean isPrime : checkPrime) {
            if (isPrime) {
                count++;
            }
        }
        
        return count;
    }
}