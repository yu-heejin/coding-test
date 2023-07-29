//A: 고정비용, B: 가변비용, C: 노트북가격  -> 모두 음수가 될 수 없는 자연수
//가변비용은 노트북을 n대 생산하면 n을 곱해야한다
//총 수입(판매비용) > 총비용(A+B) 지점이 손익분기점
//A+B*n < C*n
//A+B*n-C*n < 0
//n(B-C) < -A
//n < -A / -(C-B)   ->  n < A / C-B

//총 비용과 총 수입이 같아지는 지점 + 1 == 손익분기점(자연수이기 때문)
//A+B*n = C*n
//A+B*n-C*n = 0
//n(B-C) = -A
//n = -A / -(C-B)   ->  n = A / C-B
//n + 1이 자연수여야만 손익분기점 존재!

//가변비용이 노트북 가격보다 크면 수익이 나지 않으므로 -1
//즉 분모가 음수면 손익분기점 없음
//모든 수가 자연수이기 때문에 분모로만 음수 판별가능
//또한, 분모가 0이여도 안됨

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] abc = new int[3];
        long n;
        
        for(int i=0; i<3; i++) {
            abc[i] = sc.nextInt();
        }
        
        //while((abc[0] + abc[1] * n) >= (abc[2] * n)) n++;
        //(A+B*n)이 (C*n)보다 크거나 같으면 판매량을 계속 증가
        //즉 총 비용보다 총 수입이 작으면 판매를 계속한다.
        //손익분기점이 없는 경우를 구할 수 없음 -> n을 한방에 구할 방법 필요
        
        if(abc[1] >= abc[2]) n = -1;
        else n = abc[0] / (abc[2] - abc[1]) + 1;
        
        System.out.println(n);
        sc.close();
    }
}