/***
현재 day	    day % 7	    결과 (% 7 + 1)	설명
1	        1	        2	            월 → 화
2	        2	        3	            화 → 수
3	        3	        4	            수 → 목
4	        4	        5	            목 → 금
5	        5	        6	            금 → 토
6	        6	        7	            토 → 일
7	        0	        1               일 → 월 (순환됨)
***/
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < schedules.length; i++) {
            // 해당 직원의 희망 출근 시간
            int hour = schedules[i] / 100;
            int minute = schedules[i] % 100;
            int day = startday;
            
            // 최대 출근 시간 계산
            int maxMinute = minute + 10;
            int maxHour = hour;
            
            if (maxMinute >= 60) {
                maxMinute -= 60;
                maxHour++;
            }
            
            int maxTime = (maxHour * 100) + maxMinute;
            int count = 0;
            
            // 지각했는지 확인
            for (int j = 0; j < timelogs[i].length; j++) {
                if (day == 6 || day == 7) {
                    day = day % 7 + 1;
                    continue;
                }
                
                if (timelogs[i][j] >= schedules[i] && timelogs[i][j] <= maxTime || timelogs[i][j] < schedules[i]) {
                    count++;
                }
                // 5 6 7 1 2 3 4
                day = day % 7 + 1;
            }
            
            System.out.println();
            
            if (count == 5) {
                answer++;
            }
        }
        
        return answer;
    }
}