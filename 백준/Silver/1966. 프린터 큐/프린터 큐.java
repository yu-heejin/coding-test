import java.util.*;
import java.io.*;

class Task {
    int priority;
    int firstOrder;
    
    public Task(int priority, int firstOrder) {
        this.priority = priority;
        this.firstOrder = firstOrder;
    }
}

public class Main {
    
    static String[] input;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testCase = Integer.parseInt(br.readLine());
        String[] input;
        
        for (int i = 0; i < testCase; i++) {
            input = br.readLine().split(" ");
            
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);   // 내가 알고자 하는 문서의 위치
            
            Queue<Task> tasks = new LinkedList<>();
            input = br.readLine().split(" ");
            
            for (int j = 0; j < n; j++) {
                tasks.add(new Task(Integer.parseInt(input[j]), j));
            }
            
            int count = 0;
            while (!tasks.isEmpty()) {
                Task now = tasks.poll();
                boolean isMax = true;
                
                for (Task task : tasks) {
                    if (task.priority > now.priority) {
                        isMax = false;
                        break;
                    }
                }

                // 우선순위가 더 높은 테스크가 존재하는 경우
                // 테스크가 출력될 때만 카운트를 증가시킨다.
                if (!isMax) {
                    // 현재 순위를 맨 뒤로 보내고, 나머지 등수를 하나씩 줄여준다.
                    // 큐에 있는 것 자체가 등수기 때문에 별도로 등수를 저장할 필요는 없다.
                    tasks.add(now);
                } else if (now.firstOrder == m) {
                    count++;
                    // 내가 찾는 테스크인 경우
                    break;
                } else {
                    count++;
                }
            }
            
            System.out.println(count);
        }
    }
}