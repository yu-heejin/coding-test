import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 일정의 개수 n
        int n = Integer.parseInt(br.readLine());
        
        String[] input;
        int[] dateCount = new int[367];
        int maxDate = -1;
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            
            if (maxDate < e) maxDate = e;
            
            for (int j = s; j <= e; j++) dateCount[j]++;
        }
        
        int answer = 0;
        int width = 0;
        int maxDateCount = -1;
        for (int i = 1; i <= maxDate + 1; i++) {
            if (dateCount[i] > 0) {
                width++;
                if (dateCount[i] > maxDateCount) maxDateCount = dateCount[i];
            } else {
                answer += (width * maxDateCount);
                width = 0;
                maxDateCount = -1;
            }
        }
        
        System.out.println(answer);
    }
}