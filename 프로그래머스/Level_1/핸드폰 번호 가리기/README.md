## **문제 설명**

프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 `*`으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.

## 제한 조건

- phone_number는 길이 4 이상, 20이하인 문자열입니다.

## 입출력 예

| phone_number | return |
| --- | --- |
| "01033334444" | "*******4444" |
| "027778888" | "*****8888" |

## 코드

```java
class Solution {
    public String solution(String phone_number) {
        return phone_number.substring(0, phone_number.length() - 4).replaceAll("[0-9]", "*") + phone_number.substring(phone_number.length() - 4);
    }
}

테스트 1 〉	통과 (1.49ms, 74.3MB)
테스트 2 〉	통과 (1.63ms, 70.1MB)
테스트 3 〉	통과 (1.61ms, 83.7MB)
테스트 4 〉	통과 (1.93ms, 76.6MB)
테스트 5 〉	통과 (1.19ms, 77.2MB)
테스트 6 〉	통과 (1.35ms, 75.8MB)
테스트 7 〉	통과 (1.83ms, 78.6MB)
테스트 8 〉	통과 (1.53ms, 70.9MB)
테스트 9 〉	통과 (1.33ms, 80.9MB)
테스트 10 〉	통과 (1.33ms, 75MB)
테스트 11 〉	통과 (1.39ms, 72.9MB)
테스트 12 〉	통과 (1.20ms, 77.2MB)
테스트 13 〉	통과 (1.86ms, 76.6MB)
```
