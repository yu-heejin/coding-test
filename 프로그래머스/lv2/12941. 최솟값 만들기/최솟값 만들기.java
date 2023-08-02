import java.util.*;

class Solution
{
    // 배열에서 뽑힌 숫자는 다시 뽑을 수 없다.
    public int solution(int []A, int []B)
    {
        int sum = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int bIndex = B.length - 1;
        
        for (int i = 0; i < A.length; i++) {
            sum += A[i] * B[bIndex];
            bIndex--;
        }
        
        return sum;
    }
}