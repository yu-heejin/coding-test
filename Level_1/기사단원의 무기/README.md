## **문제 설명**

숫자나라 기사단의 각 기사에게는 1번부터 `number`까지 번호가 지정되어 있습니다. 기사들은 무기점에서 무기를 구매하려고 합니다.

**각 기사는 자신의 기사 번호의 약수 개수에 해당하는 공격력을 가진 무기를 구매**하려 합니다. 단, 이웃나라와의 협약에 의해 공격력의 제한수치를 정하고, **제한수치보다 큰 공격력을 가진 무기를 구매해야 하는 기사는 협약기관에서 정한 공격력을 가지는 무기를 구매**해야 합니다.

예를 들어, 15번으로 지정된 기사단원은 15의 약수가 1, 3, 5, 15로 4개 이므로, 공격력이 4인 무기를 구매합니다. 만약, 이웃나라와의 협약으로 정해진 공격력의 제한수치가 3이고 제한수치를 초과한 기사가 사용할 무기의 공격력이 2라면, 15번으로 지정된 기사단원은 무기점에서 공격력이 2인 무기를 구매합니다. **무기를 만들 때, 무기의 공격력 1당 1kg의 철이 필요합니다. 그래서 무기점에서 무기를 모두 만들기 위해 필요한 철의 무게를 미리 계산하려 합니다.**

**기사단원의 수를 나타내는 정수 `number`와 이웃나라와 협약으로 정해진 공격력의 제한수치를 나타내는 정수 `limit`와 제한수치를 초과한 기사가 사용할 무기의 공격력을 나타내는 정수 `power`**가 주어졌을 때, 무기점의 주인이 무기를 모두 만들기 위해 필요한 철의 무게를 return 하는 solution 함수를 완성하시오.

---

## 제한사항

- 1 ≤ `number` ≤ 100,000
- 2 ≤ `limit` ≤ 100
- 1 ≤ `power` ≤ `limit`

---

## 입출력 예

---

## 입출력 예 설명

**입출력 예 #1**

1부터 5까지의 약수의 개수는 순서대로 [1, 2, 2, 3, 2]개입니다. 모두 공격력 제한 수치인 3을 넘지 않기 때문에 필요한 철의 무게는 해당 수들의 합인 10이 됩니다. 따라서 10을 return 합니다.

**입출력 예 #2**

1부터 10까지의 약수의 개수는 순서대로 [1, 2, 2, 3, 2, 4, 2, 4, 3, 4]개입니다. 공격력의 제한수치가 3이기 때문에, 6, 8, 10번 기사는 공격력이 2인 무기를 구매합니다. 따라서 해당 수들의 합인 21을 return 합니다.

## 풀이

### 문제 분리

- 각 기사는 자신의 번호의 약수 개수에 해당하는 공격력을 가진 무기를 구매한다.
    - 약수가 아니라 약수의 개수임에 유의하라.
- 이웃나라와의 협약에 의해 공격력의 제한 수치를 정하고, 제한 수치보다 큰 공격력을 가진 무기를 구매해야하는 기사는 협약 기관에서 정한 공격력을 가지는 무기를 사야한다.

### 알고리즘

- 기사단원의 수를 나타내는 정수 number → 1 ~ number 까지의 기사단원이 있다.
- 약수의 개수를 구하고 모두 리스트에 삽입

## 시간 초과 코드

```java
import java.util.List;
import java.util.ArrayList;

class Solution {
    private List<Integer> measures;
    private int totalKgSum;
    
    public int solution(int number, int limit, int power) {
        measures = new ArrayList<>();
        getMeasures(number);

        return getTotalKg(limit, power);
    }
    
    private void getMeasures(int number) {
        for (int i = 1; i <= number; i++) {
            int count = 0;
            count = getCount(count, i);
            
            measures.add(count);
        }
    }
    
    private int getCount(int count, int personNumber) {
        for (int j = 1; j <= personNumber; j++) {
            if (personNumber % j == 0) {
                count++;
            }
        }
        
        return count;
    }
    
    private int getTotalKg(int limit, int power) {
        totalKgSum = 0;
        
        for (int i = 0; i < measures.size(); i++) {
            totalKgSum += getKgSum(limit, power, i);
        }
        
        return totalKgSum;
    }
    
    private int getKgSum(int limit, int power, int index) {
        if (measures.get(index) > limit) {
            return power;
        }
        
        return measures.get(index);
    }
}

// 반복문 하나로 해결하고자 했으나 이 코드도 시간초과가 났다.
import java.util.List;
import java.util.ArrayList;

class Solution {
    private List<Integer> measureCounts;
    private int totalKgSum;
    
    public int solution(int number, int limit, int power) {
        measureCounts = new ArrayList<>();
        int count = 0;
        
        while (personNumber <= number) {
            if (personNumber % numberForDevide == 0) {
                count++;
            }
            
            numberForDevide++;
            
            if (numberForDevide > personNumber) {
                measures.add(count);
                numberForDevide = 1;
                personNumber++;
                count = 0;
            }
        }
        
        return totalKgSum;
    }
    
    private int getKgSum(int limit, int power) {
        if (measures.get(measuresIndex) > limit) {
            return power;
        }
        
        return measures.get(measuresIndex);
    }
}
```

- 약수를 절반까지만 구하고 * 2를 하면 된다! (1 제외)
- **약수는 제곱수를 제외하고는 각자 짝을 가지고 있음을 기억하라**
- 약수를 구하는 알고리즘은 절반만 구하는 방법이 있고 제곱근을 이용하는 방법이 있다. (개선된 알고리즘)
