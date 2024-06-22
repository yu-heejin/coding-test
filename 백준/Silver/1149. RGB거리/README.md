## 문제 링크

[1149. RGB거리](https://www.acmicpc.net/problem/1149)

## 코드

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] costs = new int[n][3];
        
        // RGB 비용을 저장
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            
            for (int j = 0; j < 3; j++) {
                costs[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        int[][] dp = new int[n][3];
        
        // 첫번째 집까지 칠했을 때의 최소 비용
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        
        // 이후 집부터는 이전 집과의 조건을 비교한다.
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
        }
        
        // 최소값을 찾는다.
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[n-1][i]);
        }
        
        System.out.println(min);
    }
}
```
## 풀이

### 어떤 알고리즘 / 자료구조를 사용했나요?

- DP

### 해당 문제를 맞았다면 / 틀렸다면 어떻게 접근했나요?

- dp[i][j]: i번째 집까지 해당 색으로 칠했을 때의 최소 비용
- 인접한 집이랑 색이 같으면 안되기 때문에 이 부분 조건만 유의하면 쉽게 풀 수 있다.
