## **문제 설명**

이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.

---

## 제한 조건

- n과 m은 각각 1000 이하인 자연수입니다.

---

## 예시

입력

```java
5 3
```

출력

```java
*****
*****
*****
```

## 풀이

```java
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

테스트 1 〉	통과 (166.17ms, 63.1MB)
테스트 2 〉	통과 (176.11ms, 68MB)
테스트 3 〉	통과 (224.33ms, 65MB)
테스트 4 〉	통과 (185.29ms, 67.2MB)
테스트 5 〉	통과 (206.01ms, 70MB)
테스트 6 〉	통과 (150.36ms, 65.6MB)
테스트 7 〉	통과 (180.35ms, 68.8MB)
테스트 8 〉	통과 (191.19ms, 79.7MB)
테스트 9 〉	통과 (357.73ms, 96.1MB)
테스트 10 〉	통과 (232.51ms, 73.9MB)
테스트 11 〉	통과 (286.52ms, 78MB)
```

```java
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        StringBuffer str = new StringBuffer();

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                str.append("*");
            }
            str.append("\n");
        }
        
        System.out.println(str.toString());
    }
}

테스트 1 〉	통과 (167.36ms, 68MB)
테스트 2 〉	통과 (184.43ms, 69.2MB)
테스트 3 〉	통과 (187.07ms, 68.9MB)
테스트 4 〉	통과 (167.78ms, 64.6MB)
테스트 5 〉	통과 (145.67ms, 69.2MB)
테스트 6 〉	통과 (153.08ms, 67.6MB)
테스트 7 〉	통과 (150.00ms, 65.6MB)
테스트 8 〉	통과 (152.73ms, 62.7MB)
테스트 9 〉	통과 (176.50ms, 62.6MB)
테스트 10 〉	통과 (133.12ms, 60.1MB)
테스트 11 〉	통과 (161.42ms, 67.8MB)
```
