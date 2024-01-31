import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] input;
        List<int[]> asks = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            
            int[] temp = new int[3];
            temp[0] = Integer.parseInt(input[0]);
            temp[1] = Integer.parseInt(input[1]);
            temp[2] = Integer.parseInt(input[2]);
            
            asks.add(temp);
        }
        
        // 정답이 될만한 수를 찾는다.
        boolean[] isAnswer = new boolean[999];
        
        for (int i = 123; i <= 987; i++) {
            String number = Integer.toString(i);
            // 0이 하나라도 있으면 pass
            if (number.charAt(0) == '0' || number.charAt(1) == '0' || number.charAt(2) == '0') continue;
            // 같은 수가 하나라도 있으면 pass
            if (number.charAt(0) == number.charAt(1) || number.charAt(0) == number.charAt(2) || number.charAt(1) == number.charAt(2)) continue;
            
            isAnswer[i] = true;
        }
        
        // 정답이 될만한 수를 비교한다.
        // 가능한 수는 123 ~ 987
        int count = 0;
        for (int i = 123; i <= 987; i++) {
            if (!isAnswer[i]) continue;
            
            String number = Integer.toString(i);
            
            // 입력받은 수와 자연수를 비교한다.
            for (int[] ask : asks) {
                int strike = 0;
                int ball = 0;
                String askNumber = Integer.toString(ask[0]);
                
                // 스트라이크 검사
                for (int j = 0; j <= 2; j++) {
                    if (number.charAt(j) == askNumber.charAt(j)) strike++;
                }
                
                // 볼 검사
                for (int j = 0; j <= 2; j++) {
                    char an = askNumber.charAt(j);
                    for (int k = 0; k <= 2; k++) {
                        if (j != k && an == number.charAt(k)) ball++;
                    }
                }

                if (strike == ask[1] && ball == ask[2]) isAnswer[i] = true;
                else {
                    isAnswer[i] = false;
                    break;
                }
            }

            if (isAnswer[i]) count++;
        }
        
        
        System.out.println(count);
    }
}