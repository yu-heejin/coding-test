## **문제 설명**

두 정수 `X`, `Y`의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다(**단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다**). `X`, `Y`의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. `X`, `Y`의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.

예를 들어, `X` = 3403이고 `Y` = 13203이라면, `X`와 `Y`의 짝꿍은 `X`와 `Y`에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다. 다른 예시로 `X` = 5525이고 `Y` = 1255이면 `X`와 `Y`의 짝꿍은 `X`와 `Y`에서 공통으로 나타나는 2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다(`X`에는 5가 3개, `Y`에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.)두 정수 `X`, `Y`가 주어졌을 때, `X`, `Y`의 짝꿍을 return하는 solution 함수를 완성해주세요.

## 제한사항

- 3 ≤ `X`, `Y`의 길이(자릿수) ≤ 3,000,000입니다.
- `X`, `Y`는 0으로 시작하지 않습니다.
- `X`, `Y`의 짝꿍은 상당히 큰 정수일 수 있으므로, 문자열로 반환합니다.

---

## 입출력 예

| X | Y | result |
| --- | --- | --- |
| "100" | "2345" | "-1" |
| "100" | "203045" | "0" |
| "100" | "123450" | "10" |
| "12321" | "42531" | "321" |
| "5525" | "1255" | "552" |

---

## 입출력 예 설명

**입출력 예 #1**

- `X`, `Y`의 짝꿍은 존재하지 않습니다. 따라서 "-1"을 return합니다.

**입출력 예 #2**

- `X`, `Y`의 공통된 숫자는 0으로만 구성되어 있기 때문에, 두 수의 짝꿍은 정수 0입니다. 따라서 "0"을 return합니다.

**입출력 예 #3**

- `X`, `Y`의 짝꿍은 10이므로, "10"을 return합니다.

**입출력 예 #4**

- `X`, `Y`의 짝꿍은 321입니다. 따라서 "321"을 return합니다.

**입출력 예 #5**

- 지문에 설명된 예시와 같습니다.

## 풀이

- 처음에는 중복된 숫자를 넣으면 안된다고 생각했는데, 겹치는 만큼 숫자를 넣어야한다.
    - 이 경우 중복을 허용하지 않는 HashSet은 안된다.
- 각 들어있는 공통된 숫자를 확인한 후, 가장 적게들어있는만큼 더해주는것은?
    - 이렇게 풀어서 통과는 됐는데 코드가 너무 길어졌다…

## 코드

```java
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    private final String NOT_CONTAIN = "-1";
    ArrayList<String> containNumbers;
    HashSet<String> tempContainNumbers;
    
    public String solution(String X, String Y) {
        containNumbers = new ArrayList<>();
        tempContainNumbers = new HashSet<>();
        String[] xNumbers = X.split("");
        
        getTempContainNumbers(Y, xNumbers);
        
        if (tempContainNumbers.size() == 0) {
            return NOT_CONTAIN;
        }
        
        getContainNumbers(X, Y);
        
        return getResult();
    }
    
    private void getTempContainNumbers(String Y, String[] xNumbers) {
        for (int i = 0; i < xNumbers.length; i++) {
            if (Y.contains(xNumbers[i])) {
                tempContainNumbers.add(xNumbers[i]);
            }
        }
    }
    
    private void getContainNumbers(String X, String Y) {
        Iterator<String> containIterator = tempContainNumbers.iterator();
        
        while (containIterator.hasNext()) {
            String number = containIterator.next();
            int containSize = getMinContainLength(X, Y, number);
            addContainNumbers(number, containSize);
        }
    }
    
    private int getMinContainLength(String X, String Y, String number) {
        /* code reference from: https://seeminglyjs.tistory.com/426 */
        int xCount = X.length() - X.replace(number, "").length();
        int yCount = Y.length() - Y.replace(number, "").length();
        
        if (xCount < yCount) {
            return xCount;
        }
        
        return yCount;
    }
    
    private void addContainNumbers(String number, int containSize) {
        for (int i = 0; i < containSize; i++) {
            containNumbers.add(number);
        }
    }
    
    private String getResult() {
        Collections.sort(containNumbers, Comparator.reverseOrder());
        
        StringBuffer buffer = new StringBuffer();
        
        for (int i = 0; i < containNumbers.size(); i++) {
            buffer.append(containNumbers.get(i));
        }
        
        if (buffer.toString().replace("0", "").length() == 0) {
            return "0";
        }
        
        return buffer.toString();
    }
}
```
