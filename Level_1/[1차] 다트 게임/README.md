## **문제 설명**

# **다트 게임**

카카오톡에 뜬 네 번째 별! 심심할 땐? 카카오톡 게임별~

![http://t1.kakaocdn.net/welcome2018/gamestar.png](http://t1.kakaocdn.net/welcome2018/gamestar.png)

카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다. 다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임으로, 모두가 간단히 즐길 수 있다.

갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다. 다트 게임의 점수 계산 로직은 아래와 같다.

1. 다트 게임은 총 3번의 기회로 구성된다.
2. 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
3. 점수와 함께 Single(`S`), Double(`D`), Triple(`T`) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수 , 점수 , 점수 )으로 계산된다.
    
    1
    
    2
    
    3
    
4. 옵션으로 스타상(``) , 아차상(`#`)이 존재하며 스타상(``) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(`#`) 당첨 시 해당 점수는 마이너스된다.
5. 스타상(``)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(``)의 점수만 2배가 된다. (예제 4번 참고)
6. 스타상(``)의 효과는 다른 스타상(``)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(``) 점수는 4배가 된다. (예제 4번 참고)
7. 스타상(``)의 효과는 아차상(`#`)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(`#`)의 점수는 -2배가 된다. (예제 5번 참고)
8. Single(`S`), Double(`D`), Triple(`T`)은 점수마다 하나씩 존재한다.
9. 스타상(``), 아차상(`#`)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.

0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.

## **입력 형식**

"점수|보너스|[옵션]"으로 이루어진 문자열 3세트.예) `1S2D*3T`

- 점수는 0에서 10 사이의 정수이다.
- 보너스는 S, D, T 중 하나이다.
- 옵선은 *이나 # 중 하나이며, 없을 수도 있다.

## **출력 형식**

3번의 기회에서 얻은 점수 합계에 해당하는 정수값을 출력한다.예) 37

## **입출력 예제**

| 예제 | dartResult | answer | 설명 |
| --- | --- | --- | --- |
| 1 | 1S2D*3T | 37 | 11 * 2 + 22 * 2 + 33 |
| 2 | 1D2S#10S | 9 | 12 + 21 * (-1) + 101 |
| 3 | 1D2S0T | 3 | 12 + 21 + 03 |
| 4 | 1S*2T*3S | 23 | 11 * 2 * 2 + 23 * 2 + 31 |
| 5 | 1D#2S*3S | 5 | 12 * (-1) * 2 + 21 * 2 + 31 |
| 6 | 1T2D3D# | -4 | 13 + 22 + 32 * (-1) |
| 7 | 1D2S3T* | 59 | 12 + 21 * 2 + 33 * 2 |

[해설 보러가기](http://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/)

## 풀이

- *이 나오면 *2를 하고 #이 나오면 *-1을 한다.
    - 이때 *는 직전 점수도 2배로 만든다.
- 고민하다가 스택 사용해서 풀었다!
- 중간에 10 때문에 틀렸었는데 메소드를 분리하다보니 i++을 지워버려서 0이 중복으로 들어갔기 때문에 발생한 것

## 코드

```java
import java.util.Stack;
import java.util.List;
import java.util.Arrays;

class Solution {
    private final List<Character> DOMAIN = Arrays.asList('S', 'D', 'T');
    private final List<Integer> POW = Arrays.asList(1, 2, 3);
    private Stack<Integer> bucket;
    private boolean isTen = false;
    
    public int solution(String dartResult) {
        bucket = new Stack<>();
        
        for (int i = 0; i < dartResult.length(); i++) {
            char element = dartResult.charAt(i);
            initBucketByCalculation(dartResult, element, i);
            
            if (isTen) {
                i++;
            }
            isTen = false;
        }
        
        return getAnswer();
    }
    
    private void initBucketByCalculation(String dartResult, char element, int index) {
        if (element >= '0' && element <= '9') {
            initBucketWhenNumber(dartResult, element, index);
        }
        
        if (element >= 'A' && element <= 'Z') {
            initBucketWhenChar(element);
        }
        
        if (element == '*') {
            initBucketWhenStart();
        } 
        
        if (element == '#') {
            initBucketWhenPoundKey();
        }
    }
    
    private void initBucketWhenNumber(String dartResult, char element, int index) {
        if (index < dartResult.length() - 1 && dartResult.charAt(index + 1) == '0') {
            bucket.push(10);
            isTen = true;
        } else {
            bucket.push(element - '0');
        }
    }
    
    private void initBucketWhenChar(char element) {
        int result = (int) Math.pow(bucket.pop(), POW.get(DOMAIN.indexOf(element)));
        bucket.push(result);
    }
    
    private void initBucketWhenStart() {
        if (bucket.size() >= 2) {
            int result1 = bucket.pop() * 2;
            int result2 = bucket.pop() * 2;
            bucket.push(result2);
            bucket.push(result1);
        } else {
            int result = bucket.pop() * 2;
            bucket.push(result);
        }
    }
    
    private void initBucketWhenPoundKey() {
         int result = bucket.pop() * (-1);
        bucket.push(result);
    }
    
    private int getAnswer() {
        int sum = 0;
        
        for (int i = 0; i < bucket.size(); i++) {
            sum += bucket.get(i);
        }
        
        return sum;
    }
}

테스트 1 〉	통과 (0.13ms, 77.2MB)
테스트 2 〉	통과 (0.15ms, 74.5MB)
테스트 3 〉	통과 (0.15ms, 71.2MB)
테스트 4 〉	통과 (0.17ms, 76.7MB)
테스트 5 〉	통과 (0.17ms, 77.3MB)
테스트 6 〉	통과 (0.18ms, 74.8MB)
테스트 7 〉	통과 (0.20ms, 74.4MB)
테스트 8 〉	통과 (0.16ms, 76.2MB)
테스트 9 〉	통과 (0.15ms, 77.9MB)
테스트 10 〉	통과 (0.14ms, 72.4MB)
테스트 11 〉	통과 (0.15ms, 76.2MB)
테스트 12 〉	통과 (0.15ms, 72.2MB)
테스트 13 〉	통과 (0.14ms, 77.4MB)
테스트 14 〉	통과 (0.13ms, 75.7MB)
테스트 15 〉	통과 (0.14ms, 78.3MB)
테스트 16 〉	통과 (0.20ms, 80MB)
테스트 17 〉	통과 (0.14ms, 75.2MB)
테스트 18 〉	통과 (0.14ms, 72.3MB)
테스트 19 〉	통과 (0.15ms, 74.1MB)
테스트 20 〉	통과 (0.17ms, 73.4MB)
테스트 21 〉	통과 (0.15ms, 75.9MB)
테스트 22 〉	통과 (0.17ms, 78.5MB)
테스트 23 〉	통과 (0.15ms, 72.2MB)
테스트 24 〉	통과 (0.15ms, 75.7MB)
테스트 25 〉	통과 (0.16ms, 75.5MB)
테스트 26 〉	통과 (0.16ms, 74.4MB)
테스트 27 〉	통과 (0.21ms, 81.9MB)
테스트 28 〉	통과 (0.14ms, 72.7MB)
테스트 29 〉	통과 (0.14ms, 76.2MB)
테스트 30 〉	통과 (0.14ms, 72.3MB)
테스트 31 〉	통과 (0.14ms, 68MB)
테스트 32 〉	통과 (0.16ms, 77.1MB)
```
