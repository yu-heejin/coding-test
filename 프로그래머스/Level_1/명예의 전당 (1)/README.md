## **문제 설명**

"명예의 전당"이라는 TV 프로그램에서는 매일 1명의 가수가 노래를 부르고, 시청자들의 문자 투표수로 가수에게 점수를 부여합니다. 매일 출연한 가수의 점수가 지금까지 출연 가수들의 점수 중 상위 k번째 이내이면 해당 가수의 점수를 명예의 전당이라는 목록에 올려 기념합니다. 즉 프로그램 시작 이후 초기에 k일까지는 모든 출연 가수의 점수가 명예의 전당에 오르게 됩니다. k일 다음부터는 출연 가수의 점수가 기존의 명예의 전당 목록의 k번째 순위의 가수 점수보다 더 높으면, 출연 가수의 점수가 명예의 전당에 오르게 되고 기존의 k번째 순위의 점수는 명예의 전당에서 내려오게 됩니다.

이 프로그램에서는 매일 "명예의 전당"의 최하위 점수를 발표합니다. 예를 들어, `k` = 3이고, 7일 동안 진행된 가수의 점수가 [10, 100, 20, 150, 1, 100, 200]이라면, 명예의 전당에서 발표된 점수는 아래의 그림과 같이 [10, 10, 10, 20, 20, 100, 100]입니다.

![https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/b0893853-7471-47c0-b7e5-1e8b46002810/%EA%B7%B8%EB%A6%BC1.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/b0893853-7471-47c0-b7e5-1e8b46002810/%EA%B7%B8%EB%A6%BC1.png)

명예의 전당 목록의 점수의 개수 `k`, 1일부터 마지막 날까지 출연한 가수들의 점수인 `score`가 주어졌을 때, 매일 발표된 명예의 전당의 최하위 점수를 return하는 solution 함수를 완성해주세요.

## 제한사항

- 3 ≤ `k` ≤ 100
- 7 ≤ `score`의 길이 ≤ 1,000
    - 0 ≤ `score[i]` ≤ 2,000

---

## 입출력 예

| k | score | result |
| --- | --- | --- |
| 3 | [10, 100, 20, 150, 1, 100, 200] | [10, 10, 10, 20, 20, 100, 100] |
| 4 | [0, 300, 40, 300, 20, 70, 150, 50, 500, 1000] | [0, 0, 0, 0, 20, 40, 70, 70, 150, 300] |

---

## 입출력 예 설명

**입출력 예 #1**

- 문제의 예시와 같습니다.

**입출력 예 #2**

- 아래와 같이, [0, 0, 0, 0, 20, 40, 70, 70, 150, 300]을 return합니다.
    
    ![https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/5175c32d-44d7-4b13-be47-360bbe6a553c/%EA%B7%B8%EB%A6%BC2.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/5175c32d-44d7-4b13-be47-360bbe6a553c/%EA%B7%B8%EB%A6%BC2.png)
    

## 풀이

### 문제 설명 분리

- 프로그램에는 매일 한명의 가수가 노래를 부르고, 시청자들의 문자 투표수가 점수가 된다.
- 매일 출연한 가수의 점수가 지금까지 출연한 가수들의 점수 중에서 상위 k번째 이내면 명예의 전당에 오른다.
- 프로그램 시작 이후 초기 k일까지는 ‘모든’ 출연 가수의 점수가 명예의 전당에 오른다.
- k일 다음부터는 출연 가수의 점수가 기존 명예의 전당 목록의 가수 점수보다 높으면 해당 출연 가수의 점수가 명예의 전당에 오르고 기존 가수는 내려오게 된다.
- 해당 프로그램은 매일 ‘명예의 전당 최하위 점수’를 발표한다.

### 예시 분석

**k = 3이고, 7일간 진행된 가수의 점수가 [10, 100, 20, 150, 1, 100, 200]**

- 3일까지는 모든 가수가 명예의 전당에 오른다. (10, 100, 20) → 10이 3일간 최하위
- 4일 이후 150이 올라오고 10이 내려간다 (150, 100, 20) → 20이 최하위
- 5일차 1은 올라오지도 못한다.
- 6일차 (150, 100, 100) → 100 최하위
- 마지막 7일차 (200, 150, 100) → 100 최하위

### 알고리즘

1. k일 전까지는 모든 값이 들어간다.
    1. 즉, 지금까지 명예의 전당에 오른 가수의 수가 k보다 작으면 모든 가수가 들어간다.
2. k일 이후 가장 작은 값이 밀려나고 더 큰 값이 들어온다.
3. 계속 오름차순으로 정렬하고, 가장 작은 값의 인덱스를 상수로 0 설정하기
    1. 이 방법을 생각했는데 내부적으로 계속 sort하기 때문에 성능상 문제가 고민되었다.
    2. Arrays.sort 보단 Collection.sort가 성능이 더 좋아서 명예의 전당 리스트를 동적 배열로 변경했다.
4. k에 비해 score 길이가 짧은 경우도 생각해야한다. (런타임 에러)

## 실패한 코드

```java
import java.util.Arrays;

class Solution {
    private final int BASIC_MIN_INDEX = 0;
    
    private int[] lowestRanks;
    private int[] hallOfFame;
    private int minScore;
    private int minScoreIndex;
    
    public int[] solution(int k, int[] score) {
        lowestRanks = new int[score.length];
        hallOfFame = new int[k];
        minScore = Integer.MAX_VALUE;
        
        if (k > score.length) {
            for (int i = 0; i < score.length; i++) {
                hallOfFame[i] = score[i];
                
                if (minScore > hallOfFame[i]) {
                    minScore = hallOfFame[i];
                }
                
                lowestRanks[i] = minScore;
            }
        } else {
            for (int i = 0; i < score.length; i++) {
                if (i < k) {
                    hallOfFame[i] = score[i];
                    
                    if (minScore > hallOfFame[i]) {
                        minScore = hallOfFame[i];
                        minScoreIndex = i;
                    }
                } else {
                    if (minScore < score[i]) {
                        hallOfFame[minScoreIndex] = score[i];
                        Arrays.sort(hallOfFame);
                        minScore = hallOfFame[BASIC_MIN_INDEX];
											// 이 부분에 minIndex 설정을 안해서 실패한 것 같다!
                    }
                }
                
                lowestRanks[i] = minScore;
            }
        }
        
        return lowestRanks;
    }
}
```
