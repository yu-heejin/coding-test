import java.util.Arrays;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        long[] sumArr = new long[1000001];  //0 부분은 비워놓고 1~1000000
        Arrays.fill(sumArr, 1);
        
        for(int i=2; i<1000001; i++) {  //2~100000
            for(int j=1; i*j<1000001; j++) {   //index 값이 1000000일 때까지
                sumArr[j*i] += i;
                /*
                    1*2(2) += 2    1*3(3) += 3   1*4(4) += 4
                    2*2(4) += 2    2*3(6) += 3   2*4(8) += 4
                    3*2(6) += 2    3*3(9) += 3   3*4(12) += 4
                    4*2(8) += 2    4*3(12) += 3  4*4(16) += 4
                    
                    즉, 각 배수에는 배수의 약수가 들어가게 됨
                    일일이 하나하나 구하게 되면 시간 초과가 발생
                    따라서 미리 구할 수 있는 dp (동적 프로그래밍) 방법을 이용한다.
                    
                    2*j = 100000    -> j = 100000/2
                    3*j = 100000    -> j = 100000/3
                    4*j = 100000    -> j = 100000/4
                    -> 총 시간 복잡도 O(n/k)
                */
            }
            sumArr[i] = sumArr[i-1] + sumArr[i];
            //DP에 있던 값을 더해준다.
            /*
              1   ->  1
              1,2  ->  3
              1,3  ->  4
              1,2,4  -> 7
              
              2 = 1+2
              3 = 4+3
            */
        }
        
        int a = Integer.parseInt(br.readLine());   //테스트 케이스 개수 입력
        while(a-- > 0) {
            bw.write(sumArr[Integer.parseInt(br.readLine())] + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}