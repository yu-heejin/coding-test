class Solution {
    
    public int solution(int n) {
        int answer = n + 1;
        String binaryN = Integer.toBinaryString(n);
        int binaryNOneCount = countOne(binaryN);
        
        while (true) {
            String binary = Integer.toBinaryString(answer);
            int binaryOneCount = countOne(binary);
            if (binaryOneCount == binaryNOneCount) {
                break;
            }
            answer++;
        }
        
        return answer;
    }
    
    private int countOne(String binary) {
        int count = 0;
        
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) - '0' == 1) {
                count++;
            }
        }
        
        return count;
    }
}