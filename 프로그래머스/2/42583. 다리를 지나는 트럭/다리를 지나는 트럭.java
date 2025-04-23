import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int i = 0;
        int time = 0;
        int currentWeight = 0;
        
        while (i < truck_weights.length) {
            // 1. 내릴 트럭 먼저 내리기
            if (q.size() == bridge_length) {
                int truckWeight = q.poll();
                currentWeight -= truckWeight;
            }
            
            // 2. 다음 트럭 타기
            if (q.size() < bridge_length) {
                if (currentWeight + truck_weights[i] <= weight) {
                    q.add(truck_weights[i]);
                    currentWeight += truck_weights[i];
                    i++;
                } else {
                    q.add(0);   // 자리가 찼음을 알리기 위함
                }
            }
            
            time++;
        }
        
        return time + bridge_length;   // 마지막 트럭에 대한 시간 추가, 마지막 트럭 이후 시간 갱신 안됨
    }
}