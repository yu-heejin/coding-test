import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        List<Integer> sortA = new ArrayList<>();
        List<Integer> sortB = new ArrayList<>();
        
        // primitive type은 내림차순이 불가능하다.
        for (int i = 0; i < A.length; i++) {
            sortA.add(A[i]);
            sortB.add(B[i]);
        }
        
        Collections.sort(sortA, Collections.reverseOrder());
        Collections.sort(sortB, Collections.reverseOrder());
        
        // A의 가장 높은 숫자는 B의 높은 숫자로 커버한다.
        int answer = 0;
        int bIndex = 0;
        for (int i = 0; i < A.length; i++) {
            if (sortA.get(i) < sortB.get(bIndex)) {
                answer++;
                bIndex++;
            }
        }
        
        return answer;
    }
}