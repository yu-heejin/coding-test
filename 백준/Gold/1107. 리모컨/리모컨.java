import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String n = br.readLine();    // 이동하려는 채널
        int m = Integer.parseInt(br.readLine());    // 고장난 버튼 번호
        
        if (n.equals("100")) {
            System.out.println(0);
        } else {
            boolean[] isBreak = new boolean[10];    // 0 ~ 9
        
            if (m > 0) {
                String[] input = br.readLine().split(" ");
                
                for (int i = 0; i < m; i++) {
                    int breakNumber = Integer.parseInt(input[i]);
                    isBreak[breakNumber] = true;
                }
            }
            
            // 1. 현재 위치에서 +, - 버튼을 누를 때의 횟수
            int pressPlmaCount = Math.abs(Integer.parseInt(n) - 100);
            
            int answer = Integer.MAX_VALUE;
            // 2. 최대한 근사치까지 누른 후 +, -로 조정
            for (int i = 0; i <= 999999; i++) {
                String number = String.valueOf(i);
                
                if (canMakeNumber(isBreak, number)) {
                    answer = Math.min(answer, number.length() + Math.abs(Integer.parseInt(number) - Integer.parseInt(n)));
                }
            }
            
            System.out.println(Math.min(answer, pressPlmaCount));
        }
    }
    
    private static boolean canMakeNumber(boolean[] isBreak, String number) {
        for (int j = 0; j < number.length(); j++) {
            int index = number.charAt(j) - '0';
            if (isBreak[index]) return false;
        }
        
        return true;
    }
}