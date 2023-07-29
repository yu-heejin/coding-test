## **문제 설명**

# **비밀지도**

네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다. 그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다. 다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.

1. 지도는 한 변의 길이가 `n`인 정사각형 배열 형태로, 각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
2. 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 "지도 1"과 "지도 2"라고 하자. 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
3. "지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
4. 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 `1`, 공백 부분을 `0`으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.

![http://t1.kakaocdn.net/welcome2018/secret8.png](http://t1.kakaocdn.net/welcome2018/secret8.png)

네오가 프로도의 비상금을 손에 넣을 수 있도록, 비밀지도의 암호를 해독하는 작업을 도와줄 프로그램을 작성하라.

## **입력 형식**

입력으로 지도의 한 변 크기 `n` 과 2개의 정수 배열 `arr1`, `arr2`가 들어온다.

- 1 ≦ `n` ≦ 16
- `arr1`, `arr2`는 길이 `n`인 정수 배열로 주어진다.
- 정수 배열의 각 원소 `x`를 이진수로 변환했을 때의 길이는 `n` 이하이다. 즉, 0 ≦ `x` ≦ 2 - 1을 만족한다.
    
    n
    

## **출력 형식**

원래의 비밀지도를 해독하여 `'#'`, `공백`으로 구성된 문자열 배열로 출력하라.

## **입출력 예제**

| 매개변수 | 값 |
| --- | --- |
| n | 5 |
| arr1 | [9, 20, 28, 18, 11] |
| arr2 | [30, 1, 21, 17, 28] |
| 출력 | ["#####","# # #", "### #", "# ##", "#####"] |

| 매개변수 | 값 |
| --- | --- |
| n | 6 |
| arr1 | [46, 33, 33 ,22, 31, 50] |
| arr2 | [27 ,56, 19, 14, 14, 10] |
| 출력 | ["######", "### #", "## ##", " #### ", " #####", "### # "] |

[해설 보러가기](http://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/)

## 풀이

- 지도가 2개 있고, 어느 한 군데라도 벽이 있으면 벽이다.

## 코드

```java
import java.util.List;
import java.util.ArrayList;

class Solution {
    private final char WALL = '#';
    private final char BLANK = ' ';
    private final char WALL_NUMBER = '1';
    private final char BLANK_NUMBER = '0';
    private final String ZERO = "0";
    private List<String> decodeArr1Results;
    private List<String> decodeArr2Results;
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        decodeArr1Results = new ArrayList<>();
        decodeArr2Results = new ArrayList<>();
        
        initDecodeResults(n, arr1, arr2);

        return getAnswer(n);
    }
    
    private void initDecodeResults(int n, int[] arr1, int[] arr2) {
        for (int i = 0; i < n; i++) {
            String decodeArr1Result = Integer.toBinaryString(arr1[i]);
            String decodeArr2Result = Integer.toBinaryString(arr2[i]);
            
            if (decodeArr1Result.length() < n) {
                decodeArr1Result = addZero(n, decodeArr1Result) + decodeArr1Result;
            }
            
            if (decodeArr2Result.length() < n) {
                decodeArr2Result = addZero(n, decodeArr2Result) + decodeArr2Result;
            }
            
            decodeArr1Results.add(decodeArr1Result);
            decodeArr2Results.add(decodeArr2Result);
        }
    }
    
    private String addZero(int n, String decodeResult) {
        StringBuilder temp = new StringBuilder();
        
        for (int j = 1; j <= n - decodeResult.length(); j++) {
            temp.append(ZERO);
        }
        
        return temp.toString();
    }
    
    private String[] getAnswer(int n) {
        String[] answers = new String[n];
        
        for (int i = 0; i < n; i++) {
            StringBuilder result = new StringBuilder();
            
            for (int j = 0; j < n; j++) {
                char room1 = decodeArr1Results.get(i).charAt(j);
                char room2 = decodeArr2Results.get(i).charAt(j);
                
                if (room1 == BLANK_NUMBER && room2 == BLANK_NUMBER) {
                    result.append(BLANK);
                } 
        
                if (room1 == WALL_NUMBER || room2 == WALL_NUMBER) {
                    result.append(WALL);
                }
            }
            
            answers[i] = result.toString();
        }
        
        return answers;
    }
}

테스트 1 〉	통과 (1.28ms, 76.5MB)
테스트 2 〉	통과 (1.83ms, 73.7MB)
테스트 3 〉	통과 (1.25ms, 66.5MB)
테스트 4 〉	통과 (1.32ms, 73.8MB)
테스트 5 〉	통과 (1.73ms, 77.4MB)
테스트 6 〉	통과 (1.32ms, 73.4MB)
테스트 7 〉	통과 (1.29ms, 74.1MB)
테스트 8 〉	통과 (1.52ms, 75.6MB)
```

- 좀 오래 걸리네..

## 다른 사람의 풀이

```java
class Solution {
  public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        for (int i = 0; i < n; i++) {
            result[i] = String.format("%" + n + "s", result[i]);
            result[i] = result[i].replaceAll("1", "#");
            result[i] = result[i].replaceAll("0", " ");
        }

        return result;
    }
}
```

- replace 함수를 생각도 못했다 ㅋㅋㅋㅋㅋㅋㅋ아!!!!!!!!!!!!!
- `Integer.toBinaryString(arr1[i] | arr2[i]);`
    - ‘|’는 or 연산자라고 한다.. 잘 알아둬야지
- 여기서 + 대신 StringBuilder 쓰면 속도가 향상될 수도?
