## 문제 설명

신입사원 무지는 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템을 개발하려 합니다. 무지가 개발하려는 시스템은 다음과 같습니다.

- 각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
    - 신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
    - 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
- k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
    - 유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.

다음은 전체 유저 목록이 ["muzi", "frodo", "apeach", "neo"]이고, k = 2(즉, 2번 이상 신고당하면 이용 정지)인 경우의 예시입니다.

| 유저 ID | 유저가 신고한 ID | 설명 |
| --- | --- | --- |
| "muzi" | "frodo" | "muzi"가 "frodo"를 신고했습니다. |
| "apeach" | "frodo" | "apeach"가 "frodo"를 신고했습니다. |
| "frodo" | "neo" | "frodo"가 "neo"를 신고했습니다. |
| "muzi" | "neo" | "muzi"가 "neo"를 신고했습니다. |
| "apeach" | "muzi" | "apeach"가 "muzi"를 신고했습니다. |

각 유저별로 신고당한 횟수는 다음과 같습니다.

| 유저 ID | 신고당한 횟수 |
| --- | --- |
| "muzi" | 1 |
| "frodo" | 2 |
| "apeach" | 0 |
| "neo" | 2 |

위 예시에서는 2번 이상 신고당한 "frodo"와 "neo"의 게시판 이용이 정지됩니다. 이때, 각 유저별로 신고한 아이디와 정지된 아이디를 정리하면 다음과 같습니다.

| 유저 ID | 유저가 신고한 ID | 정지된 ID |
| --- | --- | --- |
| "muzi" | ["frodo", "neo"] | ["frodo", "neo"] |
| "frodo" | ["neo"] | ["neo"] |
| "apeach" | ["muzi", "frodo"] | ["frodo"] |
| "neo" | 없음 | 없음 |

따라서 "muzi"는 처리 결과 메일을 2회, "frodo"와 "apeach"는 각각 처리 결과 메일을 1회 받게 됩니다.

이용자의 ID가 담긴 문자열 배열 `id_list`, 각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열 `report`, 정지 기준이 되는 신고 횟수 `k`가 매개변수로 주어질 때, 각 유저별로 처리 결과 메일을 받은 횟수를 배열에 담아 return 하도록 solution 함수를 완성해주세요.

---

## 제한사항

- 2 ≤ `id_list`의 길이 ≤ 1,000
    - 1 ≤ `id_list`의 원소 길이 ≤ 10
    - `id_list`의 원소는 이용자의 id를 나타내는 문자열이며 알파벳 소문자로만 이루어져 있습니다.
    - `id_list`에는 같은 아이디가 중복해서 들어있지 않습니다.
- 1 ≤ `report`의 길이 ≤ 200,000
    - 3 ≤ `report`의 원소 길이 ≤ 21
    - `report`의 원소는 "이용자id 신고한id"형태의 문자열입니다.
    - 예를 들어 "muzi frodo"의 경우 "muzi"가 "frodo"를 신고했다는 의미입니다.
    - id는 알파벳 소문자로만 이루어져 있습니다.
    - 이용자id와 신고한id는 공백(스페이스)하나로 구분되어 있습니다.
    - 자기 자신을 신고하는 경우는 없습니다.
- 1 ≤ `k` ≤ 200, `k`는 자연수입니다.
- return 하는 배열은 `id_list`에 담긴 id 순서대로 각 유저가 받은 결과 메일 수를 담으면 됩니다.

---

## 입출력 예

| id_list | report | k | result |
| --- | --- | --- | --- |
| ["muzi", "frodo", "apeach", "neo"] | ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"] | 2 | [2,1,1,0] |
| ["con", "ryan"] | ["ryan con", "ryan con", "ryan con", "ryan con"] | 3 | [0,0] |

---

## 입출력 예 설명

**입출력 예 #1**

문제의 예시와 같습니다.

**입출력 예 #2**

"ryan"이 "con"을 4번 신고했으나, 주어진 조건에 따라 한 유저가 같은 유저를 여러 번 신고한 경우는 신고 횟수 1회로 처리합니다. 따라서 "con"은 1회 신고당했습니다. 3번 이상 신고당한 이용자는 없으며, "con"과 "ryan"은 결과 메일을 받지 않습니다. 따라서 [0, 0]을 return 합니다.

---

## 제한시간 안내

- 정확성 테스트 : 10초

## 풀이

- report의 원소는 이용자id - 신고한id
- 한 유저를 여러번 신고할 수 있으나 동일 유저에 대한 신고 횟수는 1회로 처리
    - 중복된 키 값을 저장하지 않는 컬렉션을 활용해서 중복 신고를 1회로 처리한다.
    - map으로 생각했을 때 신고자랑 피신고자 모두 중복처리는 필요하다….
- 신고당한 유저가 아니라 신고한 모든 유저에게 정지 사실을 보내야한다.

## 코드

```java
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
    private final int REPORTER_INDEX = 0;
    private final int REPORTED_INDEX = 1;
    private HashSet<String> reportResults;
    private HashMap<String, Integer> reportedUsers;
    private HashMap<String, Integer> mailedUsers;
    
    public int[] solution(String[] id_list, String[] report, int k) {
        reportResults = new HashSet<>();
        reportedUsers = new HashMap<>();
        mailedUsers = new HashMap<>();
        
        addReportResults(report);
        addReportedUsers();
        addMailedUsers(k);
        
        return getAnswer(id_list);
    }
    
    private void addReportResults(String[] report) {
        for (int i = 0; i < report.length; i++) {
            reportResults.add(report[i]);
        }
    }
    
    private void addReportedUsers() {
        Iterator<String> reportResultsIterator = reportResults.iterator();
        
        while (reportResultsIterator.hasNext()) {
            String[] reportRelation = reportResultsIterator.next().split(" ");
            String reportedUser = reportRelation[REPORTED_INDEX];
            
            reportedUsers.put(reportedUser, reportedUsers.getOrDefault(reportedUser, 0) + 1);
        }
    }
    
    private void addMailedUsers(int k) {
        Iterator<String> reportResultsIterator = reportResults.iterator();
        
        while (reportResultsIterator.hasNext()) {
            String[] reportRelation = reportResultsIterator.next().split(" ");
            String reportedUser = reportRelation[REPORTED_INDEX];
            String reporter = reportRelation[REPORTER_INDEX];
            
            if (reportedUsers.get(reportedUser) >= k) {
                mailedUsers.put(reporter, mailedUsers.getOrDefault(reporter, 0) + 1);
            }
        }
    }
    
    private int[] getAnswer(String[] id_list) {
        int[] answer = new int[id_list.length];
        
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mailedUsers.getOrDefault(id_list[i], 0);
        }
        
        return answer;
    }
}

테스트 1 〉	통과 (0.13ms, 77.4MB)
테스트 2 〉	통과 (0.27ms, 71.3MB)
테스트 3 〉	통과 (227.48ms, 177MB)
테스트 4 〉	통과 (0.53ms, 72.4MB)
테스트 5 〉	통과 (0.45ms, 78.1MB)
테스트 6 〉	통과 (5.39ms, 83.4MB)
테스트 7 〉	통과 (5.72ms, 84.9MB)
테스트 8 〉	통과 (7.20ms, 96.3MB)
테스트 9 〉	통과 (115.20ms, 149MB)
테스트 10 〉	통과 (124.05ms, 149MB)
테스트 11 〉	통과 (225.10ms, 175MB)
테스트 12 〉	통과 (1.68ms, 80.5MB)
테스트 13 〉	통과 (2.13ms, 79.8MB)
테스트 14 〉	통과 (95.35ms, 138MB)
테스트 15 〉	통과 (129.83ms, 151MB)
테스트 16 〉	통과 (1.32ms, 75.7MB)
테스트 17 〉	통과 (1.55ms, 78.3MB)
테스트 18 〉	통과 (3.20ms, 76.8MB)
테스트 19 〉	통과 (4.74ms, 78.8MB)
테스트 20 〉	통과 (101.89ms, 134MB)
테스트 21 〉	통과 (179.61ms, 155MB)
테스트 22 〉	통과 (0.11ms, 73MB)
테스트 23 〉	통과 (0.17ms, 76.7MB)
테스트 24 〉	통과 (0.17ms, 74.6MB)

채점 결과
정확성: 100.0
합계: 100.0 / 100.0
```
