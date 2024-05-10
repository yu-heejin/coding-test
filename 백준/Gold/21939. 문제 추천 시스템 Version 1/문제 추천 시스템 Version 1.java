import java.io.*;
import java.util.*;

class Problem implements Comparable<Problem> {
    int number;
    int difficulty;
    
    public Problem(int number, int difficulty) {
        this.number = number;
        this.difficulty = difficulty;
    }
    
    @Override
    public int compareTo(Problem o) {
        return this.difficulty - o.difficulty;
    }
}

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());    // 문제의 개수
        
        // 오름차순 기준
        TreeSet<Problem> problems = new TreeSet<>((o1, o2) -> {
            if (o1.difficulty == o2.difficulty) {
                return o1.number - o2.number;
            }
            
            return o1.difficulty - o2.difficulty;
        });
        
        // 문제 번호와 난이도를 간리하기 위한 map
        Map<Integer, Integer> map = new HashMap<>();
        
        String[] input;
        
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            
            int number = Integer.parseInt(input[0]);
            int difficulty = Integer.parseInt(input[1]);
            
            problems.add(new Problem(number, difficulty));
            map.put(number, difficulty);
        }
        
        int m = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            
            switch (input[0]) {
                case "add":
                    int number = Integer.parseInt(input[1]);
                    int difficulty = Integer.parseInt(input[2]);
            
                    problems.add(new Problem(number, difficulty));
                    map.put(number, difficulty);
                    break;
                case "recommend":
                    int x = Integer.parseInt(input[1]);
                    
                    if (x == 1) {
                        // 가장 어려운 문제 출력
                        Problem dp = problems.last();
                        System.out.println(dp.number);
                    } else {
                        Problem ep = problems.first();
                        System.out.println(ep.number);
                    }
                    
                    break;
                case "solved":
                    // 문제 번호 삭제
                    number = Integer.parseInt(input[1]);
                    
                    Problem sp = new Problem(number, map.get(number));
                    problems.remove(sp);
                    
                    break;
            }
        }
    }
}