## **문제 설명**

오래전 유행했던 콜라 문제가 있습니다. 콜라 문제의 지문은 다음과 같습니다.

> 정답은 아무에게도 말하지 마세요.
> 
> 
> 콜라 빈 병 2개를 가져다주면 콜라 1병을 주는 마트가 있다. 빈 병 20개를 가져다주면 몇 병을 받을 수 있는가?
> 
> 단, 보유 중인 빈 병이 2개 미만이면, 콜라를 받을 수 없다.
> 

문제를 풀던 상빈이는 콜라 문제의 완벽한 해답을 찾았습니다. 상빈이가 푼 방법은 아래 그림과 같습니다. 우선 콜라 빈 병 20병을 가져가서 10병을 받습니다. 받은 10병을 모두 마신 뒤, 가져가서 5병을 받습니다. 5병 중 4병을 모두 마신 뒤 가져가서 2병을 받고, 또 2병을 모두 마신 뒤 가져가서 1병을 받습니다. 받은 1병과 5병을 받았을 때 남은 1병을 모두 마신 뒤 가져가면 1병을 또 받을 수 있습니다. 이 경우 상빈이는 총 10 + 5 + 2 + 1 + 1 = 19병의 콜라를 받을 수 있습니다.

![https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/95ce1c11-2f21-4248-8bfc-e330299cbb9a/image6.PNG](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/95ce1c11-2f21-4248-8bfc-e330299cbb9a/image6.PNG)

문제를 열심히 풀던 상빈이는 일반화된 콜라 문제를 생각했습니다. 이 문제는 빈 병 `a`개를 가져다주면 콜라 `b`병을 주는 마트가 있을 때, 빈 병 `n`개를 가져다주면 몇 병을 받을 수 있는지 계산하는 문제입니다. 기존 콜라 문제와 마찬가지로, 보유 중인 빈 병이 `a`개 미만이면, 추가적으로 빈 병을 받을 순 없습니다. 상빈이는 열심히 고심했지만, 일반화된 콜라 문제의 답을 찾을 수 없었습니다. 상빈이를 도와, 일반화된 콜라 문제를 해결하는 프로그램을 만들어 주세요.

콜라를 받기 위해 마트에 주어야 하는 병 수 `a`, 빈 병 a개를 가져다 주면 마트가 주는 콜라 병 수 `b`, 상빈이가 가지고 있는 빈 병의 개수 `n`이 매개변수로 주어집니다. 상빈이가 받을 수 있는 콜라의 병 수를 return 하도록 solution 함수를 작성해주세요.

---

## 제한사항

- 1 ≤ `b` < `a` ≤ `n` ≤ 1,000,000
- 정답은 항상 int 범위를 넘지 않게 주어집니다.

---

## 입출력 예

| a | b | n | result |
| --- | --- | --- | --- |
| 2 | 1 | 20 | 19 |
| 3 | 1 | 20 | 9 |

---

## 입출력 예 설명

**입출력 예 #1**

- 본문에서 설명한 예시입니다.

**입출력 예 #2**

- 빈 병 20개 중 18개를 마트에 가져가서, 6병의 콜라를 받습니다. 이때 상빈이가 가지고 있는 콜라 병의 수는 8(20 – 18 + 6 = 8)개 입니다.
- 빈 병 8개 중 6개를 마트에 가져가서, 2병의 콜라를 받습니다. 이때 상빈이가 가지고 있는 콜라 병의 수는 4(8 – 6 + 2 = 4)개 입니다.
- 빈 병 4 개중 3개를 마트에 가져가서, 1병의 콜라를 받습니다. 이때 상빈이가 가지고 있는 콜라 병의 수는 2(4 – 3 + 1 = 2)개 입니다.
- 3번의 교환 동안 상빈이는 9(6 + 2 + 1 = 9)병의 콜라를 받았습니다.

## 풀이

### 문제 분석

- **빈 병 a 개를 가져다주면 콜라 b 병**을 주는 마트
    - 반례 a = 3, b = 2, n = 10 일 때를 생각해보자.
    - n % 3이 0이 아닌 경우엔 어떻게 해야할까?
    - 빈 병 10개를 가져가면 9개를 내고 6개를 받는다.
    - 남은 병은 갖고 있다가 나중에 더해준다.
- 단, 보유중인 빈 병이 a개 미만이면 추가적으로 받을 수 없다.
- 단순히 병을 빼면 안된다. 새 콜라를 받아오면 새로운 빈 병이 생길 수 있기 때문이다.
- 가져가고 **남은 병**에 대한 처리도 필요하다.

## 코드

### 실패한 코드

```java
class Solution {
    public int solution(int a, int b, int n) {
        int bottleNumber = n;
        int totalCola = 0;
        
        while (bottleNumber > a) {
            int takeBottle = bottleNumber - (bottleNumber % a);
            bottleNumber = (bottleNumber - takeBottle) + (takeBottle / a);
            totalCola += takeBottle / a;
            System.out.println("takeBottle: " + takeBottle);
            System.out.println("bottleNumber: " + bottleNumber);
        }
        
        return totalCola;
    }
}

takeBottle: 20
bottleNumber: 10
takeBottle: 10
bottleNumber: 5
takeBottle: 4
bottleNumber: 3
takeBottle: 2
bottleNumber: 2
```

- 남은 병에 대한 처리가 안 되어있다.

```java
class Solution {
    public int solution(int a, int b, int n) {
        int bottleNumber = n;
        int totalCola = 0;
        
        while (bottleNumber > a) {
            int takeBottle = bottleNumber - (bottleNumber % a);
            totalCola **+=** takeBottle / a;
            bottleNumber = (bottleNumber - takeBottle) + totalCola;
            System.out.println("takeBottle: " + takeBottle);
        }
        
        return totalCola;
    }
}

takeBottle: 20
takeBottle: 10
takeBottle: 14
takeBottle: 22
takeBottle: 34
takeBottle: 50
takeBottle: 74
takeBottle: 112
takeBottle: 168
takeBottle: 252
takeBottle: 378
takeBottle: 568
takeBottle: 850
takeBottle: 1276
takeBottle: 1914
takeBottle: 2872
takeBottle: 4306
takeBottle: 6460
takeBottle: 9690
takeBottle: 14536
takeBottle: 21802
takeBottle: 32704
takeBottle: 49056
takeBottle: 73584
takeBottle: 110376
takeBottle: 165564
takeBottle: 248346
takeBottle: 372520
takeBottle: 558778
takeBottle: 838168
takeBottle: 1257252
takeBottle: 1885878
takeBottle: 2828818
takeBottle: 4243226
takeBottle: 6364838
takeBottle: 9547258
takeBottle: 14320888
takeBottle: 21481330
takeBottle: 32221996
takeBottle: 48332994
takeBottle: 72499492
takeBottle: 108749236
takeBottle: 163123856
takeBottle: 244685782
takeBottle: 367028674
takeBottle: 550543012
takeBottle: 825814516
takeBottle: 1238721776
takeBottle: 1858082662
```

- totalCola는 계속 커지는데 자꾸 더해주니 값이 커진다!

```java
class Solution {
    public int solution(int a, int b, int n) {
        int bottleNumber = n;
        int totalCola = 0;
        
        while (bottleNumber >= a) {   // = 가 없어서 통과가 안됐었다..
            int takeBottle = bottleNumber - (bottleNumber % a);
            bottleNumber = (bottleNumber - takeBottle) + (takeBottle / a);
            totalCola += takeBottle / a;
        }
        
        return totalCola;
    }
}
```

- 입력 예는 다 통과하는데 돌려보니 모두 실패라고 떴다.
    - 생각해보니 b를 문제에서 사용하지 않았다.
