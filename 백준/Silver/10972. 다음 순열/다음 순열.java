import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];

        //사전 순으로 가장 앞에 오는 순열은 오름차순, 마지막은 내림차순
        //즉 앞에 있는 숫자가 크면 클수록 뒤로 가게 됨
        //앞에 수를 보고 이거보다 더 큰게 있으면 바꿔준다. 다만 큰 수 중에서 가장 작아야 함
        //끝에서부터 바꿔주는게 좋음. 사전순이니까!
        //C++의 next_permutation 구현
        
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int j = -1;
        //1. 뒤쪽부터 탐색하여 꼭대기를 찾아라 (오름차순이 끊기는 지점)
        for(int i=n-1; i>=1; i--) {
            if(arr[i] > arr[i-1]) {
                j = i-1;
                break;
            }
        }
        
        if(j == -1) System.out.println(-1);
        else {
            //2. 꼭대기 위치와 교환할 큰 값을 찾아야함(큰 값 중 가장 작은 값) + 두 값을 교환한다
            //뒤쪽 영역은 이미 내림차순이기 때문에 가장 끝 값이 큰 값중 가장 작은값이 됨
            for(int i=n-1; i>=j+1; i--) {
                if(arr[j] < arr[i]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                    break;
                }
            }
            
            //3. 뒤를 왼쪽부터!!! 오름차순으로 정렬한다.
            for(int i=j+1; i<n; i++) {
                for(int k=i+1; k<n; k++) {
                    if(arr[i] > arr[k]) {
                        int tmp = arr[i];
                        arr[i] = arr[k];
                        arr[k] = tmp;
                    }
                }
            }
            
            for(int i=0; i<n; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
