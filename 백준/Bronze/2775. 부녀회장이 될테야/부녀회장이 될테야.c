#include <stdio.h>
int main()
{
	int T, k, n, K[14] = { 0, };
	scanf("%d", &T);
	for (int o = 0; o < T; o++)
	{
		scanf("%d %d", &k, &n);
		for (int i = 0; i < n; i++)
			K[i] = i + 1;
		for (int i = 0; i < k; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (j == 0)
					continue;
				K[j] = K[j] + K[j - 1];
			}
		}
		if (n > 1)
			printf("%d\n", K[n - 1]);
		else
			printf("1\n");
		for (int i = 0; i < 14; i++)
			K[i] = 0;
	}
	return 0;
}