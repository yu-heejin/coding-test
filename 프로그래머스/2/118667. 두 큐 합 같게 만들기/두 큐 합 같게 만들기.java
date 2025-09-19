import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        if ((sum1 + sum2) % 2 > 0) {
            // 홀수로는 같은 합을 만들 수 없다.
            return -1;
        }
        
        int count = 0;
        // 큐의 모든 원소가 한번씩 도는 경우의 수
        while (count <= queue1.length * 2 + 2) {
            // 각 큐의 합을 계산해서, 더 큰 쪽이 더 작은 쪽으로 원소를 이동한다.
            if (sum1 > sum2) {
                int temp = q1.poll();
                q2.add(temp);
                sum1 -= temp;
                sum2 += temp;
            } else if (sum1 == sum2) {
                return count;
            } else {
                int temp = q2.poll();
                q1.add(temp);
                sum2 -= temp;
                sum1 += temp;
            }
            
            count++;
        }
        
        if (sum1 == sum2) {
            return count;
        }
        
        return -1;
    }
}