#include <stdio.h>

int main()
{
	int N;
	scanf("%d", &N);
	for (int i = 1; i < N+1; i++)
	{
		for (int m = 0; m < N - i; m++)
			printf(" ");
		for (int j = 0; j < i; j++)
			printf("%c", '*');
		printf("\n");
	}

	return 0;
}