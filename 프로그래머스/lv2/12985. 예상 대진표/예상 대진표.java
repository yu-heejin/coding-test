class Solution
{
    public int solution(int n, int a, int b)
    {
        int round = 1;
        
        while (true) {
            // 홀수는 무조건 작고, 짝수는 무조건 크다
            if ((a % 2 != 0 && b == a + 1) || (b % 2 != 0 && a == b + 1)) {
                break;
            }
            
            if (a % 2 == 0) {
                a /= 2;
            } else {
                a = (a / 2) + 1;
            }
            
            if (b % 2 == 0) {
                b /= 2;
            } else {
                b = (b / 2) + 1;
            }
            
            round++;
        }
        
        return round;
    }
}