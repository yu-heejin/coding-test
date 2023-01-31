## **문제 설명**

정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.

---

## 제한사항

- numbers의 길이는 2 이상 100 이하입니다.
    - numbers의 모든 수는 0 이상 100 이하입니다.

---

## 입출력 예

| numbers | result |
| --- | --- |
| [2,1,3,4,1] | [2,3,4,5,6,7] |
| [5,0,2,7] | [2,5,7,9,12] |

---

## 입출력 예 설명

**입출력 예 #1**

- 2 = 1 + 1 입니다. (1이 numbers에 두 개 있습니다.)
- 3 = 2 + 1 입니다.
- 4 = 1 + 3 입니다.
- 5 = 1 + 4 = 2 + 3 입니다.
- 6 = 2 + 4 입니다.
- 7 = 3 + 4 입니다.
- 따라서 `[2,3,4,5,6,7]` 을 return 해야 합니다.

**입출력 예 #2**

- 2 = 0 + 2 입니다.
- 5 = 5 + 0 입니다.
- 7 = 0 + 7 = 5 + 2 입니다.
- 9 = 2 + 7 입니다.
- 12 = 5 + 7 입니다.
- 따라서 `[2,5,7,9,12]` 를 return 해야 합니다.

## 풀이

- 조합 알고리즘, Set 사용

## 코드

```java
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

class Solution {
    private final int PICK_NUMBER = 2;
    private Set<Integer> results;
    private int[] bucket;
    
    public int[] solution(int[] numbers) {
        results = new TreeSet<>();
        bucket = new int[PICK_NUMBER];
        
        combination(numbers, numbers.length, PICK_NUMBER);
        
        return getAnswer();
    }
    
    private void combination(int[] numbers, int n, int r) {
        if (r == 0) {
            results.add(numbers[bucket[0]] + numbers[bucket[1]]);
            return;
        }
        
        int lastIndex = bucket.length - r - 1;
        int smallest = getSmallest(r, lastIndex);
        
        for (int i = smallest; i < n; i++) {
            bucket[lastIndex + 1] = i;
            combination(numbers, n, r - 1);
        }
    }
    
    private int getSmallest(int r, int lastIndex) {
        if (bucket.length > r) {
            return bucket[lastIndex] + 1;
        }
        
        return 0;
    }
    
    private int[] getAnswer() {
        int[] answers = new int[results.size()];
        Iterator<Integer> iterator = results.iterator();
        int answerIndex = 0;
        
        while (iterator.hasNext()) {
            answers[answerIndex] = iterator.next();
            answerIndex++;
        }
        
        return answers;
    }
}

테스트 1 〉	통과 (0.48ms, 72.2MB)
테스트 2 〉	통과 (0.49ms, 74.5MB)
테스트 3 〉	통과 (0.52ms, 73.2MB)
테스트 4 〉	통과 (0.76ms, 84.5MB)
테스트 5 〉	통과 (0.61ms, 73MB)
테스트 6 〉	통과 (0.98ms, 78MB)
테스트 7 〉	통과 (3.06ms, 71.6MB)
테스트 8 〉	통과 (2.68ms, 75.5MB)
테스트 9 〉	통과 (2.17ms, 84.2MB)
```
