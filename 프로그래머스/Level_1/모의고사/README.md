## **문제 설명**

수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

## 제한 조건

- 시험은 최대 10,000 문제로 구성되어있습니다.
- 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
- 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

## 입출력 예

| answers | return |
| --- | --- |
| [1,2,3,4,5] | [1] |
| [1,3,2,4,2] | [1,2,3] |

## 입출력 예 설명

입출력 예 #1

- 수포자 1은 모든 문제를 맞혔습니다.
- 수포자 2는 모든 문제를 틀렸습니다.
- 수포자 3은 모든 문제를 틀렸습니다.

따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

입출력 예 #2

- 모든 사람이 2문제씩을 맞췄습니다.

## 풀이

- 나머지 연산을 사용하면 index가 초과되지 않는다.
- 처음에 값을 넣는 방식이 잘못돼서 틀렸다.
    - 첫번째 원소를 max라고 잡지 말고, 배열 중 가장 큰 값을 미리 찾고, 그 값과 같은 값만 넣어야 답이 나온다.
    - 배열의 크기가 3개였기 때문에 Math.max를 이용해 구했지만, 만약 길이가 여러개라면 컬렉션으로 변환 후 Collections.max를 사용하는 편이 좋아보인다.

## 코드

```java
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

/* code reference from: 
 - https://velog.io/@ppmyor/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4Programmers-%EB%AA%A8%EC%9D%98%EA%B3%A0%EC%82%AC-javascript
 - https://velog.io/@hi_potato/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%AA%A8%EC%9D%98%EA%B3%A0%EC%82%AC-JAVA 
*/
class Solution {
    private final int[] CHECK_ONE = {1, 2, 3, 4, 5};
    private final int[] CHECK_TWO = {2, 1, 2, 3, 2, 4, 2, 5};
    private final int[] CHECK_THREE = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int[] answerCounts = getAnswerCount(answers);
        Set<Integer> tempAnswer = getMaxPerson(answerCounts);

        return getAnswer(tempAnswer);
    }
    
    private int[] getAnswerCount(int[] answers) {
        int checkOneLength = CHECK_ONE.length;
        int checkTwoLength = CHECK_TWO.length;
        int checkThreeLength = CHECK_THREE.length;
        int answerOneCount = 0;
        int answerTwoCount = 0;
        int answerThreeCount = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (CHECK_ONE[i % checkOneLength] == answers[i]) {
                answerOneCount++;
            }
            
            if (CHECK_TWO[i % checkTwoLength] == answers[i]) {
                answerTwoCount++;
            }
            
            if (CHECK_THREE[i % checkThreeLength] == answers[i]) {
                answerThreeCount++;
            }
        }
        
        return new int[] {answerOneCount, answerTwoCount, answerThreeCount};
    }
    
    private Set<Integer> getMaxPerson(int[] answerCounts) {
        Set<Integer> tempAnswer = new TreeSet<>();
        int max = Math.max(answerCounts[0], Math.max(answerCounts[1], answerCounts[2]));
        int maxPerson = 0;
        
        for (int i = 0; i < answerCounts.length; i++) {
            if (max <= answerCounts[i]) {
                max = answerCounts[i];
                maxPerson = i;
                tempAnswer.add(++maxPerson);
            }
        }
        
        return tempAnswer;
    }
    
    private int[] getAnswer(Set<Integer> tempAnswer) {
        int[] answer = new int[tempAnswer.size()];
        int answerIndex = 0;
        Iterator<Integer> iterator = tempAnswer.iterator();
        
        while (iterator.hasNext()) {
            answer[answerIndex] = iterator.next();
            answerIndex++;
        }
        
        return answer;
    }
}

테스트 1 〉	통과 (0.63ms, 73.7MB)
테스트 2 〉	통과 (0.49ms, 64.9MB)
테스트 3 〉	통과 (0.69ms, 70.6MB)
테스트 4 〉	통과 (0.73ms, 75.3MB)
테스트 5 〉	통과 (0.63ms, 75.9MB)
테스트 6 〉	통과 (0.64ms, 75.4MB)
테스트 7 〉	통과 (0.89ms, 71.1MB)
테스트 8 〉	통과 (0.99ms, 83.4MB)
테스트 9 〉	통과 (1.11ms, 80.5MB)
테스트 10 〉	통과 (1.08ms, 75.6MB)
테스트 11 〉	통과 (1.01ms, 77MB)
테스트 12 〉	통과 (1.07ms, 73.6MB)
테스트 13 〉	통과 (1.00ms, 71.7MB)
테스트 14 〉	통과 (1.59ms, 78.6MB)
```
