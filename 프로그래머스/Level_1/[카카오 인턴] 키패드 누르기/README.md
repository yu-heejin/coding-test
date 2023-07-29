## **문제 설명**

스마트폰 전화 키패드의 각 칸에 다음과 같이 숫자들이 적혀 있습니다.

![https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/4b69a271-5f4a-4bf4-9ebf-6ebed5a02d8d/kakao_phone1.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/4b69a271-5f4a-4bf4-9ebf-6ebed5a02d8d/kakao_phone1.png)

이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.맨 처음 왼손 엄지손가락은 `*` 키패드에 오른손 엄지손가락은 `#` 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.

1. 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
2. 왼쪽 열의 3개의 숫자 `1`, `4`, `7`을 입력할 때는 왼손 엄지손가락을 사용합니다.
3. 오른쪽 열의 3개의 숫자 `3`, `6`, `9`를 입력할 때는 오른손 엄지손가락을 사용합니다.
4. 가운데 열의 4개의 숫자 `2`, `5`, `8`, `0`을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.

순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때, 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.

### **[제한사항]**

- numbers 배열의 크기는 1 이상 1,000 이하입니다.
- numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
- hand는 `"left"` 또는 `"right"` 입니다.
    - `"left"`는 왼손잡이, `"right"`는 오른손잡이를 의미합니다.
- 왼손 엄지손가락을 사용한 경우는 `L`, 오른손 엄지손가락을 사용한 경우는 `R`을 순서대로 이어붙여 문자열 형태로 return 해주세요.

---

## **입출력 예**

| numbers | hand | result |
| --- | --- | --- |
| [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5] | "right" | "LRLLLRLLRRL" |
| [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2] | "left" | "LRLLRRLLLRR" |
| [1, 2, 3, 4, 5, 6, 7, 8, 9, 0] | "right" | "LLRLLRLLRL" |

## **입출력 예에 대한 설명**

**입출력 예 #1**

순서대로 눌러야 할 번호가 [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]이고, 오른손잡이입니다.

| 왼손 위치 | 오른손 위치 | 눌러야 할 숫자 | 사용한 손 | 설명 |
| --- | --- | --- | --- | --- |
| * | # | 1 | L | 1은 왼손으로 누릅니다. |
| 1 | # | 3 | R | 3은 오른손으로 누릅니다. |
| 1 | 3 | 4 | L | 4는 왼손으로 누릅니다. |
| 4 | 3 | 5 | L | 왼손 거리는 1, 오른손 거리는 2이므로 왼손으로 5를 누릅니다. |
| 5 | 3 | 8 | L | 왼손 거리는 1, 오른손 거리는 3이므로 왼손으로 8을 누릅니다. |
| 8 | 3 | 2 | R | 왼손 거리는 2, 오른손 거리는 1이므로 오른손으로 2를 누릅니다. |
| 8 | 2 | 1 | L | 1은 왼손으로 누릅니다. |
| 1 | 2 | 4 | L | 4는 왼손으로 누릅니다. |
| 4 | 2 | 5 | R | 왼손 거리와 오른손 거리가 1로 같으므로, 오른손으로 5를 누릅니다. |
| 4 | 5 | 9 | R | 9는 오른손으로 누릅니다. |
| 4 | 9 | 5 | L | 왼손 거리는 1, 오른손 거리는 2이므로 왼손으로 5를 누릅니다. |
| 5 | 9 | - | - |  |

따라서 `"LRLLLRLLRRL"`를 return 합니다.

**입출력 예 #2**

왼손잡이가 [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]를 순서대로 누르면 사용한 손은 `"LRLLRRLLLRR"`이 됩니다.

**입출력 예 #3**

오른손잡이가 [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]를 순서대로 누르면 사용한 손은 `"LLRLLRLLRL"`이 됩니다.

## 풀이

- 유클리드 거리와 맨해튼 거리 알고리즘

## 코드

```java
// Code idea reference from: https://tosuccess.tistory.com/211
class Solution {
    private final int[][] KEYPAD_POSITION = {
        {0, 0}, // 1
        {1, 0}, // 2
        {2, 0}, // 3
        {0, 1}, // 4
        {1, 1}, // 5
        {2, 1}, // 6
        {0, 2}, // 7
        {1, 2}, // 8
        {2, 2}, // 9
        {0, 3}, // *
        {1, 3}, // 0
        {2, 3} // #
    };
    private final int LEFT_DEFAULT_POSITION = 9;
    private final int RIGHT_DEFAULT_POSITION = 11;
    private final int NUMBER_FOR_CHANGING_ZERO = 11;
    private final String LEFT = "L";
    private final String RIGHT = "R";
    private int[] leftPosition = KEYPAD_POSITION[LEFT_DEFAULT_POSITION];
    private int[] rightPosition = KEYPAD_POSITION[RIGHT_DEFAULT_POSITION];
    
    public String solution(int[] numbers, String hand) {
        StringBuffer answer = new StringBuffer();
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numbers[i] = NUMBER_FOR_CHANGING_ZERO;
            }
            
            String result = getLeftOrRight(numbers[i], hand);
            answer.append(result);
            getLeftOrRightPosition(result, numbers[i]);
        }
        
        return answer.toString();
    }
    
    private String getLeftOrRight(int number, String hand) {
        if (number == 1 || number == 4 || number == 7) {
            return LEFT;
        } 
        
        if (number == 3 || number == 6 || number == 9) {
            return RIGHT;
        }
        
        int[] numbersPosition = KEYPAD_POSITION[number - 1];
        int tempLeftPosition = getManhattanDistance(numbersPosition, leftPosition);
        int tempRightPosition = getManhattanDistance(numbersPosition, rightPosition);
        
        if (tempLeftPosition < tempRightPosition) {
            return LEFT;   
        } 
        
        if (tempLeftPosition == tempRightPosition) {
            if (hand.equals("left")) {
                return LEFT;
            } 
            
            return RIGHT;
        } 
        
        return RIGHT;
        
    }
    
    private int getManhattanDistance(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }
    
    
    private void getLeftOrRightPosition(String result, int number) {
        if (result.equals(LEFT)) {
            leftPosition = KEYPAD_POSITION[number - 1];
            return;
        }
        
        rightPosition = KEYPAD_POSITION[number - 1];
    }
}

테스트 1 〉	통과 (0.07ms, 73.9MB)
테스트 2 〉	통과 (0.08ms, 75.7MB)
테스트 3 〉	통과 (0.10ms, 83.2MB)
테스트 4 〉	통과 (0.07ms, 77.1MB)
테스트 5 〉	통과 (0.09ms, 83.8MB)
테스트 6 〉	통과 (0.12ms, 78.5MB)
테스트 7 〉	통과 (0.08ms, 82.1MB)
테스트 8 〉	통과 (0.08ms, 73.1MB)
테스트 9 〉	통과 (0.14ms, 78.1MB)
테스트 10 〉	통과 (0.13ms, 82.5MB)
테스트 11 〉	통과 (0.10ms, 78.5MB)
테스트 12 〉	통과 (0.09ms, 75.4MB)
테스트 13 〉	통과 (0.12ms, 76.1MB)
테스트 14 〉	통과 (0.18ms, 74.4MB)
테스트 15 〉	통과 (0.34ms, 76.2MB)
테스트 16 〉	통과 (0.45ms, 74.2MB)
테스트 17 〉	통과 (0.62ms, 73MB)
테스트 18 〉	통과 (0.48ms, 74MB)
테스트 19 〉	통과 (0.55ms, 77.1MB)
테스트 20 〉	통과 (0.54ms, 78.3MB)
```

너무 어렵다~
