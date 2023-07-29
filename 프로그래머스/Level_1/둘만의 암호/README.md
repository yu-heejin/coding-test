## **문제 설명**

두 문자열 `s`와 `skip`, 그리고 자연수 `index`가 주어질 때, 다음 규칙에 따라 문자열을 만들려 합니다. 암호의 규칙은 다음과 같습니다.

- 문자열 `s`의 각 알파벳을 `index`만큼 뒤의 알파벳으로 바꿔줍니다.
- `index`만큼의 뒤의 알파벳이 `z`를 넘어갈 경우 다시 `a`로 돌아갑니다.
- `skip`에 있는 알파벳은 제외하고 건너뜁니다.

예를 들어 `s` = "aukks", `skip` = "wbqd", `index` = 5일 때, a에서 5만큼 뒤에 있는 알파벳은 f지만 [b, c, d, e, f]에서 'b'와 'd'는 `skip`에 포함되므로 세지 않습니다. 따라서 'b', 'd'를 제외하고 'a'에서 5만큼 뒤에 있는 알파벳은 [c, e, f, g, h] 순서에 의해 'h'가 됩니다. 나머지 "ukks" 또한 위 규칙대로 바꾸면 "appy"가 되며 결과는 "happy"가 됩니다.

두 문자열 `s`와 `skip`, 그리고 자연수 `index`가 매개변수로 주어질 때 위 규칙대로 `s`를 변환한 결과를 return하도록 solution 함수를 완성해주세요.

---

## 제한사항

- 5 ≤ `s`의 길이 ≤ 50
- 1 ≤ `skip`의 길이 ≤ 10
- `s`와 `skip`은 알파벳 소문자로만 이루어져 있습니다.
    - `skip`에 포함되는 알파벳은 `s`에 포함되지 않습니다.
- 1 ≤ `index` ≤ 20

---

## 입출력 예

| s | skip | index | result |
| --- | --- | --- | --- |
| "aukks" | "wbqd" | 5 | "happy" |

---

## 입출력 예 설명

입출력 예 #1

본문 내용과 일치합니다.

## 풀이

- 해당 문자에서 index만큼 떨어진 문자열을 찾되, 그 과정에서 skip에 포함되는 문자가 있다면 건너 뛸 것
- 알파벳 순환 연산이 필요하다. 단순히 빼기만 해서는 안될 듯

## 실패한 코드

```java
class Solution {
    private final int ALPHABET_START = 97;
    private final int ALPHABET_END = 122;
    
    public String solution(String s, String skip, int index) {     
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            int count = getJumpCount(index, s, skip, i);
            int totalJump = s.charAt(i) + index + count;
            String result = getResult(totalJump);
            
            answer += result;
        }
        
        return answer;
    }
    
    private int getJumpCount(int index, String s, String skip, int i) {
        int count = 0;
        
        for (int j = 1; j <= index; j++) {
            String temp = String.valueOf((char)(s.charAt(i) + j));
            
            if (skip.contains(temp)) {
                count++;
            }
        }
        
        return count;
    }
    
    private String getResult(int totalJump) {
        if (totalJump > ALPHABET_END) {
           totalJump -= 26;
        }
        
        String result = String.valueOf((char)(totalJump));
        return result;
    }
}
```

- 도저히 알파벳을 어떻게 빼야할지 몰라서 실패함..

## 최종 코드

```java
/* code reference from: https://day-log.tistory.com/29 */
class Solution {
    private final int ALPHABET_START = 97;
    private final int ALPHABET_END = 122;
    
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char result = getResult(s.charAt(i), skip, index);
            answer.append(String.valueOf(result));
        }
        
        return answer.toString();
    }
    
    private char getResult(char startAlphabet, String skip, int index) {
        for (int j = 1; j <= index; j++) {
            startAlphabet++;
            
            if (startAlphabet > ALPHABET_END) {
                startAlphabet = (char) ALPHABET_START;
            }
            
            while (skip.contains(String.valueOf(startAlphabet))) {
                startAlphabet++;
                if (startAlphabet > ALPHABET_END) {
                    startAlphabet = (char) ALPHABET_START;
                }
            }
        }
        
        return startAlphabet;
    }
}

테스트 1 〉	통과 (0.89ms, 73.4MB)
테스트 2 〉	통과 (0.17ms, 71.4MB)
테스트 3 〉	통과 (1.16ms, 78.5MB)
테스트 4 〉	통과 (0.32ms, 72.3MB)
테스트 5 〉	통과 (0.52ms, 73.9MB)
테스트 6 〉	통과 (0.31ms, 72MB)
테스트 7 〉	통과 (0.86ms, 76.6MB)
테스트 8 〉	통과 (0.41ms, 73.2MB)
테스트 9 〉	통과 (0.56ms, 77.5MB)
테스트 10 〉	통과 (0.37ms, 72.7MB)
테스트 11 〉	통과 (0.64ms, 75.5MB)
테스트 12 〉	통과 (0.18ms, 76.2MB)
테스트 13 〉	통과 (0.69ms, 80.9MB)
테스트 14 〉	통과 (0.12ms, 78.5MB)
테스트 15 〉	통과 (0.23ms, 73.3MB)
테스트 16 〉	통과 (0.44ms, 71MB)
테스트 17 〉	통과 (0.65ms, 74.3MB)
테스트 18 〉	통과 (0.79ms, 74.6MB)
테스트 19 〉	통과 (0.77ms, 75.5MB)
```

대체 왜 맞았지..? 삼중 반복문 쓰기 싫었는데….
