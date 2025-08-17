import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        // N을 8번까지 사용한 경우의 수
        List<Set<Integer>> numbers = new ArrayList<>();
        
        // 배열 초기화
        for (int i = 0; i <= 8; i++) {
            numbers.add(new HashSet<Integer>());
        }
        
        numbers.get(1).add(N);
        
        // 8번까지 사용 가능하다
        for (int i = 2; i <= 8; i++) {
            // 반복되는 수가 들어간다.
            int num = N;
            for (int j = 1; j < i; j++) {
                num = num * 10 + N;
            }
            numbers.get(i).add(num);
            
            // 기존 조합 + 새로운 연산 추가
            // https://record-developer.tistory.com/145
            for (int j = 1; j < i; j++) {
                /**
                    i j  list
                    2 1  1 1
                    3 1  1 2
                    3 2  2 1
                    4 1  1 3
                    4 2  2 2
                    4 3  3 1
                    -> 역순으로 돌면서 모든 경우의 수를 사칙연산한다.
                **/
                Set<Integer> set1 = numbers.get(j);
                Set<Integer> set2 = numbers.get(i - j);
                
                for (int a : set1) {
                    for (int b : set2) {
                        numbers.get(i).add(a + b);
                        numbers.get(i).add(a - b);
                        numbers.get(i).add(a * b);
                        if (b != 0) numbers.get(i).add(a / b);
                    }
                }
            }

            if (numbers.get(i).contains(number)) {
                return i;
            }
        }

        return -1;
    }
}