import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        List<String> friendsForFindIndex = Arrays.asList(friends);
        Map<String, Integer> giftCount = new HashMap<>();
        // 준 사람 / 받은 사람
        int[][] transactionCount = new int[friends.length][friends.length];
        
        for (int i = 0; i < gifts.length; i++) {
            String[] names = gifts[i].split(" ");
            
            int sender = friendsForFindIndex.indexOf(names[0]);
            int receiver = friendsForFindIndex.indexOf(names[1]);
            
            transactionCount[sender][receiver]++;
            
            // 선물지수
            giftCount.put(names[0], giftCount.getOrDefault(names[0], 0) + 1);
            giftCount.put(names[1], giftCount.getOrDefault(names[1], 0) - 1);
        }
        
        int[] result = new int[friends.length];
        
        for (int i = 0; i < transactionCount.length; i++) {
            for (int j = 0; j < transactionCount.length; j++) {
                if (i == j) continue;
                
                // 1. 두 사람 사이에 선물을 주고받은 기록이 있다면, 이번달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음달에 선물을 하나 받는다.
                int sendCount = transactionCount[i][j];
                int receiveCount = transactionCount[j][i];
                
                if (sendCount > receiveCount) {
                    result[i]++;
                } else if (sendCount == receiveCount || sendCount == 0 && receiveCount == 0) {
                    // 2. 두 사람이 선물을 주고받은 기록이 없거나 주고받은 수가 같은 경우, 선물 지수가 더 큰 사람이 선물지수가 더 작은 사람에게 선물을 하나 받는다.
                    // 이 때, 아예 거래를 하지 않은 사람도 있기 때문에 선물 지수에 없을 수도 있음
                    if (giftCount.getOrDefault(friends[i], 0) > giftCount.getOrDefault(friends[j], 0)) {
                        result[i]++;
                    }
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < result.length; i++) {
            max = Math.max(max, result[i]);
        }
        
        return max;
    }
}