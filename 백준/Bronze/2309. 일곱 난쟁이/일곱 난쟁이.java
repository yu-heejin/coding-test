import java.util.Scanner;
import java.util.Arrays;

// 1. 일단 7명으로 맞춰야함 -> 아홉명의 난쟁이의 키 중 특정 두명의 키를 빼면 된다
// 2. 오름 차순으로 출력

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heights = new int[9];
        int[] trueHeights = new int[7];
        int sum = 0;
        int idx1 = -1, idx2 = -2;
        int k = 0, l = 0;
        boolean isResult = false;
        
        // 9명의 키를 받아온다.
        for(int i=0; i<heights.length; i++) {
            heights[i] = sc.nextInt();
            sum += heights[i];
        }
        
        // 특정 두 난쟁이의 키를 빼고, 그 인덱스를 기억한다.
        for(int i=0; i<heights.length; i++) {
            for(int j=i+1; j<heights.length; j++) {
                if((sum - (heights[i] + heights[j])) == 100) {
                    idx1 = i;
                    idx2 = j;
                    isResult = true;
                    break;
                }
            }
            
            if(isResult) break;
        }
        
        //System.out.println("idx1: " + idx1 + ", idx2: " + idx2);
        //System.out.println("idx1: " + heights[idx1] + ", idx2: " + heights[idx2]);
        
        // 진짜 키를 모아옴
        while(l != 7) {
            if(k != idx1 && k != idx2) {     // ||이 아니라 &&여야 답이 나옴
                //System.out.println("insert value: " + heights[k] + ", insert index: " + k);
                trueHeights[l] = heights[k];
                l++;
            }
            k++;
        }
        
        // 오름차순
        Arrays.sort(trueHeights);
        
        for(int i=0; i<trueHeights.length; i++) {
            System.out.println(trueHeights[i]);
        }
        
        sc.close();
    }
}