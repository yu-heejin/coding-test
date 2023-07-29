#include <stdio.h>
#include <stdlib.h>

int makeOne(int n, int *memo)
{
	int a, b, c;
	int min;

	if (n == 1) {   //1이면 더이상 할 필요가 없다
		return 0;
	}
	
	if (memo[n] == 0) {   //메모에 계산 횟수 최소값이 기록이 안 되어있다면
		if (n % 2 == 0 && n % 3 == 0) {   //n이 2나 3 둘 다 나눠진다면
			a = makeOne(n / 2, memo);
			b = makeOne(n / 3, memo);
			c = makeOne(n - 1, memo);
			//세 가지 경우에서 최솟값 비교

			if ((a >= b && b >= c) || (b >= a && a >= c)) {
				min = c;
			}
			else if ((a >= c && c >= b) || (c >= a && a >= b)) {
				min = b;
			}
			else {
				min = a;
			}

			if (memo[n / 2] == 0) {
				memo[n / 2] = a;
			}
			else if (memo[n / 3] == 0) {
				memo[n / 3] = b;
			}
			else if (memo[n - 1] == 0) {
				memo[n - 1] = c;
			}
			//메모에 값이 없으면 넣어줘라
		}
		else if (n % 2 == 0) {
			a = makeOne(n / 2, memo);
			c = makeOne(n - 1, memo);

			if (a > c) {
				min = c;
			}
			else {
				min = a;
			}

			if (memo[n / 2] == 0) {
				memo[n / 2] = a;
			}
			else if (memo[n - 1] == 0) {
				memo[n - 1] = c;
			}
		}
		else if (n % 3 == 0) {
			b = makeOne(n / 3, memo);
			c = makeOne(n - 1, memo);

			if (b > c) {
				min = c;
			}
			else {
				min = b;
			}

			 if (memo[n / 3] == 0) {
				memo[n / 3] = b;
			}
			else if (memo[n - 1] == 0) {
				memo[n - 1] = c;
			}
		}
		else {
			min = makeOne(n - 1, memo);
			if (memo[n - 1] == 0) {
				memo[n - 1] = min;
			}
		}
	}
	else {   //있으면 그냥 리턴해라
		return memo[n];
	}

	memo[n] = min + 1;  //최솟값에 계산횟수 1을 더해서
	return memo[n];   //리턴
}

int main(void)
{
	int num, i;
	int* memo;

	scanf("%d", &num);

	memo = (int*)malloc(sizeof(int) * (num + 1));
	for (i = 1; i <= num; i++)
		memo[i] = 0;

	printf("%d\n", makeOne(num, memo));
	free(memo);
}