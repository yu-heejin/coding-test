## **문제 설명**

점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.

전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

## 제한사항

- 전체 학생의 수는 2명 이상 30명 이하입니다.
- 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
- 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
- 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
- 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.

## 입출력 예

| n | lost | reserve | return |
| --- | --- | --- | --- |
| 5 | [2, 4] | [1, 3, 5] | 5 |
| 5 | [2, 4] | [3] | 4 |
| 3 | [3] | [1] | 2 |

## 입출력 예 설명

예제 #11번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면 학생 5명이 체육수업을 들을 수 있습니다.

예제 #23번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있습니다.

## 문제가 잘 안풀린다면😢

힌트가 필요한가요? [코딩테스트 연습 힌트 모음집]으로 오세요! → [클릭](https://school.programmers.co.kr/learn/courses/14743?itm_content=lesson42862)

[출처](http://hsin.hr/coci/archive/2009_2010/contest6_tasks.pdf)

※ 공지 - 2019년 2월 18일 지문이 리뉴얼되었습니다.

※ 공지 - 2019년 2월 27일, 28일 테스트케이스가 추가되었습니다.

※ 공지 - 2021년 7월 28일 테스트케이스가 추가되었습니다.

※ 공지 - 2021년 8월 30일 테스트케이스가 추가되었습니다.

※ 공지 - 2022년 11월 30일 테스트케이스가 추가되었습니다.

## 풀이

- 뒷사람보다 앞사람을 먼저 빌려줘야 정답
- 정렬되지 않은 경우도 고려해야 한다.

## 코드

```java
import java.util.Arrays;

class Solution {
    private int[] trainingClothes;
    
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        initTotalTrainingClothes(n, lost, reserve);
        
        for (int i = 0; i < trainingClothes.length; i++) {
            lendTrainingClothes(i);
        }
        
        return getAnswer();
    }
    
    private void initTotalTrainingClothes(int n, int[] lost, int[] reserve) {
        trainingClothes = new int[n];
        
        Arrays.fill(trainingClothes, 1);
        
        for (int i = 0; i < lost.length; i++) {
            trainingClothes[lost[i] - 1]--;
        }
        
        for (int i = 0; i < reserve.length; i++) {
            trainingClothes[reserve[i] - 1]++;
        }
    }
    
    private void lendTrainingClothes(int i) {
        if (i == 0) {
            if (trainingClothes[i] > 1 && trainingClothes[i + 1] == 0) {
                trainingClothes[i]--;
                trainingClothes[i + 1]++;
            }
        } else if (i == trainingClothes.length - 1) {
            if (trainingClothes[i] > 1 && trainingClothes[i - 1] == 0) {
                trainingClothes[i]--;
                trainingClothes[i - 1]++;
            }
        } else {
            if (trainingClothes[i] > 1 && trainingClothes[i - 1] == 0) {
                trainingClothes[i]--;
                trainingClothes[i - 1]++;
            }
            
            if (trainingClothes[i] > 1 && trainingClothes[i + 1] == 0) {
                trainingClothes[i]--;
                trainingClothes[i + 1]++;
            } 
        }
    }
    
    private int getAnswer() {
        int count = 0;
        
        for (int i = 0; i < trainingClothes.length; i++) {
            if (trainingClothes[i] >= 1) {
                count++;
            }
        }
        
        return count;
    }
}

테스트 1 〉	통과 (0.53ms, 70.6MB)
테스트 2 〉	통과 (0.50ms, 77MB)
테스트 3 〉	통과 (0.49ms, 73.6MB)
테스트 4 〉	통과 (0.54ms, 70MB)
테스트 5 〉	통과 (0.36ms, 71.5MB)
테스트 6 〉	통과 (0.47ms, 69.7MB)
테스트 7 〉	통과 (1.12ms, 78.2MB)
테스트 8 〉	통과 (0.35ms, 76.5MB)
테스트 9 〉	통과 (0.50ms, 79.4MB)
테스트 10 〉	통과 (0.52ms, 73.9MB)
테스트 11 〉	통과 (1.70ms, 75.5MB)
테스트 12 〉	통과 (0.36ms, 69.5MB)
테스트 13 〉	통과 (0.48ms, 80.3MB)
테스트 14 〉	통과 (0.47ms, 70.9MB)
테스트 15 〉	통과 (0.37ms, 73.2MB)
테스트 16 〉	통과 (0.38ms, 76.4MB)
테스트 17 〉	통과 (0.48ms, 71.3MB)
테스트 18 〉	통과 (0.41ms, 81.7MB)
테스트 19 〉	통과 (0.48ms, 75MB)
테스트 20 〉	통과 (0.34ms, 77.8MB)
테스트 21 〉	통과 (0.36ms, 76.8MB)
테스트 22 〉	통과 (0.39ms, 75.9MB)
테스트 23 〉	통과 (0.48ms, 76.2MB)
테스트 24 〉	통과 (0.37ms, 75.7MB)
테스트 25 〉	통과 (1.02ms, 76MB)
```
