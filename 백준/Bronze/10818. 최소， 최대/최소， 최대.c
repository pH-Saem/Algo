#include <stdio.h>

int main()
{
	int N, tmp, min = 0, max = 0;
	scanf("%d", &N);
	for (int i = 0; i < N; i++)
	{
		scanf("%d", &tmp);
		if (!i)
		{
			min = tmp;
			max = tmp;
		}
		if (tmp > max)
			max = tmp;
		if (tmp < min)
			min = tmp;
	}
	printf("%d %d", min, max);
	return 0;
}
