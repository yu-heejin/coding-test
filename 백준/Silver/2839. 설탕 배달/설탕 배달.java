import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int answer = 0;
        
        if (n % 5 == 0) {
            // n이 5로 나누어 떨어진다면 최대한 5로 나누는 것이 좋다.
            System.out.println(n / 5);
        } else {
            // n이 5와 3의 조합으로 나누어 떨어지는 경우
            // n이 3으로 나누어 떨어지는 경우
            // 5와 3으로 나누어지지 않는 경우
            
            // 5로 나누어 떨어지지 않는 경우 3키로 설탕 봉지를 사용한다.
            
            while (n >= 0) {
                n -= 3;
                answer++;
                
                if (n % 5 == 0) {
                    answer += (n / 5);
                    System.out.println(answer);
                    return;
                }
            }
            
            System.out.println(n != 0 ? -1 : answer);
        }
    }
}