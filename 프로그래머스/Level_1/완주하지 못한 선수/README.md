## **문제 설명**

수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

## 제한사항

- 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
- completion의 길이는 participant의 길이보다 1 작습니다.
- 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
- 참가자 중에는 동명이인이 있을 수 있습니다.

## 입출력 예

| participant | completion | return |
| --- | --- | --- |
| ["leo", "kiki", "eden"] | ["eden", "kiki"] | "leo" |
| ["marina", "josipa", "nikola", "vinko", "filipa"] | ["josipa", "filipa", "marina", "nikola"] | "vinko" |
| ["mislav", "stanko", "mislav", "ana"] | ["stanko", "ana", "mislav"] | "mislav" |

## 입출력 예 설명

예제 #1"leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #2"vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #3"mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.

---

※ 공지 - 2023년 01월 25일 테스트케이스가 추가되었습니다.

[출처](http://hsin.hr/coci/archive/2014_2015/contest2_tasks.pdf)

## 풀이

- 참가자 중 동명이인이 존재한다.
- HashMap 사용해서 동명이인의 수를 센 후, 동명이인의 수가 완주자 수보다 작으면 미완주자를 반환하도록 했다.

## 코드

```java
import java.util.Map;
import java.util.HashMap;

class Solution {
    private final int DEFAULT_VALUE = 0;
    private Map<String, Integer> participantCount;
    private Map<String, Integer> completionCount;
    
    public String solution(String[] participant, String[] completion) {
        participantCount = new HashMap<>();
        completionCount = new HashMap<>();
        
        initParticipantCount(participant);
        initCompletionCount(completion);
        
        return getAnswer(participant);
    }
    
    private void initParticipantCount(String[] participant) {
        for (int i = 0; i < participant.length; i++) {
            participantCount.put(participant[i], participantCount.getOrDefault(participant[i], DEFAULT_VALUE) + 1);
        }
    }
    
    private void initCompletionCount(String[] completion) {
        for (int i = 0; i < completion.length; i++) {
            completionCount.put(completion[i], completionCount.getOrDefault(completion[i], DEFAULT_VALUE) + 1);
        }
    }
    
    private String getAnswer(String[] participant) {
        for (int i = 0; i < participant.length; i++) {
            if (completionCount.containsKey(participant[i])) {
                if (participantCount.get(participant[i]) > completionCount.get(participant[i])) {
                    return participant[i];
                }
            } else {
                return participant[i];
            }
        }
        
        return "";
    }
}

정확성  테스트
테스트 1 〉	통과 (0.04ms, 75.6MB)
테스트 2 〉	통과 (0.06ms, 71MB)
테스트 3 〉	통과 (0.67ms, 81.9MB)
테스트 4 〉	통과 (0.97ms, 79MB)
테스트 5 〉	통과 (0.91ms, 80.8MB)
테스트 6 〉	통과 (0.05ms, 78.4MB)
테스트 7 〉	통과 (0.03ms, 75.1MB)

효율성  테스트
테스트 1 〉	통과 (51.24ms, 81.8MB)
테스트 2 〉	통과 (94.87ms, 88.3MB)
테스트 3 〉	통과 (107.58ms, 95.8MB)
테스트 4 〉	통과 (96.62ms, 96.2MB)
테스트 5 〉	통과 (79.10ms, 96.1MB)

채점 결과
정확성: 58.3
효율성: 41.7
합계: 100.0 / 100.0
```
