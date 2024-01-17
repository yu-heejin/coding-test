import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split("-");
        
        int result = 0;
        // 맨 처음 수는 더해준다.
        String[] temp = input[0].split("\\+");
        for (int j = 0; j < temp.length; j++) {
            result += Integer.parseInt(temp[j]);
        }
        
        for (int i = 1; i < input.length; i++) {
            temp = input[i].split("\\+");
            int minus = 0;
            for (int j = 0; j < temp.length; j++) {
                minus += Integer.parseInt(temp[j]);
            }
            result -= minus;
        }
        
        System.out.println(result);
    }
}