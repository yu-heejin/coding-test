## **문제 설명**

배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

1. array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
2. 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
3. 2에서 나온 배열의 3번째 숫자는 5입니다.

배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

## 제한사항

- array의 길이는 1 이상 100 이하입니다.
- array의 각 원소는 1 이상 100 이하입니다.
- commands의 길이는 1 이상 50 이하입니다.
- commands의 각 원소는 길이가 3입니다.

## 입출력 예

| array | commands | return |
| --- | --- | --- |
| [1, 5, 2, 6, 3, 7, 4] | [[2, 5, 3], [4, 4, 1], [1, 7, 3]] | [5, 6, 3] |

## 입출력 예 설명

[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.

[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.

[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.

[출처](https://neerc.ifmo.ru/subregions/northern.html)

## 코드

- Arrays 파티~

```java
import java.util.Arrays;

class Solution {
    private final int START = 0;
    private final int END = 1;
    private final int POSITION = 2;
    
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            answer[i] = getResult(array, commands[i]);
        }
        
        return answer;
    }
    
    private int getResult(int[] array, int[] command) {
        int[] subArray = Arrays.copyOfRange(array, command[START] - 1, command[END]);
        Arrays.sort(subArray);
        return subArray[command[POSITION] - 1];
    }
}

테스트 1 〉	통과 (0.39ms, 71.8MB)
테스트 2 〉	통과 (0.45ms, 78.9MB)
테스트 3 〉	통과 (0.41ms, 65.4MB)
테스트 4 〉	통과 (0.37ms, 70.6MB)
테스트 5 〉	통과 (0.56ms, 73.4MB)
테스트 6 〉	통과 (0.48ms, 84.6MB)
테스트 7 〉	통과 (0.39ms, 71.5MB)
```
