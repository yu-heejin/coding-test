import java.util.*;

class Solution {
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> list = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> positions = new LinkedList<>();
        
        int i = 0;
        for (int p : priorities) {
            list.add(p);
            queue.add(p);
            positions.add(i);
            i++;
        }
        
        int first = list.poll();
        
        int count = 0;
        while (!queue.isEmpty()) {
            int process = queue.poll();
            int l = positions.poll();
            
            if (process == first) {
                if (l == location) {
                    answer = count + 1;
                    break;
                }
                first = list.poll();
                count++;
            } else {
                queue.add(process);
                positions.add(l);
            }
        }

        return answer;
    }
}