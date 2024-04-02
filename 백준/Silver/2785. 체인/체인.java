import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        
        if (n == 2) System.out.println(1);
        else {
            List<Integer> chains = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                chains.add(Integer.parseInt(input[i]));
            }
            
            Collections.sort(chains);     // 오름차순 정렬
            int answer = 0;
            
            do {
                chains.set(0, chains.get(0) - 1);
                chains.remove(chains.size() - 1);
                
                // 만약 최소 고리 개수를 모두 연결한 경우 삭제
                if (chains.get(0) == 0) chains.remove(0);
                answer++;
            } while (chains.size() > 1);    // 최소 개수의 체인을 모두 사용할 필요는 없음
            
            System.out.println(answer);
        }
    }
}