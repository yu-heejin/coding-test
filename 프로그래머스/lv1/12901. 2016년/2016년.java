class Solution {
    private final String[] DAYS = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
    private final int[] MONTHS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    
    public String solution(int a, int b) {
        // 1일에서 계속 7을 더한 날은 금요일이다.
        // 30, 31, 29일이 넘어가면 마지막 일수를 뺀다.
        // 2월을 제외하고 홀수달은 31, 짝수달은 30 -> 7월, 8월 기점으로 바뀜!
        
        // 우선 해당 달까지 점프한다.
        // 결과는 1월 1일부터 n일이 지났음을 의미한다.
        // 만약 5월이면 0, 1, 2, 3 -> 4달이 지났음을 의미함
        int startDate = 0;
        
        for (int i = 0; i < a - 1; i++) {
            startDate += MONTHS[i];
        }
        
        // 이후 1일부터 b일까지 더해준다.
        startDate += (b - 1);
        
        return DAYS[startDate % 7];
    }
}