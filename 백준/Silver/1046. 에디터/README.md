## 문제 링크

[1046. 에디터](https://www.acmicpc.net/problem/1406)

## 코드

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s = br.readLine();
        
        int m = Integer.parseInt(br.readLine());
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        
        // 맨 처음 위치는 문장의 맨 뒤에 커서가 위치해 있다.
        for (int i = 0; i < s.length(); i++) {
            left.push(s.charAt(i));
        }
        
        for (int i = 0; i < m; i++) {
            String[] command = br.readLine().split(" ");
            
            switch (command[0]) {
                case "L":
                    // 커서를 왼쪽으로 한 칸 이동한다.
                    // 즉, 왼쪽 커서의 문자를 오른쪽으로 이동하면 된다.
                    // 커서가 문장 맨 앞이면 무시한다.
                    if (left.size() > 0) {
                        char c = left.pop();
                        right.push(c);
                    }
                    break;
                    
                case "D":
                    // 커서를 오른쪽으로 한 칸 이동한다.
                    if (right.size() > 0) {
                        char c = right.pop();
                        left.push(c);
                    }
                    break;
                    
                case "B":
                    // 커서 왼쪽의 문자를 삭제한다.
                    if (left.size() > 0) {
                        left.pop();
                    }
                    break;
                    
                case "P":
                    // $라는 문자를 커서 왼쪽에 추가한다.
                    left.push(command[1].charAt(0));
                    break;
            }
        }
        
        // 왼쪽 -> 오른쪽으로 옮긴 후 print
        while (!left.isEmpty()) {
            char c = left.pop();
            right.push(c);
        }
        
        while (!right.isEmpty()) {
            bw.write(right.pop());
        }
        
        bw.close();     // 닫지 않으면 출력되지 않는다.
    }
}
```

## 풀이

### 어떤 알고리즘 / 자료구조를 사용했나요?

- stack
- 추가적으로 시간 제한이 까다롭기 때문에 출력할 때 bufferedWriter도 사용해야 한다.

### 해당 문제를 맞았다면 / 틀렸다면 어떻게 접근했나요?

- 커서의 위치를 기준으로 왼쪽 Stack, 오른쪽 Stack으로 나눈다.
- 맨 처음에는 문장의 맨 뒤에 커서가 위치해 있기 때문에 left 스택에 모든 문자를 넣는다.
- 이후 명령어에 따라 다음과 같이 로직을 처리한다.
    - L인 경우 커서를 왼쪽으로 한 칸 이동한다 → 왼쪽 커서의 문자를 오른쪽 스택으로 이동한다.
    - D인 경우 커서를 오른쪽으로 한 칸 이동한다. → 오른쪽 커서의 문자를 왼쪽 스택으로 이동한다.
    - B인 경우 커서의 왼쪽 문자를 삭제한다.
    - P인 경우 왼쪽 스택에 문자를 추가한다.
- 모든 명령 처리 이후 선입선출 특징을 위해 왼쪽 스택에 있는 문자열을 모두 오른쪽 스택으로 이동한다.
- 출력 시 right에 있는 문자열을 하나씩 꺼내 출력하면 된다.
