import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // 트리 구조, 기본 key 오름차순 정렬
        TreeMap<Integer, Integer> pq = new TreeMap<>();
        
        for (String operation : operations) {
            String[] command = operation.split(" ");
            int number = Integer.parseInt(command[1]);
            
            switch (command[0]) {
                case "I":
                    // 숫자, 들어간 횟수
                    pq.put(number, pq.getOrDefault(number, 0) + 1);
                    break;
                    
                case "D":
                    if (pq.size() == 0) continue;
                    
                    if (number == 1) {
                        if (pq.get(pq.lastKey()) == 1) {
                            pq.remove(pq.lastKey());
                        } else {
                            pq.put(pq.lastKey(), pq.get(pq.lastKey()) - 1);
                        }
                    } else {
                        if (pq.get(pq.firstKey()) == 1) {
                            pq.remove(pq.firstKey());
                        } else {
                            pq.put(pq.firstKey(), pq.get(pq.firstKey()) - 1);
                        }
                    }
                    
                    break;
            }
        }
        
        int[] answers = new int[2];
            
        if (pq.size() > 0) {
            answers[0] = pq.lastKey();
            answers[1] = pq.firstKey();
        }

        return answers;
    }
}