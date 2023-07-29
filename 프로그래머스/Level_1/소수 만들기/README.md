## **문제 설명**

주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.

## 제한사항

- nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
- nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.

---

## 입출력 예

| nums | result |
| --- | --- |
| [1,2,3,4] | 1 |
| [1,2,7,6,4] | 4 |

## 입출력 예 설명

**입출력 예 #1**

[1,2,4]를 이용해서 7을 만들 수 있습니다.

**입출력 예 #2**

[1,2,4]를 이용해서 7을 만들 수 있습니다.

[1,4,6]을 이용해서 11을 만들 수 있습니다.

[2,4,7]을 이용해서 13을 만들 수 있습니다.

[4,6,7]을 이용해서 17을 만들 수 있습니다.

## 풀이

- 조합 + 소수 판별 알고리즘
- 에라토스테네스의 체 쓰려고 했다가 적절한건 아닌거 같아서 빼버렸다.

## 코드

```java
class Solution {
    private final int MAX_NUM = 3;
    private int answer = 0;
    private int[] bucket;
    private boolean[] prime;
    
    public int solution(int[] nums) {
        bucket = new int[MAX_NUM];
        prime = new boolean[MAX_NUM];
        
        combination(nums, nums.length, MAX_NUM);
        return answer;
    }
    
    private void combination(int[] nums, int n, int r) {
        if (r == 0) {
            int sum = getSum(nums);
            
            if (isPrime(sum)) {
                answer++;
            }
            
            return;
        }
        
        int lastIndex = bucket.length - r - 1;
        int smallest = getSmallest(r, lastIndex);
        
        for (int i = smallest; i < n; i++) {
            bucket[lastIndex + 1] = i;
            combination(nums, n, r - 1);
        }
    }
    
    private int getSmallest(int r, int lastIndex) {
        if (bucket.length > r) {
            return bucket[lastIndex] + 1;
        }
        
        return 0;
    }
    
    private int getSum(int[] nums) {
        int sum = 0;
        
        for (int i = 0; i < bucket.length; i++) {
            sum += nums[bucket[i]];
        }
        
        return sum;
    }
    
    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        
        if (num == 2) {
            return true;
        }
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}

테스트 1 〉	통과 (0.66ms, 76.5MB)
테스트 2 〉	통과 (0.67ms, 76MB)
테스트 3 〉	통과 (0.42ms, 75.1MB)
테스트 4 〉	통과 (0.40ms, 70.3MB)
테스트 5 〉	통과 (0.68ms, 80MB)
테스트 6 〉	통과 (0.82ms, 75.8MB)
테스트 7 〉	통과 (0.13ms, 80.7MB)
테스트 8 〉	통과 (2.12ms, 72.3MB)
테스트 9 〉	통과 (0.48ms, 73.6MB)
테스트 10 〉	통과 (1.46ms, 84.4MB)
테스트 11 〉	통과 (0.08ms, 79MB)
테스트 12 〉	통과 (0.05ms, 83.6MB)
테스트 13 〉	통과 (0.13ms, 73.4MB)
테스트 14 〉	통과 (0.06ms, 76.1MB)
테스트 15 〉	통과 (0.08ms, 75.2MB)
테스트 16 〉	통과 (3.08ms, 74.1MB)
테스트 17 〉	통과 (1.16ms, 76.6MB)
테스트 18 〉	통과 (0.11ms, 76.1MB)
테스트 19 〉	통과 (0.04ms, 70.7MB)
테스트 20 〉	통과 (2.34ms, 77.2MB)
테스트 21 〉	통과 (2.43ms, 75.1MB)
테스트 22 〉	통과 (0.51ms, 76.5MB)
테스트 23 〉	통과 (0.04ms, 78.1MB)
테스트 24 〉	통과 (1.68ms, 80.7MB)
테스트 25 〉	통과 (1.72ms, 77.7MB)
테스트 26 〉	통과 (0.05ms, 71.1MB)
```
