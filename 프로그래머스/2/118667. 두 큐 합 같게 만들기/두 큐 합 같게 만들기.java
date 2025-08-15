import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 큐 추가
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        // 합 구하기
        long q1Sum = 0;
        long q2Sum = 0;
        
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            
            q1Sum += queue1[i];
            q2Sum += queue2[i];
        }
        
        int answer = 0;
        int n = queue1.length;
        if ((q1Sum + q2Sum) % 2 > 0) {
            return -1;
        }
        long target = (q1Sum + q2Sum) / 2;
        
        // 모든 큐가 한번씩 움직이는 경우가 2n임
        while (answer <= 2 * n + 1) {
            if (q1Sum > q2Sum) {
                int num = q1.poll();
                q2.add(num);
                q1Sum -= num;
                q2Sum += num;
                answer++;
            } else if (q1Sum == q2Sum) {
                return answer;
            } else {
                int num = q2.poll();
                q1.add(num);
                q2Sum -= num;
                q1Sum += num;
                answer++;
            }
        }
        
        return q1Sum == q2Sum ? answer : -1;
    }
}