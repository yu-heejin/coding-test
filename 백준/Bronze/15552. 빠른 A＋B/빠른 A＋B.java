import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int x = Integer.parseInt(br.readLine());
        
        for(int i=0; i<x; i++) {
         //   int a = Integer.parseInt(br.readLine());
        //    int b = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            //BufferedReader는 엔터만 경계로 인식하기 때문에 토큰단위로 끊어야한다.
            bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n");
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}