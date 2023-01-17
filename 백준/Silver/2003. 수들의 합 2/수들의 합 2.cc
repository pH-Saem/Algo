#include <cstdio>

int A[10000];
int M, N, sum, count;

int main()
{
	scanf("%d %d", &N, &M);

	for (int i = 0; i < N; i++)
	{
		scanf("%d", A + i);
	}

	int p = 0, q = 0;
	sum = 0;
	count = 0;
	for (; p < N; p++)
	{
		for (; q < N; q++)
		{
			if (sum == M)
				count++;
			else if (sum > M)
				break;
			sum += A[q];
		}
		if (sum == M)
			count++;
		sum -= A[p];
	}

	printf("%d\n", count);

	return 0;
}