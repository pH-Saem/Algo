#include <cstdio>

double combination(int a, int b);

int main()
{
	int M, K, pebbles[50], temp, sum = 0;
	scanf("%d", &M);
	for (int i = 0; i < M; i++)
	{
		scanf("%d", &temp);
		sum += temp;
		pebbles[i] = temp;
	}
	scanf("%d", &K);

	double p = combination(sum, K);
	double q = 0;
	for (int i = 0; i < M; i++)
	{
		temp = pebbles[i];
		if (temp < K)
			continue;
		q += combination(temp, K);
	}

	double result = q / p;
	printf("%.15lf\n", result);

	return 0;
}

double combination(int a, int b)
{
	double p = 1, q = 1;
	if (a == b || b == 0)
		return 1;
	for (int i = 0; i < b; i++)
		p *= a--;
	for (int i = 1; i <= b; i++)
		q *= i;
	return p / q;
}