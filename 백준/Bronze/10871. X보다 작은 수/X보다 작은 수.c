#include <stdio.h>

int main()
{
	int N, X, Y;
	scanf("%d %d", &N, &X);
	for (int i = 0; i < N; i++)
	{
		scanf("%d", &Y);
		if (X > Y)
			printf("%d ", Y);
	}

	return 0;
}