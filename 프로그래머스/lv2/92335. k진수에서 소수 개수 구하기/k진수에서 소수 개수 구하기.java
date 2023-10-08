class Solution {
    
    public int solution(int n, int k) {
        String convert = Integer.toString(n, k);
        String[] split = convert.split("0");
        
        int count = 0;
        for (String s : split) {
            if (!s.equals("") && isPrime(Long.parseLong(s))) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isPrime(long x) {
        if (x == 1) {
            return false;
        }
        
        for (long i = 2; i <= Math.sqrt(x); i++) {
		    if (x % i == 0) {
                return false;
            }
	    }

	    return true;
    }
}