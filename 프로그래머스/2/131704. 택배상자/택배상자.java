import java.util.*;

class Solution {
    
    public int solution(int[] order) {
        Queue<Integer> boxes = new LinkedList<>();
        Stack<Integer> subContainer = new Stack<>();
        List<Integer> result = new ArrayList<>();
        
        // 컨테이너 벨트에 박스 넣기
        for (int i = 1; i <= order.length; i++) {
            boxes.add(i);
        }
        
        // 벨트에서 하나씩 꺼내서 비교한다.
        int orderIndex = 0;
        
        while (!boxes.isEmpty()) {
            if (order[orderIndex] == boxes.peek()) {
                result.add(boxes.poll());
                orderIndex++;
            } else {
                // 보조가 비어있는 경우 보조에 넣는다.
                if (subContainer.isEmpty()) {
                    subContainer.add(boxes.poll());
                } else {
                    // 보조에 있는 것이 맞는 경우 result에 넣어준다.
                    if (order[orderIndex] == subContainer.peek()) {
                        result.add(subContainer.pop());
                        orderIndex++;
                    } else {
                        // 보조에도 안 맞는 경우 보조에 넣어준다.
                        subContainer.add(boxes.poll());
                    }
                }
            }
        }
        
        // 보조 벨트에 상자가 남은 경우
        while (!subContainer.isEmpty()) {
            if (order[orderIndex] == subContainer.peek()) {
                result.add(subContainer.pop());
                orderIndex++;
            } else {
                // 없는 경우 더 이상 꺼낼 수 없으므로 break
                break;
            }
        }
        
        return result.size();
    }
}