import java.util.*;

class Solution {
    private int max = -1;
    
    public String solution(String number, int k) {
        Stack<Integer> s = new Stack<>();
        
        for (int i = 0; i < number.length(); i++) {
            int num = number.charAt(i) - '0';
            
            // 더 이상 뺄 수 없으면 넣는다.
            if (s.size() == 0 || k == 0) {
                s.push(num);
            } else {
                // 스택 수보다 넣을 수가 더 크면 다 빼준다.
                while (s.size() > 0 && s.peek() < num && k > 0) {
                    s.pop();
                    k--;
                }
                s.push(num);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!s.isEmpty()) {
            // 반복문이 끝났는데 k가 남아있다면, 스택에 있는 숫자들이 모두 크다는 의미이므로
            // 맨 끝 숫자들을 빼주면 가장 작은 수들을 뺄 수 있다.
            if (k > 0 && s.size() >= k) {
                s.pop();
                k--;
                continue;
            }
            sb.append(s.pop());
        }
        
        return sb.reverse().toString();
    }
    
    // nCr - 재귀를 너무 많이해서 오류 발생
//     private void combination(int n, int r, int[] bucket, String number) {
//         if (r == 0) {
//             StringBuilder sb = new StringBuilder();
            
//             Arrays.sort(bucket);
//             int bucketIndex = 0;
            
//             for (int i = 0; i < number.length(); i++) {
//                 if (bucketIndex < bucket.length && bucket[bucketIndex] == i) {
//                     bucketIndex++;
//                     continue;
//                 }
                
//                 sb.append(number.charAt(i));
//             }
            
//             if (sb.toString().charAt(0) == '0') return;
            
//             int result = Integer.parseInt(sb.toString());
//             max = Math.max(max, result);
            
//             return;
//         }
        
//         int smallest = 0;
//         int lastIndex = bucket.length - r - 1;
        
//         if (r < bucket.length) {
//             // 이미 한 번 뽑은 경우
//             smallest = bucket[lastIndex] + 1;
//         }
        
//         for (int i = smallest; i < n; i++) {
//             bucket[lastIndex + 1] = i;
//             combination(n, r - 1, bucket, number);
//         }
//     }
}