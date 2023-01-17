#include <cstdio>

int main()
{
	int N, K, count = 0, p, ind;
	int A[1001];
	scanf("%d %d", &N, &K);

	for (int i = 0; i <= N; i++)
		A[i] = 1;

	for (int i = 2; i <= N; i++)
	{
		if (A[i] == 1)
		{
			p = 1;
			while (p * i <= N)
			{
				ind = i * p;
				if (A[ind] == 1)
				{
					A[ind] = 0;
					count++;
				}
				if (count == K)
				{
					printf("%d\n", ind);
					break;
				}
				p++;
			}
			if (count == K)
				break;
		}
	}

	return 0;
}