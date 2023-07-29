import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        //에라토네스의 체를 이용
        //예를 들어, 어떤 수가 들어왔으면, 어떤 수의 배수는 소수라고 하지않음
        boolean[] arr = new boolean[1000001];
        Arrays.fill(arr, true);   //초기 값을 일단 소수라고 판단
        
        arr[1] = false;  //1은 소수가 아니기 때문에 처리를 따로 해줘야함
        
        //배수의 시작은 4부터임. 숫자 3이하까지는 1을 제외하고 소수에 해당하기 때문
        //2 -> 4, 6, 8, 10 ...
        //3 -> 6, 9, 12, 15 ...
        for(int i=2; i<=b; i++) {
            for(int j=i*2; j<=b; j+=i) {
                arr[j] = false;   //소수가 아니다
                /*
                    i=2
                    j=4 -> 4, 6, 8, 10...
                    -> i의 배수를 미리 지움
                */
            }
        }
        
        for(int i=a; i<=b; i++) {
            if(arr[i]) {   //소수라면 출력
                bw.write(i + "\n");
            }
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}
