import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        List<Integer> numbers = new ArrayList<>();
        
        for (String operation : operations) {
            String[] command = operation.split(" ");
            
            switch (command[0]) {
                case "I":
                    numbers.add(Integer.parseInt(command[1]));
                    Collections.sort(numbers);
                    break;
                case "D":
                    if (numbers.size() == 0) continue;
                    
                    if (command[1].equals("1")) {
                        int maxIndex = numbers.size() - 1;
                        numbers.remove(maxIndex);
                    } else {
                        numbers.remove(0);
                    }
                    break;
            }
        }
        
        int[] answer = new int[2];
        
        if (numbers.size() == 1) {
            answer[0] = numbers.get(0);
            answer[1] = answer[0];
        } else if (numbers.size() >= 2) {
            answer[0] = numbers.get(numbers.size() - 1);
            answer[1] = numbers.get(0);
        }
        
        return answer;
    }
}