class Solution {
    public int solution(int a, int b, int n) {
        int bottleNumber = n;
        int totalCola = 0;
        
        while (bottleNumber >= a) {
            int takeBottle = bottleNumber - (bottleNumber % a);
            bottleNumber = (bottleNumber - takeBottle) + ((takeBottle / a) * b);
            totalCola += (takeBottle / a) * b;
        }
        
        return totalCola;
    }
}
