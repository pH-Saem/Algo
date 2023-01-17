#include <cstdio>

int n;
long long A[100];

int main()
{
	scanf("%d", &n);

	A[0] = 0;
	A[1] = 1;
	A[2] = 1;
	for (int i = 2; i <= n; i++)
	{
		A[i] = A[i - 1] + A[i - 2];
	}
	printf("%lld\n", A[n]);

	return 0;
}
