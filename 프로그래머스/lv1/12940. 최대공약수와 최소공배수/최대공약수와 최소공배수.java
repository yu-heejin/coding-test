class Solution {
    public int[] solution(int n, int m) {
        int a = n;
        int b = m;
        
        // 최대공약수 구하기
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        
        int g = a;
        int l = (n * m) / g;  // 최소 공배수는 두 자연수의 곱 나누기 최대공약수
        
        return new int[] { g, l };
    }
}