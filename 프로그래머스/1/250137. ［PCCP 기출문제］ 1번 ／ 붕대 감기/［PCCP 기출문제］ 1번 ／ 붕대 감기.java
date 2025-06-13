class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int physical = health;    // 현재 체력
        int endTime = attacks[attacks.length - 1][0];    // 마지막 공격 시간
        int success = 0;    // 연속 성공 시간, 성공하면 체력을 y만큼 추가 회복
        int attacksIndex = 0;    // 공격 인덱스
        
        for (int i = 1; i <= endTime; i++) {
            // 체력이 0 이하면 -1
            if (physical <= 0) {
                physical = -1;
                break;
            }
            
            // 공격 당하는 시간인지 확인
            if (attacks[attacksIndex][0] == i) {
                success = 0;
                physical -= attacks[attacksIndex][1];
                attacksIndex++;
                continue;
            }
            
            // 초당 회복량만큼 더해준다.
            physical = (physical + bandage[1]) > health 
                ? health
                : physical + bandage[1];
            success++;
            
            // 연속 성공 시간이 붕대 감는 시간이랑 같으면 추가 회복
            if (success == bandage[0]) {
                // 추가 회복 시에도 비교해야한다.
                physical = (physical + bandage[2]) > health 
                    ? health
                    : physical + bandage[2];
                success = 0;
            }
        }
        
        return physical <= 0 ? -1 : physical;
    }
}