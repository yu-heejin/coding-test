## **문제 설명**

![https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/d31cb063-4025-4412-8cbc-6ac6909cf93e/img1.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/d31cb063-4025-4412-8cbc-6ac6909cf93e/img1.png)

네오와 프로도가 숫자놀이를 하고 있습니다. 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.

- 1478 → "one4seveneight"
- 234567 → "23four5six7"
- 10203 → "1zerotwozero3"

이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 `s`가 매개변수로 주어집니다. `s`가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.

참고로 각 숫자에 대응되는 영단어는 다음 표와 같습니다.

| 숫자 | 영단어 |
| --- | --- |
| 0 | zero |
| 1 | one |
| 2 | two |
| 3 | three |
| 4 | four |
| 5 | five |
| 6 | six |
| 7 | seven |
| 8 | eight |
| 9 | nine |

---

## 제한사항

- 1 ≤ `s`의 길이 ≤ 50
- `s`가 "zero" 또는 "0"으로 시작하는 경우는 주어지지 않습니다.
- return 값이 1 이상 2,000,000,000 이하의 정수가 되는 올바른 입력만 `s`로 주어집니다.

---

## 입출력 예

| s | result |
| --- | --- |
| "one4seveneight" | 1478 |
| "23four5six7" | 234567 |
| "2three45sixseven" | 234567 |
| "123" | 123 |

---

## 입출력 예 설명

**입출력 예 #1**

- 문제 예시와 같습니다.

**입출력 예 #2**

- 문제 예시와 같습니다.

**입출력 예 #3**

- "three"는 3, "six"는 6, "seven"은 7에 대응되기 때문에 정답은 입출력 예 #2와 같은 234567이 됩니다.
- 입출력 예 #2와 #3과 같이 같은 정답을 가리키는 문자열이 여러 가지가 나올 수 있습니다.

**입출력 예 #4**

- `s`에는 영단어로 바뀐 부분이 없습니다.

---

## 제한시간 안내

- 정확성 테스트 : 10초

## 풀이

- 영어로 바뀌든 안 바뀌든 들어오는 값을 모두 숫자로 바꿔야한다.
- replace를 사용하면 반복문 10번안에 쉽게 바꿀 수 있다!

## 코드

```java
import java.util.HashMap;

class Solution {
    private final int MIN_NUMBER = 0;
    private final int MAX_NUMBER = 9;
    private HashMap<Integer, String> numberAndWord;
    
    public int solution(String s) {
        addNumberAndWord();

        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            String numberForChange = i + "";
            s = s.replace(numberAndWord.get(i), numberForChange);
        }
        
        return Integer.parseInt(s);
    }
    
    private void addNumberAndWord() {
        numberAndWord = new HashMap<>();
        
        numberAndWord.put(0, "zero");
        numberAndWord.put(1, "one");
        numberAndWord.put(2, "two");
        numberAndWord.put(3, "three");
        numberAndWord.put(4, "four");
        numberAndWord.put(5, "five");
        numberAndWord.put(6, "six");
        numberAndWord.put(7, "seven");
        numberAndWord.put(8, "eight");
        numberAndWord.put(9, "nine");
    }
}

테스트 1 〉	통과 (6.64ms, 74.3MB)
테스트 2 〉	통과 (6.15ms, 74.3MB)
테스트 3 〉	통과 (6.33ms, 78.1MB)
테스트 4 〉	통과 (5.90ms, 72.2MB)
테스트 5 〉	통과 (6.55ms, 77.3MB)
테스트 6 〉	통과 (6.09ms, 73.5MB)
테스트 7 〉	통과 (6.31ms, 67.6MB)
테스트 8 〉	통과 (6.11ms, 75.3MB)
테스트 9 〉	통과 (5.87ms, 79.1MB)
테스트 10 〉	통과 (6.51ms, 74.7MB)

채점 결과
정확성: 100.0
합계: 100.0 / 100.0
```
