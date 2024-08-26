import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    
    if (N % 5 == 0) {
        // 설탕의 무게가 5의 배수라면 5kg 봉지를 최대한 가져가는 것이 좋음
        System.out.println(N / 5);
    } else {
        // 5로 나누어 떨어지지 않는 경우 - 최대한의 5와 최소한의 3을 사용
        
        int answer = 0;
        while (N > 0) {
            // 미리 3을 빼는 이유는, 5의 배수로 만들기 위함
            N -= 3;
            answer++;
            
            // 5의 배수가 되는 경우, 최대한의 5키로 봉지를 사용
            if (N % 5 == 0) {
                answer += N / 5;
                break;
            }
            
            // 만약 정확하게 만들 수 없는 경우 -1
            if (N < 3) {
                answer = -1;
                break;
            }
        }
        
        System.out.println(answer);
    }
  }
}