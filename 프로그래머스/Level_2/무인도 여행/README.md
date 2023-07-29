## **문제 설명**

메리는 여름을 맞아 무인도로 여행을 가기 위해 지도를 보고 있습니다. 지도에는 바다와 무인도들에 대한 정보가 표시돼 있습니다. 지도는 1 x 1크기의 사각형들로 이루어진 직사각형 격자 형태이며, 격자의 각 칸에는 'X' 또는 1에서 9 사이의 자연수가 적혀있습니다. 지도의 'X'는 바다를 나타내며, 숫자는 무인도를 나타냅니다. 이때, 상, 하, 좌, 우로 연결되는 땅들은 하나의 무인도를 이룹니다. 지도의 각 칸에 적힌 숫자는 식량을 나타내는데, 상, 하, 좌, 우로 연결되는 칸에 적힌 숫자를 모두 합한 값은 해당 무인도에서 최대 며칠동안 머물 수 있는지를 나타냅니다. 어떤 섬으로 놀러 갈지 못 정한 메리는 우선 각 섬에서 최대 며칠씩 머물 수 있는지 알아본 후 놀러갈 섬을 결정하려 합니다.

지도를 나타내는 문자열 배열 `maps`가 매개변수로 주어질 때, 각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 return 하는 solution 함수를 완성해주세요. 만약 지낼 수 있는 무인도가 없다면 -1을 배열에 담아 return 해주세요.

---

## 제한사항

- 3 ≤ `maps`의 길이 ≤ 100
    - 3 ≤ `maps[i]`의 길이 ≤ 100
    - `maps[i]`는 'X' 또는 1 과 9 사이의 자연수로 이루어진 문자열입니다.
    - 지도는 직사각형 형태입니다.

---

## 입출력 예

| maps | result |
| --- | --- |
| ["X591X","X1X5X","X231X", "1XXX1"] | [1, 1, 27] |
| ["XXX","XXX","XXX"] | [-1] |

---

## 입출력 예 설명

입출력 예 #1

위 문자열은 다음과 같은 지도를 나타냅니다.

![https://user-images.githubusercontent.com/62426665/206862823-4633fbf1-c075-4d35-b577-26f504dcd332.png](https://user-images.githubusercontent.com/62426665/206862823-4633fbf1-c075-4d35-b577-26f504dcd332.png)

연결된 땅들의 값을 합치면 다음과 같으며

![https://user-images.githubusercontent.com/62426665/209070615-ae568f20-cf06-4f88-8d4f-8e9861af2d36.png](https://user-images.githubusercontent.com/62426665/209070615-ae568f20-cf06-4f88-8d4f-8e9861af2d36.png)

이를 오름차순으로 정렬하면 [1, 1, 27]이 됩니다.

입출력 예 #2

위 문자열은 다음과 같은 지도를 나타냅니다.

![https://user-images.githubusercontent.com/62426665/206863265-0a371c69-d4b5-411a-972f-bdc36b90c917.png](https://user-images.githubusercontent.com/62426665/206863265-0a371c69-d4b5-411a-972f-bdc36b90c917.png)

섬이 존재하지 않기 때문에 -1을 배열에 담아 반환합니다.

## 풀이

- 인접 행렬을 정수형으로 바꾼 후 BFS 사용
- 안 바꾸고도 가능할 것 같긴 하다.

## 코드

```java
// code reference from: https://123okk2.tistory.com/422
import java.util.*;

class Solution {
    private final int[] NO_ANSWER = { -1 };
    private List<Integer> tempAnswers;
    private int[][] matrix;
    private boolean[][] visited;
    
    public int[] solution(String[] maps) {
        tempAnswers = new ArrayList<>();
        
        initMatrix(maps);
        initAnswers();
        
        return getAnswers();
    }
    
    private void initMatrix(String[] maps) {
        matrix = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                matrix[i][j] = getMatrixValue(maps, i, j);
                visited[i][j] = false;
            }
        }
    }
    
    private int getMatrixValue(String[] maps, int row, int col) {
        if (maps[row].charAt(col) >= '1' && maps[row].charAt(col) <= '9') {
            return maps[row].charAt(col) - '0';
        } 
        
        return -1;
    }
    
    private void initAnswers() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int sum = dfs(i, j);
                
                if (sum > 0) {
                    tempAnswers.add(sum);
                }
            }
        }
    }
    
    private int dfs(int row, int col) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) {
            return 0;
        }
        
        if (visited[row][col]) {
            return 0;
        }
        
        visited[row][col] = true;
        
        if (matrix[row][col] == -1) {
            return 0;
        }
        
        // DFS: 상하좌우로 탐색하여 값을 더해준다.
        return matrix[row][col] + dfs(row-1, col) + dfs(row+1, col) + dfs(row, col-1) + dfs(row, col+1);
    }
    
    private int[] getAnswers() {
        if (tempAnswers.size() == 0) {
            return NO_ANSWER;
        }
        
        Collections.sort(tempAnswers);
        
        int[] answers = new int[tempAnswers.size()];
        
        for (int i = 0; i < tempAnswers.size(); i++) {
            answers[i] = tempAnswers.get(i);
        }
        
        return answers;
    }
}

테스트 1 〉	통과 (0.04ms, 74.6MB)
테스트 2 〉	통과 (0.21ms, 75.7MB)
테스트 3 〉	통과 (0.27ms, 72MB)
테스트 4 〉	통과 (0.26ms, 72.9MB)
테스트 5 〉	통과 (0.65ms, 71.1MB)
테스트 6 〉	통과 (0.89ms, 75MB)
테스트 7 〉	통과 (0.59ms, 77.1MB)
테스트 8 〉	통과 (1.05ms, 75.5MB)
테스트 9 〉	통과 (1.37ms, 73.3MB)
테스트 10 〉	통과 (2.05ms, 83.2MB)
테스트 11 〉	통과 (1.45ms, 81.3MB)
테스트 12 〉	통과 (1.81ms, 75.4MB)
테스트 13 〉	통과 (2.00ms, 78MB)
테스트 14 〉	통과 (2.30ms, 75.1MB)
테스트 15 〉	통과 (2.35ms, 85.4MB)
테스트 16 〉	통과 (3.10ms, 79.2MB)
테스트 17 〉	통과 (0.48ms, 83.3MB)
테스트 18 〉	통과 (2.74ms, 78.6MB)
테스트 19 〉	통과 (2.77ms, 73.8MB)
테스트 20 〉	통과 (2.40ms, 78.5MB)
테스트 21 〉	통과 (0.92ms, 76.7MB)
테스트 22 〉	통과 (0.21ms, 77.2MB)
테스트 23 〉	통과 (5.66ms, 82.9MB)
테스트 24 〉	통과 (5.52ms, 77.3MB)
테스트 25 〉	통과 (0.35ms, 76.2MB)
```
