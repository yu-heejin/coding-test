class Solution {
    public int solution(String t, String p) {
        Long pNumber = Long.parseLong(p);
        int count = 0;
        int tStartIndex = 0;
        int tEndIndex = tStartIndex + p.length();
        
        /* 해당 코드에서 일부 케이스에 대해 런타임 에러 발생 */
        /* 숫자가 길어지면 int가 아니라 long으로 풀어볼 것! */
        while (tEndIndex <= t.length()) {
            long subNumber = Long.parseLong(t.substring(tStartIndex, tEndIndex));
            
            if (subNumber <= pNumber) {   // 작거나 같은 숫자를 판별한다.
                count++;
            }
            
            tStartIndex++;
            tEndIndex++;
        }
        
        return count;
    }
}
