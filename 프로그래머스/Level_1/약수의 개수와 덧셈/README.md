## **문제 설명**

두 정수 `left`와 `right`가 매개변수로 주어집니다. `left`부터 `right`까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.

---

## 제한사항

- 1 ≤ `left` ≤ `right` ≤ 1,000

---

## 입출력 예

| left | right | result |
| --- | --- | --- |
| 13 | 17 | 43 |
| 24 | 27 | 52 |

---

## 입출력 예 설명

**입출력 예 #1**

- 다음 표는 13부터 17까지의 수들의 약수를 모두 나타낸 것입니다.

| 수 | 약수 | 약수의 개수 |
| --- | --- | --- |
| 13 | 1, 13 | 2 |
| 14 | 1, 2, 7, 14 | 4 |
| 15 | 1, 3, 5, 15 | 4 |
| 16 | 1, 2, 4, 8, 16 | 5 |
| 17 | 1, 17 | 2 |
- 따라서, 13 + 14 + 15 - 16 + 17 = 43을 return 해야 합니다.

**입출력 예 #2**

- 다음 표는 24부터 27까지의 수들의 약수를 모두 나타낸 것입니다.

| 수 | 약수 | 약수의 개수 |
| --- | --- | --- |
| 24 | 1, 2, 3, 4, 6, 8, 12, 24 | 8 |
| 25 | 1, 5, 25 | 3 |
| 26 | 1, 2, 13, 26 | 4 |
| 27 | 1, 3, 9, 27 | 4 |
- 따라서, 24 - 25 + 26 + 27 = 52를 return 해야 합니다.

## 풀이

- 개선된 약수 알고리즘 사용

## 코드

```java
class Solution {
    public int solution(int left, int right) {
        int sum = 0;
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
            sum = getNumberOfDivisors(i);
            answer = calculateAnswer(sum, i, answer);
            sum = 0;
        }
        
        return answer;
    }
    
    private int getNumberOfDivisors(int i) {
        int sum = 0;
        
        for (int j = 1; j <= Math.sqrt(i); j++) {
            sum = getSum(sum, i, j);
        }
        
        return sum;
    }
    
    private int getSum(int sum, int i, int j) {
        if ((i % j == 0) && (i / j != j)) {   // 나눈 수가 제곱근이 아니면 한번 더 증가
            sum += 2;
            return sum;
        } 
        
        if (i % j == 0) {
            sum++;
        }
        
        return sum;
    }
    
    private int calculateAnswer(int sum, int i, int answer) {
        if (sum % 2 == 0) {
            answer += i;
            return answer;
        } 
        
        answer -= i;
        return answer;
    }
}

테스트 1 〉	통과 (0.97ms, 80.6MB)
테스트 2 〉	통과 (0.42ms, 72.2MB)
테스트 3 〉	통과 (0.94ms, 77.3MB)
테스트 4 〉	통과 (0.21ms, 74MB)
테스트 5 〉	통과 (1.15ms, 65.4MB)
테스트 6 〉	통과 (0.21ms, 73MB)
테스트 7 〉	통과 (0.31ms, 76.5MB)
```
