## **문제 설명**

0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 `numbers`가 매개변수로 주어집니다. `numbers`에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.

---

## 제한사항

- 1 ≤ `numbers`의 길이 ≤ 9
    - 0 ≤ `numbers`의 모든 원소 ≤ 9
    - `numbers`의 모든 원소는 서로 다릅니다.

---

## 입출력 예

| numbers | result |
| --- | --- |
| [1,2,3,4,6,7,8,0] | 14 |
| [5,8,4,0,6,7,9] | 6 |

---

## 입출력 예 설명

**입출력 예 #1**

- 5, 9가 `numbers`에 없으므로, 5 + 9 = 14를 return 해야 합니다.

**입출력 예 #2**

- 1, 2, 3이 `numbers`에 없으므로, 1 + 2 + 3 = 6을 return 해야 합니다.

## 풀이

- 컬렉션 공부 더 해야겠다..^^

## 코드

```java
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] numbers) {
        int sum = 0;
        List<Integer> numberCollections = Arrays.stream(numbers)
            .boxed()
            .collect(Collectors.toList());
        
        for (int i = 0; i <= 9; i++) {
            if (!numberCollections.contains(i)) {
                sum += i;
            }
        }
        
        return sum;
    }
}

테스트 1 〉	통과 (2.34ms, 74.4MB)
테스트 2 〉	통과 (1.87ms, 75MB)
테스트 3 〉	통과 (7.35ms, 77.8MB)
테스트 4 〉	통과 (2.46ms, 77.8MB)
테스트 5 〉	통과 (1.77ms, 79MB)
테스트 6 〉	통과 (1.63ms, 78.6MB)
테스트 7 〉	통과 (2.26ms, 81MB)
테스트 8 〉	통과 (3.41ms, 73.7MB)
테스트 9 〉	통과 (2.14ms, 72.9MB)
```
