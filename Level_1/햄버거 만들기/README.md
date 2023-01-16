## **문제 설명**

햄버거 가게에서 일을 하는 상수는 햄버거를 포장하는 일을 합니다. 함께 일을 하는 다른 직원들이 햄버거에 들어갈 재료를 조리해 주면 조리된 순서대로 상수의 앞에 아래서부터 위로 쌓이게 되고, 상수는 순서에 맞게 쌓여서 완성된 햄버거를 따로 옮겨 포장을 하게 됩니다. 상수가 일하는 가게는 정해진 순서(아래서부터, 빵 – 야채 – 고기 - 빵)로 쌓인 햄버거만 포장을 합니다. 상수는 손이 굉장히 빠르기 때문에 상수가 포장하는 동안 속 재료가 추가적으로 들어오는 일은 없으며, 재료의 높이는 무시하여 재료가 높이 쌓여서 일이 힘들어지는 경우는 없습니다.

예를 들어, 상수의 앞에 쌓이는 재료의 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]일 때, 상수는 여섯 번째 재료가 쌓였을 때, 세 번째 재료부터 여섯 번째 재료를 이용하여 햄버거를 포장하고, 아홉 번째 재료가 쌓였을 때, 두 번째 재료와 일곱 번째 재료부터 아홉 번째 재료를 이용하여 햄버거를 포장합니다. 즉, 2개의 햄버거를 포장하게 됩니다.

상수에게 전해지는 재료의 정보를 나타내는 정수 배열 `ingredient`가 주어졌을 때, 상수가 포장하는 햄버거의 개수를 return 하도록 solution 함수를 완성하시오.

---

## 제한사항

- 1 ≤ `ingredient`의 길이 ≤ 1,000,000
- `ingredient`의 원소는 1, 2, 3 중 하나의 값이며, 순서대로 빵, 야채, 고기를 의미합니다.

---

## 입출력 예

| ingredient | result |
| --- | --- |
| [2, 1, 1, 2, 3, 1, 2, 3, 1] | 2 |
| [1, 3, 2, 1, 2, 1, 3, 1, 2] | 0 |

---

## 입출력 예 설명

**입출력 예 #1**

- 문제 예시와 같습니다.

**입출력 예 #2**

- 상수가 포장할 수 있는 햄버거가 없습니다.

## 풀이

### 문제 분석

- 햄버거의 순서는 빵 → 야채 → 고기 → 빵
    - 이 순서대로 쌓인 햄버거만 포장한다.
    - 즉, **1 → 2 → 3 → 1** **순서로 쌓인 경우에만 포장**할 수 있다.
- 1 = 빵, 2 = 야채, 3 = 고기
- 재료는 아래에서부터 위로 쌓이고, 순서에 맞게 쌓여서 완성된 햄버거를 따로 옮겨 포장한다.
- 두 번째 재료와 일곱 번째 재료부터 아홉 번째 재료를 이용하여 햄버거를 포장합니다. 즉, 2개의 햄버거를 포장하게 됩니다.
    - 즉 알맞은 순서로 나왔다면 거기서 꺼내고, 그 이전 인덱스부터 다시 순서가 진행된다면 햄버거를 포장한다.
- 해당 배열을 **문자열로 변환해서 푸는 방법과 스택을 사용하여 푸는 방법**이 있다.

### 첫번째 코드

```java
for (int i = 0; i < ingredient.length - 1; i++) {
  if (ingredient[i] == orders[ordersIndex]) {
      count++;
      ordersIndex++;
      System.out.println("isOrder: " + ingredient[i]);
  } else {
      count = 0;
      ordersIndex = 0;
      System.out.println("isNotOrder: " + ingredient[i]);
  }
  
  if (count == 4) {
      answer++;
  }
}
```

- 단순하게 증가만 생각하고 1이 두번 나오는 경우는 생각하지 못했다.
- 따라서 인덱스가 1인 경우는 그냥 증가시키게 두기로 했다.
- 그런데 위 문제에서 재료를 꺼내고 남은 배열에서 또 한번 돌았어야 했음을 깨달았다.

### 두번째 코드

```java
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    private final String ORDER = "1231";

    public int solution(int[] ingredient) {
        int answer = 0;
        int startIndex = 0;
        String temp = "";
        
        for (int i = 0; i < ingredient.length; i++) {
            temp += ingredient[i];
            
            if (temp.contains(ORDER)) {
                answer++;
                temp.replace(ORDER, "");
            }
        }
        
        return answer;
    }
}
```

- 문자열로 변환해서 해봤는데 문자 삭제가 안 먹힌다,,, 원인 모름

### 세번째 코드

```java
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    private final String ORDER = "1231";

    public int solution(int[] ingredient) {
        int answer = 0;
        int startIndex = 0;
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < ingredient.length; i++) {
            builder.append(ingredient[i]);
            
            // if (builder.toString().contains(ORDER)) {
            //     answer++;
            //     builder.replace(i - 3, i + 1, "");
            //     // builder.toString().replace(ORDER, "");  이건 잘 안되는 것 같다.
            // }
            
            startIndex = builder.toString().indexOf(ORDER);
            if (startIndex != -1) {
                answer++;
                builder.replace(startIndex, i + 4, "");
            }
        }
        
        return answer;
    }
}
```

- 실패는 없는데 시간초과가 나는 케이스들이 몇개 존재한다.

### 최종 코드

```java
import java.util.Stack;

class Solution {
    private final int[] ORDER = {1, 2, 3, 1};
    private Stack<Integer> ingredientStacks;
    
    public int solution(int[] ingredient) {
        ingredientStacks = new Stack<>();
        int answer = 0;
        
        for (int i = 0; i < ingredient.length; i++) {
            ingredientStacks.push(ingredient[i]);
            
            if (ingredientStacks.size() >= ORDER.length && checkOrder()) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean checkOrder() {
        int stackSize = ingredientStacks.size();
        
        if (ingredientStacks.get(stackSize - 1) == ORDER[3] 
            && ingredientStacks.get(stackSize - 2) == ORDER[2] 
            && ingredientStacks.get(stackSize - 3) == ORDER[1] 
            && ingredientStacks.get(stackSize - 4) == ORDER[0]) {
            ingredientStacks.pop();
            ingredientStacks.pop();
            ingredientStacks.pop();
            ingredientStacks.pop();
                    
            return true;
        }
        
        return false;
    }
}
```

- java Stack 클래스 사용
- 시간초과도 나지 않고 모두 통과됐다.
- 위 코드와의 차이점을 비교해봐야할 것 같다.
