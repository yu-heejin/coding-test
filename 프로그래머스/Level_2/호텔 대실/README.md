## **문제 설명**

호텔을 운영 중인 코니는 최소한의 객실만을 사용하여 예약 손님들을 받으려고 합니다. 한 번 사용한 객실은 퇴실 시간을 기준으로 10분간 청소를 하고 다음 손님들이 사용할 수 있습니다.예약 시각이 문자열 형태로 담긴 2차원 배열 `book_time`이 매개변수로 주어질 때, 코니에게 필요한 최소 객실의 수를 return 하는 solution 함수를 완성해주세요.

---

## 제한사항

- 1 ≤ `book_time`의 길이 ≤ 1,000
    - `book_time[i]`는 ["HH:MM", "HH:MM"]의 형태로 이루어진 배열입니다
        - [대실 시작 시각, 대실 종료 시각] 형태입니다.
    - 시각은 HH:MM 형태로 24시간 표기법을 따르며, "00:00" 부터 "23:59" 까지로 주어집니다.
        - 예약 시각이 자정을 넘어가는 경우는 없습니다.
        - 시작 시각은 항상 종료 시각보다 빠릅니다.

---

## 입출력 예

| book_time | result |
| --- | --- |
| [["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]] | 3 |
| [["09:10", "10:10"], ["10:20", "12:20"]] | 1 |
| [["10:20", "12:30"], ["10:20", "12:30"], ["10:20", "12:30"]] | 3 |

---

## 입출력 예 설명

입출력 예 #1

![https://user-images.githubusercontent.com/62426665/199907266-561e3b75-84eb-4da1-930c-a6ac8fa82a79.png](https://user-images.githubusercontent.com/62426665/199907266-561e3b75-84eb-4da1-930c-a6ac8fa82a79.png)

위 사진과 같습니다.

입출력 예 #2

첫 번째 손님이 10시 10분에 퇴실 후 10분간 청소한 뒤 두 번째 손님이 10시 20분에 입실하여 사용할 수 있으므로 방은 1개만 필요합니다.

입출력 예 #3

세 손님 모두 동일한 시간대를 예약했기 때문에 3개의 방이 필요합니다.

## 풀이

- 시작 시간을 기준으로 정렬하는 것이 필요할 것 같다.
    - 시작 시간을 전부 분 단위로 변경하면 가장 작은 값이 가장 빠른 시작 시간을 가짐을 알 수 있다.
- 실제 대실 종료 시간은 종료시간 + 10분
    - 10분 이후부터는 바로 사용 가능하기 때문에 완료 시각 + 9분
- 첫 예약이면 우선 방을 할당하고, 이후 들어올 때 청소 시간을 포함한 해당 시간 안에 예약이 들어오면 방을 추가로 할당한다.

## 코드

```java
// code reference from: https://123okk2.tistory.com/427

import java.util.*;

class Solution {
    private final int CLEAN_TIME = 9;
    private final int START = 0;
    private final int END = 1;
    private final int HOUR = 0;
    private final int MINUTE = 1;
    private List<List<Integer>> times;
    private PriorityQueue<Integer> rooms;
    
    public int solution(String[][] book_time) {
        initTotalMinute(book_time);
        sorting();
        
        return getRooms();
    }
    
    private void initTotalMinute(String[][] book_time) {
        times = new ArrayList<>();
        
        // 시작 시간이 가장 빠른 순서로 정렬하기 위해 시간 변환
        // 시작 시간이 가장 빠르다는 건 변환 결과 값이 가장 작다는 의미
        for (int i = 0; i < book_time.length; i++) {
            List<Integer> time = new ArrayList<>();
            
            String[] startTime = book_time[i][START].split(":");
            String[] endTime = book_time[i][END].split(":");
            
            time.add(getTotalMinute(startTime));
            time.add(getTotalMinute(endTime) + CLEAN_TIME);
            
            times.add(time);
        }
    }
    
    private int getTotalMinute(String[] times) {
        return Integer.parseInt(times[HOUR]) * 60 + Integer.parseInt(times[MINUTE]);
    }
    
    private void sorting() {
        // 시작 시간이 빠른 순서대로 정렬
        // 시작 시간이 같다면, 종료 시간이 빠른 순서로 정렬
        // 시간 복잡도 문제로 Collections.sort 사용
        Collections.sort(times, (a, b) -> {
                if (a.get(START) > b.get(START)) return 1;
                else if (a.get(START) < b.get(START)) return -1;
                else {
                    if (a.get(END) > b.get(END)) return 1;
                    else return -1;
                }
            }
        );
    }
    
    private int getRooms() {
        rooms = new PriorityQueue<>();
        
        // 현재 종료 시간이 이전의 종료 시간보다 작으면(빠르면) 방 추가
        // 우선순위 큐 사용하여 종료 시간이 가장 작은 시간을 꺼낸다.
        for (int i = 0; i < times.size(); i++) {
            if (rooms.size() == 0) {
                rooms.add(times.get(i).get(END));
            } else {
                int exitRoom = rooms.peek();
                
                if (exitRoom < times.get(i).get(START)) {
                    rooms.poll();   // 우선순위 가장 높은 값 제거
                }
                
                rooms.add(times.get(i).get(END));
            }
        }
        
        return rooms.size();
    }
}

테스트 1 〉	통과 (1.39ms, 74.2MB)
테스트 2 〉	통과 (3.41ms, 76.6MB)
테스트 3 〉	통과 (6.74ms, 80.4MB)
테스트 4 〉	통과 (7.88ms, 80.7MB)
테스트 5 〉	통과 (1.76ms, 79MB)
테스트 6 〉	통과 (6.59ms, 69MB)
테스트 7 〉	통과 (7.72ms, 82.7MB)
테스트 8 〉	통과 (5.59ms, 73.8MB)
테스트 9 〉	통과 (5.37ms, 80.1MB)
테스트 10 〉	통과 (5.84ms, 84.6MB)
테스트 11 〉	통과 (10.05ms, 80.7MB)
테스트 12 〉	통과 (8.83ms, 77.3MB)
테스트 13 〉	통과 (3.37ms, 78.4MB)
테스트 14 〉	통과 (6.59ms, 81.5MB)
테스트 15 〉	통과 (9.36ms, 93.6MB)
테스트 16 〉	통과 (5.07ms, 83.9MB)
테스트 17 〉	통과 (9.02ms, 82.7MB)
테스트 18 〉	통과 (6.01ms, 76.1MB)
테스트 19 〉	통과 (6.06ms, 80.3MB)
```
