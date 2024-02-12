import java.io.*;

public class Main {
    
    static long[][] numbers;
    static int n;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        if (n == 1) {
            System.out.println(9);
        } else {
            numbers = new long[n + 1][10];
            
            // 첫번째 자리수는 1로 초기화 - 맨 왼쪽 수이므로 경우의 수가 하나
            for (int i = 1; i <= 9; i++) {
                numbers[1][i] = 1;
            }
            
            // 두번째 자리수부터 계산
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < 10; j++) {
                    // 0인 경우 이전까지 1밖에 못옴
                    if (j == 0) numbers[i][j] = numbers[i - 1][1] % 1000000000;
                    // 9인 경우 이전까지 8밖에 못옴
                    else if (j == 9) numbers[i][j] = numbers[i - 1][8] % 1000000000;
                    // 나머지 경우 +- 가 가능하다
                    else numbers[i][j] = (numbers[i - 1][j - 1] + numbers[i - 1][j + 1]) % 1000000000;
                }
            }
            
            // 마지막 자리수의 경우의 수를 더하면 총 경우의 수를 구할 수 있다.
            long sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += numbers[n][i];
            }
            
            System.out.println(sum % 1000000000);
        }
    }
}