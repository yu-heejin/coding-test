## **문제 설명**

머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다. 조카는 아직 "aya", "ye", "woo", "ma" **네 가지 발음과 네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고 연속해서 같은 발음을 하는 것을 어려워합니다.** 문자열 배열 `babbling`이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.

---

## 제한사항

- 1 ≤ `babbling`의 길이 ≤ 100
- 1 ≤ `babbling[i]`의 길이 ≤ 30
- 문자열은 알파벳 소문자로만 이루어져 있습니다.

---

## 입출력 예

| babbling | result |
| --- | --- |
| ["aya", "yee", "u", "maa"] | 1 |
| ["ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"] | 2 |

---

## 입출력 예 설명

입출력 예 #1

- ["aya", "yee", "u", "maa"]에서 발음할 수 있는 것은 "aya"뿐입니다. 따라서 1을 return합니다.

입출력 예 #2

- ["ayaye", "uuuma", "yeye", "yemawoo", "ayaayaa"]에서 발음할 수 있는 것은 "aya" + "ye" = "ayaye", "ye" + "ma" + "woo" = "yemawoo"로 2개입니다. "yeye"는 같은 발음이 연속되므로 발음할 수 없습니다. 따라서 2를 return합니다.

---

## 유의사항

- 네 가지를 붙여 만들 수 있는 발음 이외에는 어떤 발음도 할 수 없는 것으로 규정합니다. 예를 들어 "woowo"는 "woo"는 발음할 수 있지만 "wo"를 발음할 수 없기 때문에 할 수 없는 발음입니다.

## 풀이

- **발음 4가지를 조합하나, 같은 발음을 연속해서 하는 것은 불가능**하다.
- **네 가지를 붙여 만들 수 있는 발음 이외에는 어떤 발음도 할 수 없는 것으로 규정**한다.
- 처음엔 Split으로 자르려고 했는데 구분자가 없어서 실패했다.
- 배열을 **숫자나 다른 문자로 치환하는 방법**이 있다!
    - 그 후 연속적이지 않은 치환 문자가 있는 경우에만 카운트가 가능하도록 설정한다.

## 코드

```java
class Solution {
    private String[] CAN_SAY_WORDS = { "aya", "ye", "woo", "ma" };
    private String[] CAN_SAY_WORDS_NUMBERS = { "1", "2", "3", "4" };
    
    public int solution(String[] babbling) {
        int count = 0;
        
        // 시간 복잡도 N^2 인데 더 좋은 방법은 없을까?
        for (int i = 0; i < babbling.length; i++) {
            for (int j = 0; j < CAN_SAY_WORDS.length; j++) {
                babbling[i] = babbling[i].replace(CAN_SAY_WORDS[j], CAN_SAY_WORDS_NUMBERS[j]);
            }
            
            if (babbling[i].matches("^[0-9]*$") && !isContinuous(babbling[i])) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isContinuous(String babbling) {
        if (babbling.contains("11") ||babbling.contains("22") || babbling.contains("33") || babbling.contains("44")) {
            return true;
        }
        
        return false;
    }
}

테스트 1 〉	통과 (0.30ms, 77.8MB)
테스트 2 〉	통과 (0.30ms, 72.9MB)
테스트 3 〉	통과 (0.26ms, 71.8MB)
테스트 4 〉	통과 (0.16ms, 75.8MB)
테스트 5 〉	통과 (0.22ms, 71.6MB)
테스트 6 〉	통과 (0.22ms, 79.3MB)
테스트 7 〉	통과 (0.18ms, 75.8MB)
테스트 8 〉	통과 (0.31ms, 74.4MB)
테스트 9 〉	통과 (0.32ms, 76.2MB)
테스트 10 〉	통과 (0.27ms, 66.7MB)
테스트 11 〉	통과 (0.37ms, 75.2MB)
테스트 12 〉	통과 (2.32ms, 75.5MB)
테스트 13 〉	통과 (2.27ms, 73.1MB)
테스트 14 〉	통과 (3.02ms, 71.8MB)
테스트 15 〉	통과 (2.07ms, 77.7MB)
테스트 16 〉	통과 (1.93ms, 78.1MB)
테스트 17 〉	통과 (2.20ms, 75.5MB)
테스트 18 〉	통과 (3.60ms, 77.4MB)
테스트 19 〉	통과 (0.87ms, 73.9MB)
테스트 20 〉	통과 (1.36ms, 69.8MB)
```
