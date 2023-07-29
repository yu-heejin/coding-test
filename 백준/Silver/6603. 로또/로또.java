import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

//나중에 다시 풀어볼 문제
//dfs 활용 문제
public class Main {
    
    static void pick(int start, int dep, int[] arr, int[] result, boolean[] visit, int k) {
        if(dep == 6){
            for(int i=0;i<6;i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        
        for(int i=start; i<k; i++){
            if(visit[i] != true) {
                visit[i] = true;
                result[dep] = arr[i];
                pick(i, dep+1, arr, result, visit, k);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        do {
            int k = Integer.parseInt(st.nextToken());
            if(k == 0) break;
            
            int[] arr = new int[k];
            int[] result = new int[6];
            boolean[] visit = new boolean[k];
            
            for(int i=0; i<k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                //System.out.println(arr[i]);
            }
            
            pick(0, 0, arr, result, visit, k);
            System.out.println();
            
            st = new StringTokenizer(br.readLine(), " ");
            
        } while(st.hasMoreTokens());
        
        br.close();
        bw.flush();
        bw.close();
    }
}