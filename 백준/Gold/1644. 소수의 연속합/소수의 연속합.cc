#include <cstdio>

bool nums[4000001];
int primes[300000];

int main()
{
	int pp = -1;
	int N;

	scanf("%d", &N);
    
    // 초기화
	for (int i = 0; i <= 4000000; i++)
		nums[i] = true;
    // 2를 제외한 짝수 걸러내기.
	for (int i = 4; i <= 4000000; i = i + 2)
		nums[i] = false;
	primes[++pp] = 2;

	int times;
	for (int i = 3; i <= 4000000; i = i + 2)
	{
		if (nums[i])
		{
			primes[++pp] = i;
			times = 2;
			while (times * i <= 4000000)
			{
				nums[times * i] = false;
				times++;
			}
		}
	}

	int lp = 0, rp = 0, count = 0, sum = 0;
	for (; rp <= pp; rp++)
	{
		if (primes[rp] > N)
			break;
		sum += primes[rp];
		if (sum > N)
		{
			for (; lp <= rp; lp++)
			{
				if (sum <= N)
					break;
				sum -= primes[lp];
			}
		}
		if (sum == N)
			count++;
	}
	
	printf("%d\n", count);
}