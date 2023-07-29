import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] arr = new int[9];
        int max = 0;
        int maxIndex = 0;
        
        for(int i=0; i<9; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            
            if(max <= arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        
        bw.write(max + "\n" + (maxIndex+1));
       // bw.write(maxIndex);  -> 이렇게 하면 출력 결과가 .으로 나온다
        
        bf.close();
        bw.flush();
        bw.close();
    }
}