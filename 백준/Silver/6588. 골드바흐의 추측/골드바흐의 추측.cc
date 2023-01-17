#include <cstdio>

int main()
{
	int primes[1000];
	int nums[1000001];
	int n, ind, times, pp = 0;

	for (int i = 0; i <= 1000000; i++)
		nums[i] = 1;
	for (int i = 2; i <= 1000000; i = i + 2)
		nums[i] = 0;
	nums[1] = 0;

	primes[pp++] = 2;
	for (int i = 3; i <= 1000000; i = i + 2)
	{
		if (nums[i] == 1)
		{
			times = 2;
			primes[pp++] = i;
			while (i * times <= 1000000)
			{
				nums[i * times] = 0;
				times++;
			}
		}
	}

	pp--;
	int lp, rp, mid, sum;
	while (1)
	{
		scanf("%d", &n);
		if (n == 0)
			break;
		lp = 0;
		rp = pp;

		while (1)
		{
			mid = (lp + rp) / 2;
			if (mid == lp)
				break;
			if (primes[mid] > n)
				rp = mid;
			else if (primes[mid] < n)
				lp = mid;
			else
			{
				rp = mid;
				break;
			}
		}

		lp = 0;
		while (lp <= rp)
		{
			sum = primes[lp] + primes[rp];

			if (sum > n)
				rp--;
			else if (sum < n)
				lp++;
			else
				break;
		}
		if (sum == n)
			printf("%d = %d + %d\n", n, primes[lp], primes[rp]);
		else
			printf("Goldbach's conjecture is wrong.\n");
	}

	return 0;
}
