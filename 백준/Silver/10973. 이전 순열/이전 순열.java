import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        //이번엔 사전순으로 바로 이전에 오는 순열을 구하면 된다!
        //앞에 있는 숫자가 작으면 작을수록 앞으로 감
        //작은 수 중에서 가장 큰 수를 찾아야함
        //사전 순으로 가장 앞서는 순열은 오름차순으로 이루어진 순열,
        //가장 마지막에 오는 순열은 내림차순으로 이루어진 순열
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int j = -1;
        //1. 뒤에서 부터 탐색해서 내림차순이 끊기는 지점 탐색
        for(int i=n-1; i>=1; i--) {
            if(arr[i] < arr[i-1]) {
                j = i-1;
                break;
            }
        }
        
        if(j == -1) System.out.println(-1);   //끊기는 지점이 없으면 오름차순으로 정렬된 상태
        else {
            //2. 끊긴 위치와 교환할 작은 값 탐색(작은 값 중 가장 큰 값) + 두 값을 교환
            //뒤쪽 영역은 이미 내림차순이기 때문에 뒷쪽이 작은값 중 가장 큰 값이 된다
            for(int i=n-1; i>=j+1; i--) {
                if(arr[j] > arr[i]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                    break;
                }
            }
            
            //3. 뒤쪽을 왼쪽부터 내림차순으로 정렬해준다.
            for(int i=j+1; i<n; i++) {
                for(int k=i+1; k<n; k++) {
                    if(arr[i] < arr[k]) {
                        int tmp = arr[i];
                        arr[i] = arr[k];
                        arr[k] = tmp;
                    }
                }
            }
            
            for(int i=0; i<n; i++) {
                bw.write(arr[i] + " ");
            }
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}